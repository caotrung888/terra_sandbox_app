package dependencies

/**
 * Project test dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object TestDependencies {
    const val JUNIT = "junit:junit:${BuildDependenciesVersions.JUNIT}"
    const val JUNIT_EXT = "androidx.test.ext:junit:${BuildDependenciesVersions.JUNIT_EXT}"
    const val JUNIT_EXT_KTX = "androidx.test.ext:junit-ktx:${BuildDependenciesVersions.JUNIT_EXT}"
    const val TEST_RUNNER = "androidx.test:runner:${BuildDependenciesVersions.EXT}"
    const val TEST_CORE = "androidx.test:core:${BuildDependenciesVersions.EXT}"
    const val TEST_RULE = "androidx.test:rules:${BuildDependenciesVersions.TEST_RULE}"
    const val TEST_ORCHESTRATOR =
        "androidx.test:orchestrator:${BuildDependenciesVersions.ORCHESTRATOR}"
    const val TEST_EXT = "androidx.test.ext:junit:${BuildDependenciesVersions.EXT}"
    const val TEST_TRUTH = "androidx.test.ext:truth:${BuildDependenciesVersions.EXT_TRUTH}"
    const val ESPRESSO_CORE =
        "androidx.test.espresso:espresso-core:${BuildDependenciesVersions.ESPRESSO}"
    const val ESPRESSO_INTENT =
        "androidx.test.espresso:espresso-intents:${BuildDependenciesVersions.ESPRESSO}"
    const val ESPRESSO_CONTRIB =
        "androidx.test.espresso:espresso-contrib:${BuildDependenciesVersions.ESPRESSO}"
    const val ARCH_TESTING =
        "androidx.arch.core:core-testing:${BuildDependenciesVersions.ARCH_TESTING}"
    const val MOCKITO_CORE = "org.mockito:mockito-core:${BuildDependenciesVersions.MOCKITO}"
    const val MOCKITO_INLINE = "org.mockito:mockito-inline:${BuildDependenciesVersions.MOCKITO}"
    const val ROBOLECTRIC = "org.robolectric:robolectric:${BuildDependenciesVersions.ROBOLECTRIC}"
    const val COROUTINE_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${BuildDependenciesVersions.COROUTINES}"
    const val WORK_TEST =
        "androidx.work:work-testing:${BuildDependenciesVersions.WORK_MANAGER}"
    const val MOCK_WEB_SERVER =
        "com.squareup.okhttp3:mockwebserver:${BuildDependenciesVersions.OKHTTP}"
    const val JIRA_TEST_JUNIT4 =
        "vn.teko.java.test:jira-test-junit4:${BuildDependenciesVersions.JIRA_TEST_JUNIT4}"

    object Server {
        const val SPRING_TEST =
            "org.springframework.boot:spring-boot-starter-test"
        const val SPRING_MOCKK =
            "com.ninja-squad:springmockk:${TestDependenciesVersions.SPRING_MOCKK}"
        const val REACTOR_TEST =
            "io.projectreactor:reactor-test"
        const val KOTLIN_COROUTINES_TEST =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${TestDependenciesVersions.KOTLIN_COROUTINES}"
        const val OKHTTP =
            "com.squareup.okhttp3:okhttp:${TestDependenciesVersions.OKHTTP}"
        const val MOCK_WEBSERVER =
            "com.squareup.okhttp3:mockwebserver:${TestDependenciesVersions.OKHTTP}"
    }

    object Domain {
        const val KOTLIN_COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${TestDependenciesVersions.KOTLIN_COROUTINES}"
        const val JUNIT =
            "junit:junit:${TestDependenciesVersions.JUNIT}"
    }

    object Android {
        const val JUNIT =
            "junit:junit:${TestDependenciesVersions.JUNIT}"
        const val ESPRESSO =
            "androidx.test.espresso:espresso-core:${TestDependenciesVersions.ESPRESSO}"
    }

    object Core {
        const val KTOR_CLIENT_MOCK =
            "io.ktor:ktor-client-mock:${TestDependenciesVersions.KTOR}"

        const val ANDROID_TEST_CORE =
            "androidx.test:core:${TestDependenciesVersions.ANDROID_TEST_CORE}"
        const val ANDROID_TEST_EXT =
            "androidx.test.ext:junit:${TestDependenciesVersions.ANDROID_TEST_EXT}"
        const val ROBOLECTRIC =
            "org.robolectric:robolectric:${TestDependenciesVersions.ROBOLECTRIC}"
        const val KOTLIN_COROUTINES_TEST =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${TestDependenciesVersions.KOTLIN_COROUTINES}"
    }
}

/**
 * Configuration version of all test dependencies
 */

object TestDependenciesVersions {
    const val SPRING_MOCKK = "3.0.1"
    const val KOTLIN_COROUTINES = "1.4.3-native-mt"
    const val JUNIT = "4.13.2"
    const val OKHTTP = "4.9.0"
    const val ESPRESSO = "3.3.0"
    const val KTOR = "1.5.2"
    const val ANDROID_TEST_CORE = "1.3.0"
    const val ANDROID_TEST_EXT = "1.1.2"
    const val ROBOLECTRIC = "4.4"
}