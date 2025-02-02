package com.lauro.user.transfer.api.application.usecase.user;

import com.lauro.user.transfer.api.domain.user.User;
import com.lauro.user.transfer.api.infrastructure.adapters.out.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public Mono<User> create(User user) {
        return this.userRepository.save(user);
    }
}
