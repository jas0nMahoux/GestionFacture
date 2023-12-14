// Before that a docker image was created with the app .jar build with the maven install  -Pproduction mode

// first download terraform in https://www.terraform.io/
// terraform init
// terraform plan
// terraform apply to create all the resources
// terraform destroy to delete all the resources created

/*
* Resource 1
*/
provider "azurerm" {
    features {}

    subscription_id = var.SUBSCRIPTION_ID
    tenant_id = var.TENANT_ID
    client_id = var.CLIENT_ID
    client_secret = var.CLIENT_SECRET
    skip_provider_registration = true
}

resource "azurerm_resource_group" "gestionfacture" {
    name     = "gestion_facture"
    location = "West Europe"
}

resource "azurerm_app_service_plan" "gestionfactureserviceplan" {
    name                = "gestion_facture-serviceplan"
    location            = azurerm_resource_group.gestionfacture.location
    resource_group_name = azurerm_resource_group.gestionfacture.name

    kind = "Linux"
    reserved = true

    sku {
        tier = "Standard"
        size = "S1"
    }
}

resource "azurerm_app_service" "gestionfactureservice" {
    name                = "gestion-facture-jmx"
    location            = azurerm_resource_group.gestionfacture.location
    resource_group_name = azurerm_resource_group.gestionfacture.name
    app_service_plan_id = azurerm_app_service_plan.gestionfactureserviceplan.id

    site_config {
        linux_fx_version = "DOCKER|jasonmahoux/gestion-facture-jmx:latest_26"
    }

    connection_string {
        name  = "Database"
        type  = "PostgreSQL"
        value = "Server=postgresql-server-jmx.postgres.database.azure.com;Integrated Security=SSPI"
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

/*
* Resource 2
*/
resource "azurerm_resource_group" "gestionfacturebis" {
    name     = "gestion_facture_bis"
    location = "France Central"
}

resource "azurerm_app_service_plan" "gestionfactureserviceplanbis" {
    name                = "gestion_facture-serviceplan-bis"
    location            = azurerm_resource_group.gestionfacturebis.location
    resource_group_name = azurerm_resource_group.gestionfacturebis.name

    kind = "Linux"
    reserved = true

    sku {
        tier = "Standard"
        size = "S1"
    }
}

resource "azurerm_app_service" "gestionfactureservicebis" {
    name                = "gestion-facture-jmx-bis"
    location            = azurerm_resource_group.gestionfacturebis.location
    resource_group_name = azurerm_resource_group.gestionfacturebis.name
    app_service_plan_id = azurerm_app_service_plan.gestionfactureserviceplanbis.id

    site_config {
        linux_fx_version = "DOCKER|jasonmahoux/gestion-facture-jmx:latest_26"
    }

    connection_string {
        name  = "Database"
        type  = "PostgreSQL"
        value = "Server=postgresql-server-jmx-bis.postgres.database.azure.com;Integrated Security=SSPI"
    }
}

// TODO En Version payante faire un replica de la base de données de la ressource 1 vers la ressource 2
resource "azurerm_postgresql_server" "databaseserverbis" {
    location                = azurerm_resource_group.gestionfacturebis.location
    name                    = "postgresql-server-jmx-bis"
    resource_group_name     = azurerm_resource_group.gestionfacturebis.name
    sku_name                = "B_Gen5_2"
    ssl_enforcement_enabled = false
    ssl_minimal_tls_version_enforced = "TLSEnforcementDisabled"
    version                 = "9.5"
    administrator_login     = "postgres"
    administrator_login_password = "PgSqL#24!01$19"
}

resource "azurerm_postgresql_database" "gestionfacturedatabasebis" {
    name                = "gestion-facture-database-jmx-bis"
    resource_group_name = azurerm_resource_group.gestionfacturebis.name
    server_name         = azurerm_postgresql_server.databaseserverbis.name
    charset             = "UTF8"
    collation           = "English_United States.1252"
}