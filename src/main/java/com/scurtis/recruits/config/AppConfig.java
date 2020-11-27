package com.scurtis.recruits.config;

import com.scurtis.recruits.dto.Two47Repository;
import com.scurtis.recruits.route.CollegeHandler;
import com.scurtis.recruits.route.RecruitHandler;
import com.scurtis.recruits.route.ScrapingHandler;
import com.scurtis.recruits.scrape.Two47Scraper;
import com.scurtis.recruits.scrape.WebScrapingService;
import com.scurtis.recruits.storage.DataAccess;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.sql.DataSource;

/**
 * Author: Steve Curtis
 * Date: Apr 26, 2020
 **/

@Configuration
public class AppConfig {

    @Bean
    public RouterFunction<ServerResponse> htmlRouterPublicIndex(@Value("classpath:/public/index.html") Resource html) {
        return RouterFunctions.route(RequestPredicates.GET("/"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_HTML)
                        .bodyValue(html)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> htmlRouterIndex(@Value("classpath:/index.html") Resource html) {
        return RouterFunctions.route(RequestPredicates.GET("/"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_HTML)
                        .bodyValue(html)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> htmlRouter(@Value("classpath:/**") Resource html) {
        return RouterFunctions.route(RequestPredicates.GET("/"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_HTML)
                        .bodyValue(html)
        );
    }
    @Bean
    public ConnectionFactory connectionFactory(PostgresR2dbcProperties properties) {
        ConnectionFactoryOptions baseOptions = ConnectionFactoryOptions.parse(properties.getUrl());
        ConnectionFactoryOptions.Builder optionsBuilder = ConnectionFactoryOptions.builder().from(baseOptions);
        optionsBuilder.option(ConnectionFactoryOptions.USER, properties.getUsername());
        optionsBuilder.option(ConnectionFactoryOptions.PASSWORD, properties.getPassword());
        return ConnectionFactories.get(optionsBuilder.build());
    }

    @Bean
    public ScrapingHandler scrapingHandler(Two47Scraper two47Scraper) {
        return new ScrapingHandler(two47Scraper);
    }

    @Bean
    public RecruitHandler recruitHandler(DataAccess dataAccess) {
        return new RecruitHandler(dataAccess);
    }

    @Bean
    public CollegeHandler collegeHandler(DataAccess dataAccess) {
        return new CollegeHandler(dataAccess);
    }

    @Bean
    public Two47Scraper two47Scraper(WebScrapingService webScrapingService, DataAccess dataAccess) {
        return new Two47Scraper(webScrapingService, dataAccess);
    }

    @Bean
    public WebScrapingService webScrapingService() {
        return new WebScrapingService();
    }

    @Bean
    public DataAccess dataAccess(Two47Repository repository, ConnectionFactory connectionFactory) {
        return new DataAccess(repository, connectionFactory);
    }

    @Bean
    public DataSource dataSource(PostgresJdbcProperties postgresJdbcProperties) {
        return DataSourceBuilder.create()
                .url(postgresJdbcProperties.getUrl())
                .username(postgresJdbcProperties.getUsername())
                .password(postgresJdbcProperties.getPassword())
                .build();
    }

    @Autowired
    private void initializeDatabase(DataSource dataSource) {
        FlywayConfigurationUtils.runFlyway(dataSource);
    }

}
