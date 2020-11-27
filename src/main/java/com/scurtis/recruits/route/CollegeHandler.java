package com.scurtis.recruits.route;

import com.scurtis.recruits.dto.College;
import com.scurtis.recruits.storage.DataAccess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Author: Steve Curtis
 * Date: Oct 24, 2020
 **/

@RequiredArgsConstructor
public class CollegeHandler {

    private final DataAccess dataAccess;

    Mono<ServerResponse> getAllColleges(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(dataAccess.getAllColleges(), College.class);
    }

}
