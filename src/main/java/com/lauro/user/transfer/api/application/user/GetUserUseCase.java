package com.lauro.user.transfer.api.application.user;

import com.lauro.user.transfer.api.domain.entity.User;
import com.lauro.user.transfer.api.infrastructure.adapters.out.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class GetUserUseCase {

    private final UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll()
                .doOnError(ResourceNotFoundException.class,
                        error -> log.error(error.getMessage(), error));
    }

    public Mono<User> findById(final Long id) {
        return userRepository.findById(id)
                .doOnNext(user -> log.info("User Found with id: {}", user.getId()))
                .doOnError(ResourceNotFoundException.class,
                        error -> log.error("User not found: {}", error.getMessage(), error));
    }
}
