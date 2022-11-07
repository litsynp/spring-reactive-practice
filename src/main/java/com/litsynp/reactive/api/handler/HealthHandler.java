package com.litsynp.reactive.api.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class HealthHandler {

    @Bean
    public RouterFunction<ServerResponse> healthRoutes() {
        return RouterFunctions
                .route(GET("/health").and(accept(MediaType.APPLICATION_JSON)), this::health);
    }

    public Mono<ServerResponse> health(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("OK");
    }
}
