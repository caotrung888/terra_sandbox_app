package task.makelocationdata

import com.google.gson.GsonBuilder
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream
import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.zip.GZIPOutputStream

// DefaultTask is the standard Task implementation. You can extend this to implement your own task types.
open class MakeLocationData :
    DefaultTask() { // Keep the file open otherwise gradle won't be able to generate the proxy class.

    private val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    init {
        group = "make data" // This will be the group name for your task.
        description = "Download location file from logistic & convert to compact asset files"
    }

    @TaskAction // Marks a function as the action to run when the task is executed.
    fun run() {
        println("Start making location data!")

        println("Downloading from $SOURCE_DATA_URL...")
        val input: InputStream = URL(SOURCE_DATA_URL).openStream()
        val content = input.bufferedReader(Charsets.UTF_8).use { it.readText() }

        println("Parsing data...")
        val areas = gson.fromJson(content, Areas::class.java)

        writeHierarchyAreaAsset(areas)

    }

    private fun writeHierarchyAreaAsset(areas: Areas) {
        val fileName = "$DEST_ASSET_FOLDER/$DEST_AREAS_ASSET_FILE"
        val provincesOutput = File(fileName)

        val hierarchyAreas = mutableMapOf<String, HierarchyArea>()
        areas.data.filter { it.parentCode == null }.forEach { province ->

            val districts = mutableMapOf<String, HierarchyArea>()

            areas.data.filter { it.parentCode == province.code }.forEach { district ->
                val wards = mutableMapOf<String, HierarchyArea>()
                areas.data.filter { it.parentCode == district.code }.forEach { ward ->
                    wards[ward.code] = HierarchyArea(name = ward.name)
                }

                districts[district.code] =
                    HierarchyArea(
                        name = district.name,
                        children = wards
                    )
            }

            hierarchyAreas[province.code] = HierarchyArea(
                name = province.name,
                children = districts
            )
        }

        println("Writing $fileName...")
        provincesOutput.writeBytes(gzipString(gson.toJson(hierarchyAreas)))
    }

    private fun gzipString(source: String): ByteArray {
        val out = ByteArrayOutputStream()
        val gzip = GZIPOutputStream(out)
        gzip.write(source.toByteArray(StandardCharsets.UTF_8))
        gzip.close()

        val result = out.toByteArray()
        out.close()

        return result
    }


    companion object {
        const val SOURCE_DATA_URL = "https://logistics.tekoapis.com/api/thirdparty/areas"
        const val DEST_ASSET_FOLDER =
            "service-location/service-location-android/src/main/assets"

        const val DEST_AREAS_ASSET_FILE = "areas"
    }
}