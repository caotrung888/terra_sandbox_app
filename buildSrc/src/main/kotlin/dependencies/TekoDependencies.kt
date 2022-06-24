package dependencies

import BuildDependenciesVersions
import TekoDependenciesVersions
import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra
import utils.VERSION_NAME
import utils.getProjectProperty

private val tekoDependenciesProviders = mutableMapOf<String, TekoDependenciesProvider>()

val Project.TekoDependencies: TekoDependenciesProvider
    get() {
        return tekoDependenciesProviders[displayName] ?: TekoDependenciesProvider(this).also {
            tekoDependenciesProviders[displayName] = it
        }
    }

class TekoDependenciesProvider(private val project: Project) {

    // Teko Authentication Modules
    val TEKO_AUTH_CORE = entry(TekoArtifacts.TEKO_AUTH_CORE)
    val TEKO_AUTH_USER = entry(
        artifact = TekoArtifacts.TEKO_AUTH_USER,
        defaultVersion = BuildDependenciesVersions.AUTH
    )
    val TEKO_AUTH_LOGIN = entry(
        artifact = TekoArtifacts.TEKO_AUTH_LOGIN,
        defaultVersion = BuildDependenciesVersions.AUTH
    )
    val TEKO_AUTH_LOGIN_UI = entry(TekoArtifacts.TEKO_AUTH_LOGIN_UI)
    val TERRA_AUTH = entry(TekoArtifacts.TERRA_AUTH)
    val TERRA_AUTH_GOOGLE_LOGIN = entry(TekoArtifacts.TERRA_AUTH_GOOGLE_LOGIN)
    val TERRA_AUTH_FACEBOOK_LOGIN = entry(TekoArtifacts.TERRA_AUTH_FACEBOOK_LOGIN)
    val TERRA_AUTH_KIT = entry(TekoArtifacts.TERRA_AUTH_KIT)
    val TERRA_AUTH_JS_BRIDGE = entry(TekoArtifacts.TERRA_AUTH_JS_BRIDGE)

    // Teko Android Framework Modules
    val TEKO_AF_DATA = entry(TekoArtifacts.TEKO_AF_DATA)
    val TEKO_AF_LOGGING = entry(TekoArtifacts.TEKO_AF_LOGGING)
    val TEKO_AF_UI = entry(TekoArtifacts.TEKO_AF_UI)
    val TEKO_AF_UTIL = entry(TekoArtifacts.TEKO_AF_UTIL)
    val TEKO_AF_UTIL_ANDROID = entry(TekoArtifacts.TEKO_AF_UTIL_ANDROID)
    val TEKO_AF_SKELETON = entry(TekoArtifacts.TEKO_AF_SKELETON)
    val TEKO_AF_BARCODE_UTIL = entry(TekoArtifacts.TEKO_AF_BARCODE_UTIL)
    val TEKO_AF_SERVICE = entry(TekoArtifacts.TEKO_AF_SERVICE)
    val TEKO_AF_NOTIFICATION = entry(TekoArtifacts.TEKO_AF_NOTIFICATION)
    val TEKO_AF_PROCESSOR = entry(TekoArtifacts.TEKO_AF_PROCESSOR)
    val TEKO_AF_ANNOTATION = entry(TekoArtifacts.TEKO_AF_ANNOTATION)
    val TEKO_AF_MESSAGING = entry(TekoArtifacts.TEKO_AF_MESSAGING)
    val TEKO_AF_FRAMEWORK = entry(TekoArtifacts.TEKO_AF_FRAMEWORK)
    val TEKO_AF_MEDIAVIEWER = entry(TekoArtifacts.TEKO_AF_MEDIAVIEWER)
    val TEKO_AF_TESTUTIL = entry(TekoArtifacts.TEKO_AF_TESTUTIL)
    val TEKO_AF_TESTUTIL_ANDROID = entry(TekoArtifacts.TEKO_AF_TESTUTIL_ANDROID)
    val TEKO_AF_QR_GENERATOR = entry(TekoArtifacts.TEKO_AF_QR_GENERATOR)

    // Teko Payment SDK Test
    val TEKO_PAYMENT_CORE = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_CORE,
        defaultVersion = BuildDependenciesVersions.PAYMENT
    )
    val TEKO_PAYMENT_CORE_V2 = entry(TekoArtifacts.TEKO_PAYMENT_CORE_V2)
    val TEKO_PAYMENT_UI = entry(TekoArtifacts.TEKO_PAYMENT_UI)
    val TEKO_PAYMENT_KIT = entry(TekoArtifacts.TEKO_PAYMENT_KIT)
    val TEKO_PAYMENT_METHOD_CASH = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_METHOD_CASH,
        defaultVersion = BuildDependenciesVersions.PAYMENT
    )
    val TEKO_PAYMENT_METHOD_CTT = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_METHOD_CTT,
        defaultVersion = BuildDependenciesVersions.PAYMENT
    )
    val TEKO_PAYMENT_METHOD_ATM = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_METHOD_ATM,
        defaultVersion = BuildDependenciesVersions.PAYMENT
    )
    val TEKO_PAYMENT_METHOD_VNPAY = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_METHOD_VNPAY,
        defaultVersion = BuildDependenciesVersions.PAYMENT
    )
    val TEKO_PAYMENT_OBSERVER_FIREBASE = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_OBSERVER_FIREBASE,
        defaultVersion = BuildDependenciesVersions.PAYMENT
    )
    val TEKO_PAYMENT_OBSERVER_FIREBASE_V2 = entry(TekoArtifacts.TEKO_PAYMENT_OBSERVER_FIREBASE_V2)
    val TEKO_PAYMENT_MANAGER = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_MANAGER,
        defaultVersion = BuildDependenciesVersions.PAYMENT
    )
    val TEKO_PAYMENT_MANAGER_V2 = entry(TekoArtifacts.TEKO_PAYMENT_MANAGER_V2)
    val TEKO_PAYMENT_REACT_NATIVE_BRIDGE = entry(TekoArtifacts.TEKO_PAYMENT_REACT_NATIVE_BRIDGE)
    val TEKO_PAYMENT_CONTROLLER_UI = entry(TekoArtifacts.TEKO_PAYMENT_UI)
    val TEKO_PAYMENT_SELECT_METHODS_UI = entry(TekoArtifacts.TEKO_PAYMENT_SELECT_METHODS_UI)

    // Teko Payment SDK Production
    val TEKO_PROD_PAYMENT_CORE = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_CORE,
        defaultVersion = BuildDependenciesVersions.PAYMENT_PROD
    )
    val TEKO_PROD_PAYMENT_CORE_V2 = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_CORE_V2,
        defaultVersion = BuildDependenciesVersions.PAYMENT_PROD
    )
    val TEKO_PROD_PAYMENT_UI = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_UI,
        defaultVersion = BuildDependenciesVersions.PAYMENT_PROD
    )
    val TEKO_PROD_PAYMENT_METHOD_CASH = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_METHOD_CASH,
        defaultVersion = BuildDependenciesVersions.PAYMENT_PROD
    )
    val TEKO_PROD_PAYMENT_METHOD_CTT = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_METHOD_CTT,
        defaultVersion = BuildDependenciesVersions.PAYMENT_PROD
    )
    val TEKO_PROD_PAYMENT_METHOD_ATM = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_METHOD_ATM,
        defaultVersion = BuildDependenciesVersions.PAYMENT_PROD
    )
    val TEKO_PROD_PAYMENT_METHOD_VNPAY = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_METHOD_VNPAY,
        defaultVersion = BuildDependenciesVersions.PAYMENT_PROD
    )
    val TEKO_PROD_PAYMENT_OBSERVER_FIREBASE = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_OBSERVER_FIREBASE,
        defaultVersion = BuildDependenciesVersions.PAYMENT_PROD
    )
    val TEKO_PROD_PAYMENT_OBSERVER_FIREBASE_V2 = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_OBSERVER_FIREBASE_V2,
        defaultVersion = BuildDependenciesVersions.PAYMENT_PROD
    )
    val TEKO_PROD_PAYMENT_MANAGER = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_MANAGER,
        defaultVersion = BuildDependenciesVersions.PAYMENT_PROD
    )
    val TEKO_PROD_PAYMENT_MANAGER_V2 = entry(
        artifact = TekoArtifacts.TEKO_PAYMENT_MANAGER_V2,
        defaultVersion = BuildDependenciesVersions.PAYMENT_PROD
    )

    // Teko Tracker
    val TEKO_TRACKER = entry(
        artifact = TekoArtifacts.TEKO_TRACKER,
        defaultVersion = BuildDependenciesVersions.TRACKER
    )
    val TEKO_TRACKER_MANAGER = entry(TekoArtifacts.TEKO_TRACKER_MANAGER)
    val TEKO_TRACKER_CORE = entry(TekoArtifacts.TEKO_TRACKER_CORE)
    val TEKO_TRACKER_EVENT = entry(TekoArtifacts.TEKO_TRACKER_EVENT)
    val TEKO_TRACKER_UTIL = entry(TekoArtifacts.TEKO_TRACKER_UTIL)

    // Terra
    val TERRA_CORE = entry(TekoArtifacts.TERRA_CORE)
    val TERRA_CORE_ANDROID = entry(TekoArtifacts.TERRA_CORE_ANDROID)
    val TERRA_BUS_EXTENSION = entry(TekoArtifacts.TERRA_BUS_EXTENSION)
    val TERRA_JS_BRIDGE = entry(TekoArtifacts.TERRA_JS_BRIDGE)
    val TERRA_JS_BRIDGE_CORE = entry(TekoArtifacts.TERRA_JS_BRIDGE_CORE)
    val TERRA_REACT_NATIVE_BRIDGE = entry(TekoArtifacts.TERRA_REACT_NATIVE_BRIDGE)

    // Hestia
    val HESTIA_CORE = entry(TekoArtifacts.HESTIA_CORE)
    val HESTIA_ANDROID = entry(TekoArtifacts.HESTIA_ANDROID)
    val TERRA_HESTIA = entry(TekoArtifacts.TERRA_HESTIA)
    val HESTIA_ANDROID_WEBAPP = entry(TekoArtifacts.HESTIA_ANDROID_WEBAPP)
    val HESTIA_ANDROID_NATIVE = entry(TekoArtifacts.HESTIA_ANDROID_NATIVE)
    val HESTIA_ANDROID_REACT_NATIVE = entry(TekoArtifacts.HESTIA_ANDROID_REACT_NATIVE)
    val HESTIA_ANDROID_REACT_NATIVE_UI_FRAGMENT =
        entry(TekoArtifacts.HESTIA_ANDROID_REACT_NATIVE_UI_FRAGMENT)
    val HESTIA_ANDROID_REACT_NATIVE_UI_ACTIVITY =
        entry(TekoArtifacts.HESTIA_ANDROID_REACT_NATIVE_UI_ACTIVITY)
    val HESTIA_TRACKING_BRIDGE = entry(TekoArtifacts.HESTIA_TRACKING_BRIDGE)
    val HESTIA_WEBVIEW = entry(TekoArtifacts.HESTIA_WEBVIEW)
    val HESTIA_KIT_CONNECTOR = entry(TekoArtifacts.HESTIA_KIT_CONNECTOR)
    val HESTIA_AUTH_CONTROLLER = entry(TekoArtifacts.HESTIA_AUTH_CONTROLLER)
    val HESTIA_PAYMENT_CONTROLLER = entry(TekoArtifacts.HESTIA_PAYMENT_CONTROLLER)

    // HestiaOrder
    val HESTIA_ORDER_CORE = entry(TekoArtifacts.HESTIA_ORDER_CORE)
    val TERRA_HESTIA_ORDER = entry(TekoArtifacts.TERRA_HESTIA_ORDER)
    val HESTIA_ORDER_UI = entry(TekoArtifacts.HESTIA_ORDER_UI)
    val TERRA_HESTIA_ORDER_UI = entry(TekoArtifacts.TERRA_HESTIA_ORDER_UI)

    // Apollo
    val TEKO_APOLLO = entry(TekoArtifacts.TEKO_APOLLO)
    val TERRA_APOLLO = entry(TekoArtifacts.TERRA_APOLLO)

    // Service teko
    val TERRA_PPM = entry(
        artifact = TekoArtifacts.TERRA_PPM,
        defaultVersion = BuildDependenciesVersions.SERVICE_PPM
    )
    val TERRA_PPM_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_PPM_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_PPM
    )
    val TERRA_POLICY = entry(
        artifact = TekoArtifacts.TERRA_POLICY,
        defaultVersion = BuildDependenciesVersions.SERVICE_POLICY
    )
    val TERRA_POLICY_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_POLICY_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_POLICY
    )
    val TERRA_DISCOVERY = entry(
        artifact = TekoArtifacts.TERRA_DISCOVERY,
        defaultVersion = BuildDependenciesVersions.SERVICE_DISCOVERY
    )
    val TERRA_DISCOVERY_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_DISCOVERY_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_DISCOVERY
    )
    val TERRA_USER = entry(
        artifact = TekoArtifacts.TERRA_USER,
        defaultVersion = BuildDependenciesVersions.SERVICE_USER
    )
    val TERRA_USER_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_USER_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_USER
    )
    val TERRA_DCA = entry(
        artifact = TekoArtifacts.TERRA_DCA,
        defaultVersion = BuildDependenciesVersions.SERVICE_DCA
    )
    val TERRA_DCA_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_DCA_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_DCA
    )
    val TERRA_LOCATION = entry(
        artifact = TekoArtifacts.TERRA_LOCATION,
        defaultVersion = BuildDependenciesVersions.SERVICE_LOCATION
    )
    val TERRA_LOCATION_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_LOCATION_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_LOCATION
    )
    val TERRA_ORDER = entry(
        artifact = TekoArtifacts.TERRA_ORDER,
        defaultVersion = BuildDependenciesVersions.SERVICE_ORDER
    )
    val TERRA_ORDER_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_ORDER_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_ORDER
    )
    val TERRA_NOTIFICATION = entry(
        artifact = TekoArtifacts.TERRA_NOTIFICATION,
        defaultVersion = BuildDependenciesVersions.SERVICE_NOTIFICATION
    )
    val TERRA_NOTIFICATION_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_NOTIFICATION_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_NOTIFICATION
    )
    val TERRA_ID_ADMIN = entry(
        artifact = TekoArtifacts.TERRA_ID_ADMIN,
        defaultVersion = BuildDependenciesVersions.SERVICE_ID_ADMIN
    )
    val TERRA_ID_ADMIN_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_ID_ADMIN_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_ID_ADMIN
    )
    val TERRA_WMS = entry(
        artifact = TekoArtifacts.TERRA_WMS,
        defaultVersion = BuildDependenciesVersions.SERVICE_WMS
    )
    val TERRA_WMS_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_WMS_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_WMS
    )
    val TERRA_SELLER = entry(
        artifact = TekoArtifacts.TERRA_SELLER,
        defaultVersion = BuildDependenciesVersions.SERVICE_SELLER
    )
    val TERRA_SELLER_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_SELLER_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_SELLER
    )
    val TERRA_PVIS = entry(
        artifact = TekoArtifacts.TERRA_PVIS,
        defaultVersion = BuildDependenciesVersions.SERVICE_PVIS
    )
    val TERRA_PVIS_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_PVIS_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_PVIS
    )
    val TERRA_SEARCH = entry(
        artifact = TekoArtifacts.TERRA_SEARCH,
        defaultVersion = BuildDependenciesVersions.SERVICE_SEARCH
    )
    val TERRA_SEARCH_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_SEARCH_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_SEARCH
    )
    val TERRA_FM = entry(
        artifact = TekoArtifacts.TERRA_FM,
        defaultVersion = BuildDependenciesVersions.SERVICE_FINANCE
    )
    val TERRA_FM_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_FM_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_FINANCE
    )
    val TERRA_TICKET = entry(
        artifact = TekoArtifacts.TERRA_TICKET,
        defaultVersion = BuildDependenciesVersions.SERVICE_TICKET
    )
    val TERRA_TICKET_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_TICKET_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_TICKET
    )
    val TERRA_POS = entry(
        artifact = TekoArtifacts.TERRA_POS,
        defaultVersion = BuildDependenciesVersions.SERVICE_POS
    )
    val TERRA_POS_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_POS_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_POS
    )
    val TERRA_CATALOG = entry(
        artifact = TekoArtifacts.TERRA_CATALOG,
        defaultVersion = BuildDependenciesVersions.SERVICE_CATALOG
    )
    val TERRA_CATALOG_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_CATALOG_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_CATALOG
    )
    val TERRA_CART = entry(
        artifact = TekoArtifacts.TERRA_CART,
        defaultVersion = BuildDependenciesVersions.SERVICE_CART
    )
    val TERRA_CART_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_CART_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_CART
    )

    val TERRA_APPROVAL_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_APPROVAL_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_APPROVAL
    )

    val TERRA_BANK = entry(
        artifact = TekoArtifacts.TERRA_BANK,
        defaultVersion = BuildDependenciesVersions.SERVICE_BANK
    )

    val TERRA_BANK_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_BANK_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_BANK
    )

    val TERRA_COV = entry(
        artifact = TekoArtifacts.TERRA_COV,
        defaultVersion = BuildDependenciesVersions.SERVICE_COV
    )

    val TERRA_COV_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_COV_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_COV
    )

    val TERRA_FLAGSUP_ANDROID = entry(
        artifact = TekoArtifacts.TERRA_FLAGSUP_ANDROID,
        defaultVersion = BuildDependenciesVersions.SERVICE_FLAGSUP
    )

    val VNSHOP_SDK = entry(
        artifact = TekoArtifacts.VNSHOP_SDK,
        defaultVersion = BuildDependenciesVersions.VNSHOP
    )

    val FOOTPRINT_DTO = entry(
        artifact = TekoArtifacts.FOOTPRINT_DTO,
        defaultVersion = BuildDependenciesVersions.FOOTPRINT_DTO
    )

    val TEKO_DISCOVERY_CORE = entry(
        artifact = TekoArtifacts.TEKO_DISCOVERY_CORE,
        defaultVersion = BuildDependenciesVersions.DISCOVERY
    )

    val TEKO_SEARCH_CORE = entry(
        artifact = TekoArtifacts.TEKO_SEARCH_CORE,
        defaultVersion = BuildDependenciesVersions.DISCOVERY
    )

    val TEKO_POLICY_CORE = entry(
        artifact = TekoArtifacts.TEKO_POLICY_CORE,
        defaultVersion = BuildDependenciesVersions.DISCOVERY
    )

    val TEKO_LISTING_CORE = entry(
        artifact = TekoArtifacts.TEKO_LISTING_CORE,
        defaultVersion = BuildDependenciesVersions.DISCOVERY
    )

    val TEKO_DISCOVERY_EVENT = entry(
        artifact = TekoArtifacts.TEKO_DISCOVERY_EVENT,
        defaultVersion = BuildDependenciesVersions.DISCOVERY
    )

    val TEKO_DISCOVERY_CORE_UI = entry(
        artifact = TekoArtifacts.TEKO_DISCOVERY_CORE_UI,
        defaultVersion = BuildDependenciesVersions.DISCOVERY
    )

    val TEKO_DISCOVERY_STAFF_UI = entry(
        artifact = TekoArtifacts.TEKO_DISCOVERY_STAFF_UI,
        defaultVersion = BuildDependenciesVersions.DISCOVERY
    )

    val TEKO_DISCOVERY_CONSUMER_UI = entry(
        artifact = TekoArtifacts.TEKO_DISCOVERY_CONSUMER_UI,
        defaultVersion = BuildDependenciesVersions.DISCOVERY
    )

    val TEKO_ORDER_STAFF_UI = entry(
        artifact = TekoArtifacts.TEKO_ORDER_STAFF_UI,
        defaultVersion = BuildDependenciesVersions.ORDER
    )

    val TEKO_ORDER_EVENT = entry(
        artifact = TekoArtifacts.TEKO_ORDER_EVENT,
        defaultVersion = BuildDependenciesVersions.ORDER
    )

    val TEKO_ORDER_CORE_UI = entry(
        artifact = TekoArtifacts.TEKO_ORDER_CORE_UI,
        defaultVersion = BuildDependenciesVersions.ORDER
    )

    val TEKO_ORDER_COV_CORE = entry(
        artifact = TekoArtifacts.TEKO_ORDER_COV_CORE,
        defaultVersion = BuildDependenciesVersions.ORDER
    )

    val TEKO_ORDER_BFF_CORE = entry(
        artifact = TekoArtifacts.TEKO_ORDER_BFF_CORE,
        defaultVersion = BuildDependenciesVersions.ORDER
    )
    val TEKO_ORDER_APPROVAL_CORE = entry(
        artifact = TekoArtifacts.TEKO_ORDER_APPROVAL_CORE,
        defaultVersion = BuildDependenciesVersions.ORDER
    )

    val TEKO_LOYALTY_CORE = entry(TekoArtifacts.TEKO_LOYALTY_CORE)
    val TEKO_LOYALTY_MODEL = entry(TekoArtifacts.TEKO_LOYALTY_MODEL)
    val TEKO_LOYALTY_TERRA = entry(TekoArtifacts.TEKO_LOYALTY_TERRA)
    val TEKO_LOYALTY_CONSUMER_TERRA = entry(TekoArtifacts.TEKO_LOYALTY_CONSUMER_TERRA)
    val TEKO_LOYALTY_CONSUMER_UI = entry(TekoArtifacts.TEKO_LOYALTY_CONSUMER_UI)
    val TEKO_LOYALTY_STAFF_TERRA = entry(TekoArtifacts.TEKO_LOYALTY_STAFF_TERRA)
    val TEKO_LOYALTY_STAFF_UI = entry(TekoArtifacts.TEKO_LOYALTY_STAFF_UI)
    val TEKO_LOYALTY_COMPONENT = entry(TekoArtifacts.TEKO_LOYALTY_COMPONENT)
    val TEKO_LOYALTY_KIT = entry(TekoArtifacts.TEKO_LOYALTY_KIT)
    val TEKO_LOYALTY_TRACKING = entry(TekoArtifacts.TEKO_LOYALTY_TRACKING)

    val TEKO_IRIS_CORE = entry(TekoArtifacts.IRIS_CORE)
    val TERRA_IRIS = entry(TekoArtifacts.TERRA_IRIS)

    val TEKO_CART_CORE = entry(
        artifact = TekoArtifacts.TEKO_CART_CORE,
        defaultVersion = BuildDependenciesVersions.CART
    )

    val TERRA_CART_UI = entry(
        artifact = TekoArtifacts.TERRA_CART_UI,
        defaultVersion = BuildDependenciesVersions.CART
    )

    val TERRA_CART_BUS = entry(
        artifact = TekoArtifacts.TERRA_CART_BUS,
        defaultVersion = BuildDependenciesVersions.CART
    )

    val TEKO_VNPAY_BILLING = entry(
        TekoArtifacts.TEKO_VNPAY_BILLING,
        BuildDependenciesVersions.TEKO_VNPAY_BILLING
    )

    val TEKO_NOTIFICATION_FCM_UTIL = entry(
        TekoArtifacts.TEKO_NOTIFICATION_FCM_UTIL,
        BuildDependenciesVersions.TEKO_NOTIFICATION_FCM_UTIL
    )

    val TEKO_NOTIFICATION_CORE = entry(
        TekoArtifacts.TEKO_NOTIFICATION_CORE,
        BuildDependenciesVersions.TEKO_NOTIFICATION_CORE
    )

    val TEKO_NOTIFICATION_UI = entry(
        TekoArtifacts.TEKO_NOTIFICATION_UI,
        BuildDependenciesVersions.TEKO_NOTIFICATION_UI
    )

    val TEKO_TERRA_NOTIFICATION = entry(
        TekoArtifacts.TEKO_TERRA_NOTIFICATION,
        BuildDependenciesVersions.TEKO_TERRA_NOTIFICATION
    )

    val TEKO_TERRA_LINK_PROCESSOR = entry(
        TekoArtifacts.TERRA_LINK_PROCESSOR,
        BuildDependenciesVersions.TERRA_LINK_PROCESSOR
    )

    private fun entry(
        artifact: String,
        defaultVersion: String = TekoDependenciesVersions[artifact]
            ?: throw Exception("$artifact version not found!")
    ): String {
        val version = try {
            project.extra.get(artifact) as String
        } catch (e: Throwable) {
            defaultVersion
        }
        return "$artifact:$version"
    }

    fun getArtifactVersion(artifact: String): String {
        return try {
            project.extra.get(artifact) as String
        } catch (e: Throwable) {
            println("WARNING: using default version for artifact $artifact")
            getProjectProperty(project, VERSION_NAME)
        }
    }
}