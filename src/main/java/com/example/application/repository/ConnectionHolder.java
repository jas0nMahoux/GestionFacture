package com.example.application.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton permettant de garder la connection JDBC ouverte.
 */
public enum ConnectionHolder {
    INSTANCE;
    private static final String URL = "jdbc:postgresql://postgresql-server-jmx.postgres.database.azure.com:5432/gestion-facture-database-jmx?user=postgres@postgresql-server-jmx&password=PgSqL#24!01$19";
    private final Connection connection;

    ConnectionHolder() {
        try {
            this.connection = DriverManager.getConnection(URL, "postgres@postgresql-server-jmx", "PgSqL#24!01$19");
            new SchemaInitializer(connection).initialize();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

