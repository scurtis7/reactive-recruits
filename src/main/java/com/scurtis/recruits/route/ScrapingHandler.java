package com.scurtis.recruits.route;

import com.scurtis.recruits.dto.Two47;
import com.scurtis.recruits.scrape.Two47Scraper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Author: Steve Curtis
 * Date: Apr 26, 2020
 **/

@Slf4j
@RequiredArgsConstructor
public class ScrapingHandler {

    private final Two47Scraper two47Scraper;

    Mono<ServerResponse> handleTwo47(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(two47Scraper.scrape(request.pathVariable("college"), request.pathVariable("year")), Two47.class);
    }

}
