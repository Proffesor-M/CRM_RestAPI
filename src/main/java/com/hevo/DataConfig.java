package com.hevo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class DataConfig extends Configuration {
    @JsonProperty
    private DataSourceFactory database = new
            DataSourceFactory();
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
