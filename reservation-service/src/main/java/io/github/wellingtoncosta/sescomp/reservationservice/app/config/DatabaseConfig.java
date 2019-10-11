package io.github.wellingtoncosta.sescomp.reservationservice.app.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.wellingtoncosta.sescomp.reservationservice.ReservationServiceApp;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = ReservationServiceApp.class)
public class DatabaseConfig {

    public @Bean @FlywayDataSource DataSource dataSource(DataSourceProperties dataSourceProperties) {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName(dataSourceProperties.getDriverClassName());
        config.setJdbcUrl(dataSourceProperties.getUrl());
        config.setUsername(dataSourceProperties.getUsername());
        config.setPassword(dataSourceProperties.getPassword());

        return new HikariDataSource(config);
    }

}
