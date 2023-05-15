package com.bob_R;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class Spring13DataCinemaLLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring13DataCinemaLLabApplication.class, args);
	}
	@Bean
	// from here create table  main
	public MigrateResult migrateResult(DataSource dataSource){
		return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
	}
}
