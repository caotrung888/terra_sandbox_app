package flavors

import com.android.build.gradle.internal.dsl.ProductFlavor

fun ProductFlavor.buildDevelopForSalesData() {
    versionNameSuffix = ".develop"
    dimension = BuildProductDimensions.ENVIRONMENT
    buildConfigField("String", "BASE_CRM_URL", "\"https://test-crm.teko.vn/\"")
    buildConfigField("String", "BASE_PAYMENT_URL", "\"https://payment.develop.tekoapis.net/\"")
    buildConfigField("String", "BASE_USER_SERVICE_URL", "\"https://users.develop.tekoapis.net/\"")
    buildConfigField("String", "BASE_NOTIFICATION_URL", "\"https://stn.develop.tekoapis.net/\"")
}

fun ProductFlavor.buildStagingForSalesData() {
    versionNameSuffix = ".staging"
    dimension = BuildProductDimensions.ENVIRONMENT
    buildConfigField("String", "BASE_CRM_URL", "\"https://test-crm.teko.vn/\"")
    buildConfigField("String", "BASE_PAYMENT_URL", "\"https://payment.stage.tekoapis.net/\"")
    buildConfigField("String", "BASE_USER_SERVICE_URL", "\"https://users.stage.tekoapis.net/\"")
    buildConfigField("String", "BASE_NOTIFICATION_URL", "\"https://stn.develop.tekoapis.net/\"")
}

fun ProductFlavor.buildProductionForSalesData() {
    dimension = BuildProductDimensions.ENVIRONMENT
    buildConfigField("String", "BASE_CRM_URL", "\"https://crm.phongvu.vn/\"")
    buildConfigField("String", "BASE_IAM_URL", "\"https://identity.tekoapis.com/\"")
    buildConfigField("String", "BASE_PAYMENT_URL", "\"https://payment.tekoapis.com/\"")
    buildConfigField("String", "BASE_USER_SERVICE_URL", "\"https://users.tekoapis.com/\"")
    buildConfigField("String", "BASE_NOTIFICATION_URL", "\"https://stn.tekoapis.com/\"")
}