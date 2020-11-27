package com.scurtis.recruits.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import static org.springframework.util.Assert.hasText;

/**
 * Author: Steve Curtis
 * Date: May 11, 2020
 **/

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class PostgresJdbcProperties {

    private String url;
    private String username;
    private String password;

    @PostConstruct
    public void onload() {
        hasText(url, "spring.datasource.url property is required");
        hasText(username, "spring.datasource.username property is required");
        hasText(password, "spring.datasource.password property is required");
    }

}
