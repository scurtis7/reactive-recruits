package com.scurtis.recruits.storage;

import com.scurtis.recruits.dto.College;
import com.scurtis.recruits.dto.Two47;
import com.scurtis.recruits.dto.Two47Repository;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * Author: Steve Curtis
 * Date: May 10, 2020
 **/

@Slf4j
@RequiredArgsConstructor
public class DataAccess {

    private final Two47Repository repository;
    private final ConnectionFactory connectionFactory;

    private DatabaseClient client;

    private static final String SQL_GET_ALL_RECRUITS = "SELECT * FROM recruits_two47";
    private static final String SQL_GET_ALL_COLLEGES = "SELECT * FROM colleges";

    public Flux<Two47> saveRecruits(List<Two47> recruits) {
        return repository.saveAll(recruits)
                .onErrorContinue((err, obj) -> log.error(err.getMessage()));
    }

    public Flux<Two47> getAllRecruits() {
        return getClient().execute(SQL_GET_ALL_RECRUITS)
                .as(Two47.class)
                .fetch()
                .all();
    }

    public Flux<College> getAllColleges() {
        return getClient().execute(SQL_GET_ALL_COLLEGES)
                .as(College.class)
                .fetch()
                .all();
    }

    private DatabaseClient getClient() {
        if (client == null) {
            client = DatabaseClient.create(connectionFactory);
        }
        return client;
    }

}
