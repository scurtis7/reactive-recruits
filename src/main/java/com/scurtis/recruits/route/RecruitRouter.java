package com.scurtis.recruits.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Author: Steve Curtis
 * Date: May 12, 2020
 **/

@Configuration
public class RecruitRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllRecruits(RecruitHandler handler) {
        return route(GET("/recruit"), handler::getAllRecruits);
    }

}
