package com.newtownscriptkiddies.ama;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmaConfiguration extends Configuration {

    private static final Logger LOG = LoggerFactory.getLogger(AmaConfiguration.class);
    private static final String HEROKU_DATABASE_URL = "DATABASE_URL";

    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        String herokuDbUrl = System.getenv(HEROKU_DATABASE_URL);
        return HerokuDbUrlConfiguration.getDataSourceFactory(herokuDbUrl);
    }
}
