package com.scurtis.recruits.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Author: Steve Curtis
 * Date: Oct 24, 2020
 **/

@Configuration
public class CollegeRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllColleges(CollegeHandler handler) {
        return route(GET("/colleges"), handler::getAllColleges);
    }

}
