package extensions

import dependencies.TekoArtifacts
import groovy.util.Node
import org.gradle.api.Project
import org.gradle.api.XmlProvider
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ExcludeRule
import org.gradle.api.artifacts.ModuleDependency

/**
 * Adds "implementation" and "api" dependencies of a module into a "dependencies" xml node.
 */
fun XmlProvider.collectDependencies(project: Project, flavor: String) {
    var apis = project.getConfigurationDependencies("api")
    var impls = project.getConfigurationDependencies("implementation")
    if (flavor.isNotEmpty()) {
        apis = apis + project.getConfigurationDependencies("${flavor}Api")
        impls = impls + project.getConfigurationDependencies("${flavor}Implementation")
    }
    impls = impls.filter { it !in apis }

    if (apis.isNotEmpty() || impls.isNotEmpty()) asNode().appendDependencies(apis, impls)
}

private fun Node.appendDependencies(
    apis: List<Dependency>,
    impls: List<Dependency>
) = appendNode("dependencies").apply {
    fun Dependency.isValid() = group != null && version != null && name != "unspecified"

    apis.filter { it.isValid() }.forEach { appendDependency(it, "compile") }
    impls.filter { it.isValid() }.forEach { appendDependency(it, "runtime") }
}

private fun Node.appendDependency(
    dep: Dependency,
    scope: String
) = appendNode("dependency").apply {
    appendNode("groupId", dep.group)
    appendNode("artifactId", dep.name)
    appendNode("version", makeVersionDynamic(dep, VersionDependencyMode.DynamicMinor))
    appendNode("scope", scope)

    if (dep is ModuleDependency && dep.excludeRules.isNotEmpty()) appendExclusions(dep)
}

private fun Node.appendExclusions(
    dep: ModuleDependency
) = appendNode("exclusions").apply {
    dep.excludeRules.forEach { appendExclusion(it) }
}

private fun Node.appendExclusion(
    excludeRule: ExcludeRule
) = appendNode("exclusion").apply {
    appendNode("groupId", excludeRule.group ?: "*")
    appendNode("artifactId", excludeRule.module ?: "*")
}

private enum class VersionDependencyMode {
    DynamicMinor,
    DynamicPatch,
    Exact
}

private val DYNAMIC_VERSION_TOKENS = listOf("[", "]", "(", ")", ".+")
private val WHITELIST_KEYWORDS = listOf("-dev", "-stage", "-prod", "-debug")
private val WHITELIST_DEPENDENCIES = listOf(
    TekoArtifacts.FOOTPRINT_DTO
)

private fun makeVersionDynamic(dep: Dependency, mode: VersionDependencyMode): String? {
    val exactVersion = dep.version
    val isTekoPackage = dep.group?.contains("teko") ?: false
    val isDynamicVersionAlready = DYNAMIC_VERSION_TOKENS.any { exactVersion?.contains(it) == true }
    val hasWhitelistKeywords = WHITELIST_KEYWORDS.any { exactVersion?.contains(it) == true }
    val isWhitelistDeps = WHITELIST_DEPENDENCIES.any { "${dep.group}:${dep.name}" == it }

    return if (exactVersion == null || !isTekoPackage || isDynamicVersionAlready || hasWhitelistKeywords || isWhitelistDeps) {
        exactVersion
    } else {
        val firstDotIdx = exactVersion.indexOf('.')
        return if (firstDotIdx != -1) {
            val majorVersion = exactVersion.substring(0, firstDotIdx)
            when (mode) {
                VersionDependencyMode.DynamicMinor -> "${majorVersion}.+"
                VersionDependencyMode.DynamicPatch -> {
                    val secondDotIdx = exactVersion.indexOf('.', firstDotIdx + 1)
                    if (secondDotIdx != -1) {
                        val minorVersion = exactVersion.substring(0, secondDotIdx)
                        "${minorVersion}.+"
                    } else exactVersion
                }
                else -> exactVersion
            }
        } else exactVersion
    }
}