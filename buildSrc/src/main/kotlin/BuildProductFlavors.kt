import com.android.build.gradle.internal.dsl.ProductFlavor
import extensions.buildConfigStringField
import org.gradle.api.NamedDomainObjectContainer


interface BuildProductFlavor {
    val name: String

    fun appCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>
    ): ProductFlavor

    fun libraryCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>
    ): ProductFlavor
}

object ProductFlavorDevelop : BuildProductFlavor {
    override val name = "dev"

    override fun appCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>
    ): ProductFlavor = namedDomainObjectContainer.create(name) {
        applicationIdSuffix = ".dev"
        versionNameSuffix = "-dev"
        dimension = BuildProductDimensions.ENVIRONMENT

        // For Payment SDK
        buildConfigStringField("BASE_URL", "https://payment.stage.tekoapis.net/")
        buildConfigStringField("DB_NAME", "payment_db_dev")
        buildConfigStringField("QK", "mN7Ji30cdflpXacw")
    }

    override fun libraryCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>
    ): ProductFlavor = namedDomainObjectContainer.create(name) {
        versionNameSuffix = "-dev"
        dimension = BuildProductDimensions.ENVIRONMENT
    }
}

object ProductFlavorStaging : BuildProductFlavor {
    override val name = "staging"

    override fun appCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>
    ): ProductFlavor = namedDomainObjectContainer.create(name) {
        applicationIdSuffix = ".staging"
        versionNameSuffix = "-staging"
        dimension = BuildProductDimensions.ENVIRONMENT

        // For Payment SDK
        buildConfigStringField("BASE_URL", "https://payment.stage.tekoapis.net/")
        buildConfigStringField("DB_NAME", "payment_db_staging")
        buildConfigStringField("QK", "mN7Ji30cdflpXacw")
    }

    override fun libraryCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>
    ): ProductFlavor = namedDomainObjectContainer.create(name) {
        versionNameSuffix = "-staging"
        dimension = BuildProductDimensions.ENVIRONMENT
    }
}

object ProductFlavorProduction : BuildProductFlavor {
    override val name = "production"

    override fun appCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>
    ): ProductFlavor = namedDomainObjectContainer.create(name) {
        dimension = BuildProductDimensions.ENVIRONMENT

        // For Payment SDK
        buildConfigStringField("BASE_URL", "https://payment.tekoapis.com/")
        buildConfigStringField("DB_NAME", "payment_db")
        buildConfigStringField("QK", "a9VZyExAayDK4kbt")
    }

    override fun libraryCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>
    ): ProductFlavor = namedDomainObjectContainer.create(name) {
        dimension = BuildProductDimensions.ENVIRONMENT
    }
}
