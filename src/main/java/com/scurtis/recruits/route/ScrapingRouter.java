package com.scurtis.recruits.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Author: Steve Curtis
 * Date: Apr 26, 2020
 **/

@Configuration
public class ScrapingRouter {

    @Bean
    public RouterFunction<ServerResponse> scrapeTwo47(ScrapingHandler handler) {
        return route(GET("/scrape/247/{college}/{year}"), handler::handleTwo47);
    }

}
