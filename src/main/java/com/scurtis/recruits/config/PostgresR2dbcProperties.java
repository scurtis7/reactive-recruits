package com.scurtis.recruits.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import static org.springframework.util.Assert.hasText;

/**
 * Author: Steve Curtis
 * Date: May 03, 2020
 **/

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.r2dbc")
public class PostgresR2dbcProperties {

    private String url;
    private String username;
    private String password;

    @PostConstruct
    public void postConstruct() {
        hasText(url, "spring.r2dbc.url property must be set");
        hasText(username, "spring.r2dbc.username property must be set");
        hasText(password, "spring.r2dbc.password property must be set");
    }

}
