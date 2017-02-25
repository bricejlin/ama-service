package com.newtownscriptkiddies.ama;

import io.dropwizard.db.DataSourceFactory;
import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HerokuDbUrlConfiguration {

    private final static Logger LOG = LoggerFactory.getLogger(HerokuDbUrlConfiguration.class);

    public static DataSourceFactory getDataSourceFactory(String dbUrl) {
        if (dbUrl == null) {
            throw new IllegalArgumentException("The DATABASE_URL environment variable must be set before running the app.");
        }

        URI dbUri = URI.create(dbUrl);
        final String user = dbUri.getUserInfo().split(":")[0];
        final String password = dbUri.getUserInfo().split(":")[1];
        final String url = String.format(
            "jdbc:postgresql://%s:%s%s?user=%s&password=%s&sslmode=require",
            dbUri.getHost(), dbUri.getPort(), dbUri.getPath(), user, password);

        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        dataSourceFactory.setUser(user);
        dataSourceFactory.setPassword(password);
        dataSourceFactory.setUrl(url);
        dataSourceFactory.setDriverClass("org.postgresql.Driver");

        return dataSourceFactory;
    }
}
