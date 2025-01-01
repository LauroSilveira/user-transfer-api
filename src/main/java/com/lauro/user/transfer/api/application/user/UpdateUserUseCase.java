package com.lauro.user.transfer.api.application.user;

import com.lauro.user.transfer.api.domain.entity.User;
import com.lauro.user.transfer.api.infrastructure.adapters.in.user.UserDto;
import com.lauro.user.transfer.api.infrastructure.adapters.out.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UpdateUserUseCase {

    private final UserRepository userRepository;

    public Mono<User> update(UserDto user) {
        return userRepository.save(new User(null, user.username(), user.password(), user.dni()));
    }
}
