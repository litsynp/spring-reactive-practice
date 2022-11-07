package com.litsynp.reactive.application;

import com.litsynp.reactive.api.request.UserRequest;
import com.litsynp.reactive.domain.User;
import com.litsynp.reactive.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<User> register(UserRequest userRequest) {
        return userRepository.insert(new User(null, userRequest.getEmail(), userRequest.getName()));
    }
}
