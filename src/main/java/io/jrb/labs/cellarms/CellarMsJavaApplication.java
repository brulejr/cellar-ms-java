package io.jrb.labs.cellarms;

import io.jrb.labs.cellarms.web.WineRoutes;
import io.jrb.labs.common.resource.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
@Slf4j
public class CellarMsJavaApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CellarMsJavaApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routes(final WineRoutes wineRoutes) {
		return route()
				.add(wineRoutes.routes())
				.build();
	}

}
