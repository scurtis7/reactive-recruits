package com.scurtis.recruits.route;

import com.scurtis.recruits.dto.Two47;
import com.scurtis.recruits.storage.DataAccess;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Author: Steve Curtis
 * Date: May 12, 2020
 **/

@Slf4j
@RequiredArgsConstructor
public class RecruitHandler {

    private final DataAccess dataAccess;

    Mono<ServerResponse> getAllRecruits(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(dataAccess.getAllRecruits(), Two47.class);
    }

}
