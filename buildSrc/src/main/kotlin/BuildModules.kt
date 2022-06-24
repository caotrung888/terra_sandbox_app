/**
 * Configuration of build modules
 */
object BuildModules {
    const val ROUND_BG_TEXTVIEW = ":roundedbgtextview"
    const val MULTIPLATFORM_CART = ":multiplatform-cart"
    const val JIRA_TEST = ":jira-test"
    const val APP_COMMON = ":appCommon"
    const val SALE_UTIL = ":salesUtil"
    const val SALE_DATA = ":salesData"
    const val MODEL = ":model"
    const val OFFLINE_RESOURCE = ":offline-resource"
    const val ANDROID_UTIL = ":androidUtil"
    const val OFFLINE_RESOURCE_TERMINAL = ":offline-resource:terminal"

    // mini apps
    const val APP = ":app"
    const val TRIPI_FLIGHT_CONNECTOR = ":mini-apps:tripi-flight-connector"
    const val TRIPI_TELCO_CONNECTOR = ":mini-apps:tripi-telco-connector"
    const val TRIPI_HOTEL_CONNECTOR = ":mini-apps:tripi-hotel-connector"
    const val DEMO_MINI_NATIVE_APP_CONNECTOR = ":demoMiniNativeAppConnector"
    const val DEMO_MINI_NATIVE_APP = ":demoMiniNativeApp"

    // Android Framework
    const val AF_UTIL = ":android-framework:util"
    const val AF_UI = ":android-framework:ui"
    const val AF_DATA = ":android-framework:data"
    const val AF_SERVICE = ":android-framework:service"
    const val AF_UTIL_ANDROID = ":android-framework:util-android"
    const val AF_SKELETON = ":android-framework:skeleton"
    const val AF_BARCODE_UTIL = ":android-framework:barcode-util"
    const val AF_LOGGING = ":android-framework:logging"
    const val AF_NOTIFICATION = ":android-framework:notification"
    const val AF_ANNOTATION = ":android-framework:annotation"
    const val AF_PROCESSOR = ":android-framework:processor"
    const val AF_MESSAGING = ":android-framework:messaging"
    const val AF_FRAMEWORK = ":android-framework:framework"
    const val AF_MEDIAVIEWER = ":android-framework:mediaviewer"
    const val AF_TEST_UTIL = ":android-framework:test-util"
    const val AF_TEST_UTIL_ANDROID = ":android-framework:test-util-android"
    const val AF_QR_GENERATOR = ":android-framework:qr-generator"

    // Terra
    const val TERRA_BUS = ":terra:terra-bus"
    const val TERRA_CORE = ":terra:terra-core"
    const val TERRA_CORE_ANDROID = ":terra:terra-core:terra-core-android"
    const val TERRA_BUS_EXTENSION = ":terra:terra-bus-extension"
    const val TERRA_APPROVAL = ":terra:terra-approval"
    const val TERRA_APPROVAL_ANDROID = ":terra:terra-approval:terra-approval-android"
    const val TERRA_JS_BRIDGE_CORE = ":terra:js-bridge-core"
    const val TERRA_JS_BRIDGE = ":terra:terra-js-bridge"
    const val TERRA_REACT_NATIVE_BRIDGE = ":terra:terra-react-native-bridge"
    const val TERRA_REACT_NATIVE_BRIDGE_ANDROID =
        ":terra:terra-react-native-bridge:terra-react-native-bridge-android"

    // Hestia
    const val HESTIA_CORE = ":hestia:hestia-core"
    const val HESTIA_ANDROID = ":hestia:hestia-android"
    const val TERRA_HESTIA = ":hestia:terra-hestia"
    const val HESTIA_ANDROID_NATIVE = ":hestia:hestia-android-native"
    const val HESTIA_ANDROID_REACT_NATIVE = ":hestia:hestia-android-react-native"
    const val HESTIA_ANDROID_REACT_NATIVE_UI_ACTIVITY =
        ":hestia:hestia-android-react-native-ui-activity"
    const val HESTIA_ANDROID_REACT_NATIVE_UI_FRAGMENT =
        ":hestia:hestia-android-react-native-ui-fragment"
    const val HESTIA_ANDROID_WEBAPP = ":hestia:hestia-android-webapp"
    const val HESTIA_REACT_NATIVE_ANDROID =
        ":hestia:hestia-android-react-native"
    const val HESTIA_TRACKING_BRIDGE = ":hestia:hestia-tracking-bridge"
    const val HESTIA_KIT_CONNECTOR = ":hestia:kit-connector"
    const val HESTIA_WEB_VIEW = ":hestia:hestia-webview"
    const val HESTIA_AUTH_CONTROLLER = ":hestia:hestia-auth-controller"
    const val HESTIA_PAYMENT_CONTROLLER = ":hestia:hestia-payment-controller"

    // Service teko
    const val SERVICE_ORDER = ":terra:service-order"
    const val SERVICE_ORDER_ANDROID = ":terra:service-order:service-order-android"
    const val SERVICE_POLICY = ":terra:service-policy"
    const val SERVICE_POLICY_ANDROID = ":terra:service-policy:service-policy-android"
    const val SERVICE_CART = ":terra:service-cart"
    const val SERVICE_CART_ANDROID = ":terra:service-cart:service-cart-android"
    const val SERVICE_SEARCH = ":terra:service-search"
    const val SERVICE_SEARCH_ANDROID = ":terra:service-search:service-search-android"
    const val SERVICE_PVIS = ":terra:service-pvis"
    const val SERVICE_PVIS_ANDROID = ":terra:service-pvis:service-pvis-android"
    const val SERVICE_DCA = ":terra:service-dca"
    const val SERVICE_DCA_ANDROID = ":terra:service-dca:service-dca-android"
    const val SERVICE_SELLER = ":terra:service-seller"
    const val SERVICE_SELLER_ANDROID = ":terra:service-seller:service-seller-android"
    const val SERVICE_PPM = ":terra:service-ppm"
    const val SERVICE_PPM_ANDROID = ":terra:service-ppm:service-ppm-android"
    const val SERVICE_LOCATION = ":terra:service-location"
    const val SERVICE_LOCATION_ANDROID = ":terra:service-location:service-location-android"
    const val SERVICE_WMS = ":terra:service-wms"
    const val SERVICE_WMS_ANDROID = ":terra:service-wms:service-wms-android"
    const val SERVICE_FM = ":terra:service-fm"
    const val SERVICE_FM_ANDROID = ":terra:service-fm:service-fm-android"
    const val SERVICE_APPROVAL = ":terra:service-approval"
    const val SERVICE_APPROVAL_ANDROID = ":terra:service-approval:service-approval-android"
    const val SERVICE_POS = ":terra:service-pos"
    const val SERVICE_POS_ANDROID = ":terra:service-pos:service-pos-android"
    const val SERVICE_CATALOG = ":terra:service-catalog"
    const val SERVICE_CATALOG_ANDROID = ":terra:service-catalog:service-catalog-android"
    const val SERVICE_DISCOVERY = ":terra:service-discovery"
    const val SERVICE_DISCOVERY_ANDROID = ":terra:service-discovery:service-discovery-android"
    const val SERVICE_USER = ":terra:service-user"
    const val SERVICE_USER_ANDROID = ":terra:service-user:service-user-android"
    const val SERVICE_NOTIFICATION = ":terra:service-notification"
    const val SERVICE_NOTIFICATION_ANDROID =
        ":terra:service-notification:service-notification-android"
    const val SERVICE_ID_ADMIN = ":terra:service-id-admin"
    const val SERVICE_ID_ADMIN_ANDROID =
        ":terra:service-id-admin:service-id-admin-android"
    const val SERVICE_MAIA = ":terra:service-maia"
    const val SERVICE_MAIA_ANDROID = ":terra:service-maia:service-maia-android"
    const val SERVICE_TICKET = ":terra:service-ticket"
    const val SERVICE_TICKET_ANDROID = ":terra:service-ticket:service-ticket-android"
    const val SERVICE_BANK = ":terra:service-bank"
    const val SERVICE_BANK_ANDROID = ":terra:service-bank:service-bank-android"
    const val SERVICE_COV = ":terra:service-cov"
    const val SERVICE_COV_ANDROID = ":terra:service-cov:service-cov-android"
    const val SERVICE_FLAGSUP = ":terra:service-flagsup"
    const val SERVICE_FLAGSUP_ANDROID = ":terra:service-flagsup:service-flagsup-android"

    // Payment
    const val PAYMENT_CORE = ":payment-sdk:payment-core"
    const val PAYMENT_CORE_V2 = ":payment-sdk:payment-core-v2"
    const val PAYMENT_METHOD_CASH = ":payment-sdk:method-cash"
    const val PAYMENT_METHOD_CTT = ":payment-sdk:method-ctt"
    const val PAYMENT_METHOD_ATM = ":payment-sdk:method-atm"
    const val PAYMENT_METHOD_SPOS = ":payment-sdk:method-spos"
    const val PAYMENT_METHOD_VNPAY = ":payment-sdk:method-vnpay"
    const val PAYMENT_OBSERVER_FIREBASE = ":payment-sdk:observer-firebase"
    const val PAYMENT_OBSERVER_FIREBASE_V2 = ":payment-sdk:observer-firebase-v2"
    const val PAYMENT_UI = ":payment-sdk:payment-ui"
    const val PAYMENT_KIT = ":payment-sdk:payment-kit"
    const val PAYMENT_MANAGER = ":payment-sdk:payment-manager"
    const val PAYMENT_MANAGER_V2 = ":payment-sdk:payment-manager-v2"
    const val PAYMENT_REACT_NATIVE_BRIDGE = ":payment-sdk:payment-react-native-bridge"
    const val PAYMENT_SELECT_METHODS_UI = ":payment-sdk:payment-select-methods-ui"

    // Oauth Client
    const val AUTH_CORE = ":auth:auth-core"
    const val AUTH_USER = ":auth:auth-user"
    const val AUTH_LOGIN = ":auth:auth-login"
    const val AUTH_LOGIN_UI = ":auth:login-ui"
    const val AUTH_LOGIN_CORE_UI = ":auth:login-core-ui"
    const val AUTH_FACEBOOK_LOGIN_UI = ":auth:facebook-login"
    const val AUTH_GOOGLE_LOGIN_UI = ":auth:google-login"
    const val TERRA_AUTH = ":auth:terra-auth"
    const val AUTH_KIT = ":auth:auth-kit"
    const val TERRA_AUTH_JS_BRIDGE = ":auth:js-bridge"

    // Tracker
    const val TRACKER_CORE = ":tracker:tracker-core"
    const val TRACKER_EVENT = ":tracker:tracker-event"
    const val TRACKER_UTIL = ":tracker:tracker-util"
    const val TRACKER_MANAGE = ":tracker:tracker-manager"

    @Deprecated(
        message = "From version 2.0.0, [TRACKER_EVENT_V2] was renamed to [TRACKER_EVENT] to prevent abusing",
        replaceWith = ReplaceWith(TRACKER_EVENT)
    )
    const val TRACKER_EVENT_V2 = ":tracker:tracker-event-v2"

    // Discovery SDK
    const val SERVICE_DISCOVERY_CORE = ":discovery:discovery-core"
    const val SERVICE_PPM_CORE = ":discovery:ppm-core"
    const val SERVICE_SEARCH_CORE = ":discovery:search-core"
    const val SERVICE_POLICY_CORE = ":discovery:policy-core"
    const val SERVICE_DISCOVERY_CONSUMER_UI = ":discovery:consumer-ui"
    const val SERVICE_DISCOVERY_STAFF_UI = ":discovery:staff-ui"
    const val DISCOVERY_EVENT = ":discovery:discovery-event"
    const val DISCOVERY_CORE_UI = ":discovery:core-ui"
    const val DISCOVERY_LISTING_CORE = ":discovery:listing-core"

    // Order SDK
    const val SERVICE_ORDER_COV_CORE = ":order:order-cov-core"
    const val SERVICE_ORDER_STAFF_UI = ":order:order-staff-ui"
    const val SERVICE_ORDER_CORE_UI = ":order:order-core-ui"
    const val SERVICE_ORDER_BFF_CORE = ":order:order-bff-core"
    const val SERVICE_ORDER_APPROVAL_CORE = ":order:order-approval-core"
    const val SERVICE_ORDER_EVENT = ":order:order-event"

    // Loyalty SDK
    const val LOYALTY_CORE = ":loyalty:loyalty-core"
    const val LOYALTY_MODEL = ":loyalty:loyalty-model"
    const val LOYALTY_TERRA = ":loyalty:terra-loyalty"
    const val LOYALTY_CONSUMER_TERRA = ":loyalty:terra-loyalty-consumer"
    const val LOYALTY_CONSUMER_UI = ":loyalty:loyalty-consumer-ui"
    const val LOYALTY_COMPONENT = ":loyalty:loyalty-component"
    const val LOYALTY_STAFF_TERRA = ":loyalty:terra-loyalty-staff"
    const val LOYALTY_STAFF_UI = ":loyalty:loyalty-staff-ui"
    const val LOYALTY_KIT = ":loyalty:loyalty-kit"
    const val LOYALTY_TRACKING = ":loyalty:loyalty-tracking"

    // Apollo
    const val APOLLO = ":apollo"
    const val TERRA_APOLLO = ":apollo:terra-apollo"

    // Iris
    const val IRIS_CORE = ":iris:iris-core"
    const val TERRA_IRIS = ":iris:terra-iris"

    // Terra Link Processor
    const val HESTIA_LINK_PROCESSOR = ":hestia-link-processor"
    const val TERRA_LINK_PROCESSOR = ":terra-link-processor"
    const val TERRA_FIREBASE_LINK_PROCESSOR = ":terra-firebase-link-processor"

    // Notification
    const val NOTIFICATION_CORE = ":notification:notification-core"
    const val NOTIFICATION_TERRA = ":notification:terra-notification"
    const val NOTIFICATION_UI = ":notification:notification-ui"
    const val NOTIFICATION_UTIL = ":notification:notification-util"
    const val NOTIFICATION_UTIL_ANNOTATION = ":notification:notification-util-annotation"
    const val NOTIFICATION_UTIL_PROCESSOR = ":notification:notification-util-processor"
    const val NOTIFICATION_FCM_UTIL = ":notification:fcm-util"
    const val NOTIFICATION_FCM_UTIL_ANNOTATION = ":notification:fcm-util-annotation"
    const val NOTIFICATION_FCM_UTIL_PROCESSOR = ":notification:fcm-util-processor"
}
