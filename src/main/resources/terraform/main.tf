/*terraform init
terraform plan
terraform apply
terraform destroy*/

provider "azurerm" {
    features {}

    subscription_id = var.SUBSCRIPTION_ID
    tenant_id = var.TENANT_ID
    client_id = var.CLIENT_ID
    client_secret = var.CLIENT_SECRET
    skip_provider_registration = true
}

data "azurerm_client_config" "current" {

}

resource "azurerm_resource_group" "gestionfacture" {
    name     = "gestion_facture"
    location = "West Europe"
}

resource "azurerm_app_service_plan" "serviceplan" {
    name                = "gestion_facture-serviceplan"
    location            = azurerm_resource_group.gestionfacture.location
    resource_group_name = azurerm_resource_group.gestionfacture.name

    sku {
        tier = "Standard"
        size = "S1"
    }
}

resource "azurerm_app_service" "example" {
    name                = "gestion-facture-jmx"
    location            = azurerm_resource_group.gestionfacture.location
    resource_group_name = azurerm_resource_group.gestionfacture.name
    app_service_plan_id = azurerm_app_service_plan.serviceplan.id

    site_config {
        java_version = "11"
        scm_type     = "LocalGit"
        linux_fx_version = "DOCKER|"
    }

    connection_string {
        name  = "Database"
        type  = "PostgreSQL"
        value = "Server=gestionfacture-server.postgres.database.azure.com;Integrated Security=SSPI"
    }
}

resource "azurerm_postgresql_server" "databaseserver" {
    location                = azurerm_resource_group.gestionfacture.location
    name                    = "postgresql-server-jmx"
    resource_group_name     = azurerm_resource_group.gestionfacture.name
    sku_name                = "B_Gen5_2"
    ssl_enforcement_enabled = false
    ssl_minimal_tls_version_enforced = "TLSEnforcementDisabled"
    version                 = "9.5"
    administrator_login     = "postgres"
    administrator_login_password = "PgSqL#24!01$19"
}

resource "azurerm_postgresql_database" "gestionfacturedatabase" {
    name                = "gestion-facture-database-jmx"
    resource_group_name = azurerm_resource_group.gestionfacture.name
    server_name         = azurerm_postgresql_server.databaseserver.name
    charset             = "UTF8"
    collation           = "English_United States.1252"
}


