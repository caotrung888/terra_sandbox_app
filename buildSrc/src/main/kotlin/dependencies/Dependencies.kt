package dependencies

object Dependencies {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${BuildDependenciesVersions.KOTLIN}"
    const val COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependenciesVersions.COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependenciesVersions.COROUTINES}"
    const val CORE_KTX = "androidx.core:core-ktx:${BuildDependenciesVersions.CORE_KTX}"

    const val RECYCLER_VIEW =
        "androidx.recyclerview:recyclerview:${BuildDependenciesVersions.RECYCLER_VIEW}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersions.APPCOMPAT}"
    const val FRAGMENT = "androidx.fragment:fragment-ktx:${BuildDependenciesVersions.FRAGMENT}"
    const val NAVIGATION =
        "androidx.navigation:navigation-fragment-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val NAVIGATION_UI =
        "androidx.navigation:navigation-ui-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val CONSTRAIN_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersions.CONSTRAIN_LAYOUT}"
    const val RECYLERVIEW =
        "androidx.recyclerview:recyclerview:${BuildDependenciesVersions.REYCLERVIEW}"
    const val MATERIAL_COMPONENTS =
        "com.google.android.material:material:${BuildDependenciesVersions.MATERIAL_COMPONENTS}"
    const val FLEX_BOX = "com.google.android.flexbox:flexbox:${BuildDependenciesVersions.FLEX_BOX}"
    const val SPINNER_DATE_PICKER =
        "com.github.drawers:SpinnerDatePicker:${BuildDependenciesVersions.SPINNER_DATE_PICKER}"
    const val SHIMMER_FRAME_LAYOUT =
        "com.facebook.shimmer:shimmer:${BuildDependenciesVersions.SHIMMER_FRAME_LAYOUT}"
    const val MULTIDEX = "androidx.multidex:multidex:${BuildDependenciesVersions.MULTIDEX}"
    const val LIFECYCLE_VIEWMODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA =
        "androidx.lifecycle:lifecycle-livedata-ktx:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME =
        "androidx.lifecycle:lifecycle-runtime-ktx:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_COMMON_JAVA8 =
        "androidx.lifecycle:lifecycle-common-java8:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_PROCESS =
        "androidx.lifecycle:lifecycle-process:${BuildDependenciesVersions.LIFECYCLE}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${BuildDependenciesVersions.RETROFIT}"
    const val RETROFIT_CONVERTER =
        "com.squareup.retrofit2:converter-gson:${BuildDependenciesVersions.RETROFIT}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${BuildDependenciesVersions.OKHTTP}"
    const val OKHTTP_LOGGING =
        "com.squareup.okhttp3:logging-interceptor:${BuildDependenciesVersions.OKHTTP}"
    const val GSON = "com.google.code.gson:gson:${BuildDependenciesVersions.GSON}"
    const val ROOM = "androidx.room:room-ktx:${BuildDependenciesVersions.ROOM}"
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${BuildDependenciesVersions.ROOM}"
    const val TIMBER = "com.jakewharton.timber:timber:${BuildDependenciesVersions.TIMBER}"
    const val DAGGER = "com.google.dagger:dagger:${BuildDependenciesVersions.DAGGER}"
    const val DAGGER_ANDROID =
        "com.google.dagger:dagger-android-support:${BuildDependenciesVersions.DAGGER}"
    const val WORK_MANAGER =
        "androidx.work:work-runtime-ktx:${BuildDependenciesVersions.WORK_MANAGER}"

    const val ZXING = "com.google.zxing:core:${BuildDependenciesVersions.ZXING}"
    const val ZXING_ANDROID_CORE =
        "com.google.zxing:android-core:${BuildDependenciesVersions.ZXING_ANDROID}"
    const val SWIPE_REFRESH_LAYOUT =
        "androidx.swiperefreshlayout:swiperefreshlayout:${BuildDependenciesVersions.SWIPE_REFRESH}"
    const val PAGING = "androidx.paging:paging-runtime-ktx:${BuildDependenciesVersions.PAGING}"
    const val PAGING_3 = "androidx.paging:paging-runtime-ktx:${BuildDependenciesVersions.PAGING_3}"
    const val GLIDE = "com.github.bumptech.glide:glide:${BuildDependenciesVersions.GLIDE}"
    const val CARDVIEW = "androidx.cardview:cardview:${BuildDependenciesVersions.CARDVIEW}"
    const val EPOXY = "com.airbnb.android:epoxy:${BuildDependenciesVersions.EPOXY}"
    const val EPOXY_PAGING = "com.airbnb.android:epoxy-paging:${BuildDependenciesVersions.EPOXY}"
    const val EPOXY_DATA_BINDING =
        "com.airbnb.android:epoxy-databinding:${BuildDependenciesVersions.EPOXY}"

    const val EXOPLAYER_CORE =
        "com.google.android.exoplayer:exoplayer-core:${BuildDependenciesVersions.EXOPLAYER}"
    const val EXOPLAYER_DASH =
        "com.google.android.exoplayer:exoplayer-dash:${BuildDependenciesVersions.EXOPLAYER}"
    const val EXOPLAYER_UI =
        "com.google.android.exoplayer:exoplayer-ui:${BuildDependenciesVersions.EXOPLAYER}"

    const val FIREBASE_ANALYTIC =
        "com.google.firebase:firebase-analytics:${BuildDependenciesVersions.FIREBASE_ANALYTIC}"
    const val FIREBASE_CRASHLYTIC =
        "com.google.firebase:firebase-crashlytics:${BuildDependenciesVersions.FIREBASE_CRASHLYTIC}"
    const val FIREBASE_DATABASE =
        "com.google.firebase:firebase-database-ktx:${BuildDependenciesVersions.FIREBASE_DATABASE}"
    const val FIREBASE_MESSAGING =
        "com.google.firebase:firebase-messaging:${BuildDependenciesVersions.FIREBASE_MESSAGING}"
    const val FIREBASE_AUTH =
        "com.google.firebase:firebase-auth:${BuildDependenciesVersions.FIREBASE_AUTH}"
    const val FIREBASE_PERF =
        "com.google.firebase:firebase-perf:${BuildDependenciesVersions.FIREBASE_PERF}"
    const val FIREBASE_REMOTE_CONFIG =
        "com.google.firebase:firebase-config:${BuildDependenciesVersions.FIREBASE_REMOTE_CONFIG}"
    const val FIREBASE_FIRESTORE =
        "com.google.firebase:firebase-firestore-ktx:${BuildDependenciesVersions.FIREBASE_FIRESTORE}"
    const val FIREBASE_DYNAMIC_LINK =
        "com.google.firebase:firebase-dynamic-links-ktx:${BuildDependenciesVersions.FIREBASE_DYNAMIC_LINK}"
    const val FIREBASE_BOM = "com.google.firebase:firebase-bom:${BuildDependenciesVersions.FIREBASE_BOM}"

    const val GOOGLE_PLAY_SERVICE_LOCATION =
        "com.google.android.gms:play-services-location:${BuildDependenciesVersions.GOOGLE_PLAY_SERVICES}"

    const val CAMERA_VIEW = "com.otaliastudios:cameraview:${BuildDependenciesVersions.CAMERA_VIEW}"

    const val CAMERAX_CAMERA2 = "androidx.camera:camera-camera2:${BuildDependenciesVersions.CAMERAX_CAMERA2}"
    const val CAMERAX_CORE = "androidx.camera:camera-core:${BuildDependenciesVersions.CAMERAX_CORE}"
    const val CAMERAX_LIFECYCLE = "androidx.camera:camera-lifecycle:${BuildDependenciesVersions.CAMERAX_LIFECYCLE}"
    const val CAMERAX_VIEW = "androidx.camera:camera-view:${BuildDependenciesVersions.CAMERAX_VIEW}"

    const val IMAGE_PICKER_VIEW =
        "com.github.esafirm.android-image-picker:imagepicker:${BuildDependenciesVersions.IMAGE_PICKER_VIEW}"
    const val RX_IMAGE_PICKER_VIEW =
        "com.github.esafirm.android-image-picker:rximagepicker:${BuildDependenciesVersions.IMAGE_PICKER_VIEW}"

    const val FIREBASE_ML_KIT =
        "com.google.firebase:firebase-ml-vision:${BuildDependenciesVersions.MLKIT}"
    const val FIREBASE_ML_KIT_BARCODE_MODEL =
        "com.google.firebase:firebase-ml-vision-barcode-model:${BuildDependenciesVersions.MLKIT_BARCODE_MODEL}"
    const val GOOGLE_ML_KIT_BARCODE_SCANNING =
        "com.google.mlkit:barcode-scanning:${BuildDependenciesVersions.GOOGLE_BARCODE_SCANNING}"
    const val GOOGLE_ML_KIT_BARCODE_MODEL =
        "com.google.android.gms:play-services-mlkit-barcode-scanning:${BuildDependenciesVersions.GOOGLE_BARCODE_MODEL}"

    const val COROUTINE_PLAY_SERVICE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${BuildDependenciesVersions.COROUTINE_PLAY_SERVICE}"

    const val SUNMI_PRINTER = "com.sunmi:printerlibrary:${BuildDependenciesVersions.SUNMI_PRINTER}"

    const val MP_CHART = "com.github.PhilJay:MPAndroidChart:v${BuildDependenciesVersions.MP_CHART}"

    const val MAP_STRUCT = "org.mapstruct:mapstruct:${BuildDependenciesVersions.MAP_STRUCT}"
    const val MAP_STRUCT_KOTLIN_BUILDER =
        "com.github.pozo:mapstruct-kotlin:${BuildDependenciesVersions.MAP_STRUCT_KOTLIN_BUILDER}"

    const val JSC_FLAVOR = "org.webkit:android-jsc:${BuildDependenciesVersions.JSC_FLAVOR}"

    const val PHOTO_VIEW = "com.github.chrisbanes:PhotoView:${BuildDependenciesVersions.PHOTO_VIEW}"

    const val AUTO_SERVICE =
        "com.google.auto.service:auto-service:${BuildDependenciesVersions.AUTO_SERVICE}"
    const val KOTLIN_POET = "com.squareup:kotlinpoet:${BuildDependenciesVersions.KOTLIN_POET}"

    const val KODEIN_DI =
        "org.kodein.di:kodein-di:${BuildDependenciesVersions.KODEIN_DI}"
    const val KODEIN_CONFIGURABLE =
        "org.kodein.di:kodein-di-conf:${BuildDependenciesVersions.KODEIN_DI}"

    const val PLAY_SERVICES_AUTH =
        "com.google.android.gms:play-services-auth:${BuildDependenciesVersions.PLAY_SERVICES_AUTH}"

    const val FACEBOOK_AUTH =
        "com.facebook.android:facebook-login:${BuildDependenciesVersions.FACEBOOK_AUTH}"

    const val REACT_NATIVE =
        "com.facebook.react:react-native:${BuildDependenciesVersions.REACT_NATIVE}"

    const val REACT_NATIVE_0_61_PLUS =
        "com.facebook.react:react-native:${BuildDependenciesVersions.REACT_NATIVE_0_61_PLUS}"

    const val PLAY_CORE = "com.google.android.play:core:${BuildDependenciesVersions.PLAY_CORE}"
    const val PLAY_CORE_KTX =
        "com.google.android.play:core-ktx:${BuildDependenciesVersions.PLAY_CORE_KTX}"
    const val PROTOBUF_JAVA =
        "com.google.protobuf:protobuf-java:${BuildDependenciesVersions.PROTOBUF}"
    const val PROTOBUF_JAVA_UTIL =
        "com.google.protobuf:protobuf-java-util:${BuildDependenciesVersions.PROTOBUF}"

    const val DESUGAR_JDK_LIBS =
        "com.android.tools:desugar_jdk_libs:${BuildDependenciesVersions.DESUGAR_JDK_LIBS}"

    const val HILT_ANDROID =
        "com.google.dagger:hilt-android:${DependenciesVersions.HILT}"

    const val SHORTCUT_BADGE = "me.leolin:ShortcutBadger:${BuildDependenciesVersions.SHORTCUT_BADGE}"

    const val TRIPI_FLIGHT_CONNECTOR_DEV = "vn.teko.hestia.connector:tripi-flight:${BuildDependenciesVersions.TRIPI_FLIGHT_DEV}"
    const val TRIPI_FLIGHT_CONNECTOR_PROD = "vn.teko.hestia.connector:tripi-flight:${BuildDependenciesVersions.TRIPI_FLIGHT_PROD}"
    const val TRIPI_HOTEL_CONNECTOR_DEV = "vn.teko.hestia.connector:tripi-hotel:${BuildDependenciesVersions.TRIPI_HOTEL_DEV}"
    const val TRIPI_HOTEL_CONNECTOR_PROD = "vn.teko.hestia.connector:tripi-hotel:${BuildDependenciesVersions.TRIPI_HOTEL_PROD}"
    const val TRIPI_PREPAID_CONNECTOR_DEV = "vn.teko.hestia.connector:tripi-prepaid:${BuildDependenciesVersions.TRIPI_PREPAID_DEV}"
    const val TRIPI_PREPAID_CONNECTOR_PROD = "vn.teko.hestia.connector:tripi-prepaid:${BuildDependenciesVersions.TRIPI_PREPAID_PROD}"

    object Domain {
        const val KOTLIN_COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${DependenciesVersions.KOTLIN_COROUTINES}"
        const val KOTLIN_SERIALIZATION =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${DependenciesVersions.KOTLIN_SERIALIZATION}"
        const val KOTLIN_DATE_TIME =
            "org.jetbrains.kotlinx:kotlinx-datetime:${DependenciesVersions.KOTLIN_DATE_TIME}"
    }

    object Core {
        const val KTOR_CLIENT =
            "io.ktor:ktor-client-core:${DependenciesVersions.KTOR}"
        const val KTOR_CLIENT_JSON =
            "io.ktor:ktor-client-json:${DependenciesVersions.KTOR}"
        const val KTOR_CLIENT_LOGGING =
            "io.ktor:ktor-client-logging:${DependenciesVersions.KTOR}"
        const val KTOR_CLIENT_SERIALIZATION =
            "io.ktor:ktor-client-serialization:${DependenciesVersions.KTOR}"
        const val KTOR_CLIENT_OKHTTP =
            "io.ktor:ktor-client-okhttp:${DependenciesVersions.KTOR}"
        const val KTOR_CLIENT_IOS =
            "io.ktor:ktor-client-ios:${DependenciesVersions.KTOR}"

        const val KODEIN_DI =
            "org.kodein.di:kodein-di:${DependenciesVersions.KODEIN_DI}"
        const val KODEIN_CONFIGURABLE =
            "org.kodein.di:kodein-di-conf:${DependenciesVersions.KODEIN_DI}"

        const val LOGGER =
            "ch.qos.logback:logback-classic:${DependenciesVersions.LOGGER}"

        const val SQL_DELIGHT =
            "com.squareup.sqldelight:runtime:${DependenciesVersions.SQL_DELIGHT}"
        const val SQL_DELIGHT_ANDROID =
            "com.squareup.sqldelight:android-driver:${DependenciesVersions.SQL_DELIGHT}"
        const val SQL_DELIGHT_IOS =
            "com.squareup.sqldelight:native-driver:${DependenciesVersions.SQL_DELIGHT}"
        const val SQL_DELIGHT_COROUTINE =
            "com.squareup.sqldelight:coroutines-extensions:${DependenciesVersions.SQL_DELIGHT}"

        const val STATELY_COMMON =
            "co.touchlab:stately-common:${DependenciesVersions.STATELY_COMMON}"
        const val STATELY_CONCURRENCY =
            "co.touchlab:stately-concurrency:${DependenciesVersions.STATELY_CONCURRENCY}"
        const val NAPIER_LOGGER = "io.github.aakira:napier:${DependenciesVersions.NAPIER_LOGGER}"
    }

    object Server {
        const val KOTLIN =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${DependenciesVersions.KOTLIN}"
        const val KOTLIN_REFLECT =
            "org.jetbrains.kotlin:kotlin-reflect:${DependenciesVersions.KOTLIN}"
        const val KOTLIN_COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${DependenciesVersions.KOTLIN_COROUTINES}"
        const val KOTLIN_COROUTINES_REACTOR =
            "org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${DependenciesVersions.KOTLIN_COROUTINES}"
        const val KOTLIN_SERIALIZATION =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${DependenciesVersions.KOTLIN_SERIALIZATION}"
        const val KOTLIN_DATE_TIME =
            "org.jetbrains.kotlinx:kotlinx-datetime:${DependenciesVersions.KOTLIN_DATE_TIME}"

        const val SPRING_WEBFLUX =
            "org.springframework.boot:spring-boot-starter-webflux"
        const val SPRING_BOOT_STARTER_ACTUATOR =
            "org.springframework.boot:spring-boot-starter-actuator"
        const val SPRINGDOC_OPENAPI_WEBFLUX_UI =
            "org.springdoc:springdoc-openapi-webflux-ui:${DependenciesVersions.SPRINGDOC}"
        const val MICROMETER_REGISTRY_PROMETHEUS =
            "io.micrometer:micrometer-registry-prometheus:${DependenciesVersions.MICROMETER_REGISTRY_PROMETHEUS}"


        const val SPRING_DATA_R2DBC =
            "org.springframework.boot:spring-boot-starter-data-r2dbc"
        const val SPRING_DATA_REDIS_REACTIVE =
            "org.springframework.boot:spring-boot-starter-data-redis-reactive"

        const val REACTOR_KOTLIN =
            "io.projectreactor.kotlin:reactor-kotlin-extensions"

        const val JWT =
            "com.auth0:java-jwt:${DependenciesVersions.JWT}"

        const val WIRE_CLIENT =
            "com.squareup.wire:wire-grpc-client:${DependenciesVersions.WIRE}"
        const val WIRE_KOTLIN_SERIALIZATION =
            "com.squareup.wire:wire-kotlin-serialization:${DependenciesVersions.WIRE}"
        const val OKHTTP =
            "com.squareup.okhttp3:okhttp:${DependenciesVersions.OKHTTP}"
        const val OKHTTP_LOGGING_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor:${DependenciesVersions.OKHTTP}"
    }

    object Docs {
        const val SPRINGDOC_OPENAPI_KOTLIN =
            "org.springdoc:springdoc-openapi-kotlin:${DependenciesVersions.SPRINGDOC}"
    }

    object Android {
        const val FAST_ADAPTER =
            "com.mikepenz:fastadapter:${DependenciesVersions.FAST_ADAPTER}"
        const val FAST_ADAPTER_BINDING =
            "com.mikepenz:fastadapter-extensions-binding:${DependenciesVersions.FAST_ADAPTER}"
        const val FAST_ADAPTER_DIFF =
            "com.mikepenz:fastadapter-extensions-diff:${DependenciesVersions.FAST_ADAPTER}"
        const val FAST_ADAPTER_EXT =
            "com.mikepenz:fastadapter-extensions-ui:${DependenciesVersions.FAST_ADAPTER}"

        const val COIL =
            "io.coil-kt:coil:${DependenciesVersions.COIL}"
        const val COIL_COMPOSE =
            "io.coil-kt:coil-compose:${DependenciesVersions.COIL}"
        // TODO : reuse Kodein
        const val DAGGER_COMPILER =
            "com.google.dagger:dagger-compiler:${DependenciesVersions.DAGGER_COMPILER}"
        const val DAGGER_PROCESSOR =
            "com.google.dagger:dagger-android-processor:${DependenciesVersions.DAGGER_COMPILER}"

        // lifecycle
        const val LIFECYCLE_VIEWMODEL =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${DependenciesVersions.LIFECYCLE}"
        const val LIFECYCLE_KTX =
            "androidx.lifecycle:lifecycle-runtime-ktx:${DependenciesVersions.LIFECYCLE}"

        const val NAVIGATION_FRAGMENT_KTX =
            "androidx.navigation:navigation-fragment-ktx:${DependenciesVersions.NAVIGATION}"

        // Flow Binding
        const val FLOW_BINDING_ANDROID =
            "io.github.reactivecircus.flowbinding:flowbinding-android:${DependenciesVersions.FLOW_BINDING}"

        // Teko
        const val TERRA_CORE =
            "vn.teko.terra:terra-core-android:${DependenciesVersions.TERRA_CORE}"
        const val TERRA_APOLLO =
            "vn.teko.apollo:terra-apollo:${DependenciesVersions.TERRA_APOLLO}"
        const val APOLLO =
            "vn.teko.apollo:apollo:${DependenciesVersions.APOLLO}"
        const val TERRA_TRACKER =
            "vn.teko.android.tracker:tracker-manager:${DependenciesVersions.TERRA_TRACKER}"

        const val KOTLIN_META_DATA =
            "org.jetbrains.kotlinx:kotlinx-metadata-jvm:${dependencies.DependenciesVersions.KOTLIN_META_DATA}"

        const val COMPOSE_UI = "androidx.compose.ui:ui:${DependenciesVersions.JETPACK_COMPOSE}"
        const val COMPOSE_UI_TOOL = "androidx.compose.ui:ui-tooling:${DependenciesVersions.JETPACK_COMPOSE}"
        const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${DependenciesVersions.JETPACK_COMPOSE}"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:${DependenciesVersions.JETPACK_COMPOSE}"
        const val CONSTRAIN_LAYOUT_COMPOSE =
            "androidx.constraintlayout:constraintlayout-compose:${DependenciesVersions.CONSTRAIN_LAYOUT_COMPOSE}"

        const val FLOW_LAYOUT = "com.google.accompanist:accompanist-flowlayout:${DependenciesVersions.FLOW_LAYOUT}"
    }
}


// Temporarily added for cart
object DependenciesVersions {
    const val KOTLIN = "1.5.31"
    const val KOTLIN_COROUTINES = "1.5.2-native-mt"
    const val KOTLIN_SERIALIZATION = "1.2.2"
    const val KOTLIN_DATE_TIME = "0.2.1"
    const val JWT = "3.11.0"
    const val SPRINGDOC = "1.5.10"
    const val MICROMETER_REGISTRY_PROMETHEUS = "1.5.1"
    const val WIRE = "3.7.0"
    const val OKHTTP = "4.9.0"
    const val KTOR = "1.6.3"
    const val KODEIN_DI = "7.5.1"
    const val LOGGER = "1.2.3"
    const val SQL_DELIGHT = "1.5.2"
    const val FAST_ADAPTER = "5.3.5"
    const val COIL = "1.4.0"
    const val DAGGER_COMPILER = "2.26"
    const val KOTLIN_META_DATA = "0.2.0"
    const val LIFECYCLE = "2.4.0"
    const val NAVIGATION = "2.3.4"
    const val FLOW_BINDING = "1.0.0"
    const val HILT = "2.38"

    const val STATELY_COMMON = "1.1.4"
    const val STATELY_CONCURRENCY = "1.1.4"
    const val NAPIER_LOGGER = "1.5.0"

    const val JETPACK_COMPOSE = "1.0.5"

    const val CONSTRAIN_LAYOUT_COMPOSE = "1.0.0-rc01"
    const val FLOW_LAYOUT = "0.20.0"

    // Teko
    const val TERRA_CORE = "1.+"
    const val TERRA_APOLLO = "2.+"
    const val TERRA_TRACKER = "2.+"
    const val APOLLO = "2.+"
}

