package com.litsynp.reactive.api.handler;

import com.litsynp.reactive.api.request.UserRequest;
import com.litsynp.reactive.api.response.UserView;
import com.litsynp.reactive.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@RequiredArgsConstructor
public class UserHandler {

    private final UserService userService;

    @Bean
    public RouterFunction<ServerResponse> userRoutes() {
        return RouterFunctions
                .route(POST("/users").and(accept(MediaType.APPLICATION_JSON)), this::register);
    }

    public Mono<ServerResponse> register(ServerRequest request) {
        return request.bodyToMono(UserRequest.class)
                .flatMap(userService::register)
                .flatMap(user -> ServerResponse.status(HttpStatus.CREATED).bodyValue(UserView.from(user)));
    }
}
