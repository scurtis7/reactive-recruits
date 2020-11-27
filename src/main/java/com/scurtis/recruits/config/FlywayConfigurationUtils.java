package com.scurtis.recruits.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationVersion;

import javax.sql.DataSource;

/**
 * Author: Steve Curtis
 * Date: May 11, 2020
 **/

public class FlywayConfigurationUtils {

    public static void runFlyway(DataSource ds) {
        Flyway flyway = Flyway.configure()
                .dataSource(ds)
                .baselineOnMigrate(true)
                .baselineVersion(MigrationVersion.fromVersion("0")).load();

        flyway.repair();
        flyway.migrate();
    }

}
