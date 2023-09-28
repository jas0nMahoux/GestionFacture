package com.example.application.repository;

import java.sql.Connection;
import java.sql.SQLException;

public class SchemaInitializer {

    private final Connection connection;

    SchemaInitializer(Connection connection) {
        this.connection = connection;
    }

    public void initialize() throws SQLException {
        createSchema();
    }

    private void createSchema() throws SQLException {
        try (var statement = connection.createStatement()) {
            statement.execute("CREATE TABLE article (" +
                " id INT NOT NULL, " +
                " nom VARCHAR NOT NULL, " +
                " prix FLOAT " +
                ")");
        }
    }
}
