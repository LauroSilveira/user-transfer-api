package com.lauro.user.transfer.api.infrastructure.adapters.in.user;

import com.lauro.user.transfer.api.application.user.CreateUserUseCase;
import com.lauro.user.transfer.api.application.user.GetUserUseCase;
import com.lauro.user.transfer.api.application.user.UpdateUserUseCase;
import com.lauro.user.transfer.api.domain.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final CreateUserUseCase createUserUsecase;
    private final UpdateUserUseCase updateUserUsecase;
    private final GetUserUseCase getUserUsecase;

    @PostMapping
    public Mono<ResponseEntity<User>> create(@RequestBody final User user) {
        log.info("Create user: {}", user);
        return createUserUsecase.create(user).map(ResponseEntity::ok);
    }

    @PutMapping
    public ResponseEntity<Mono<User>> update(@RequestBody final UserDto user) {
        log.info("Update user: {}", user);
        return ResponseEntity.ok(updateUserUsecase.update(user));
    }

    @GetMapping
    public ResponseEntity<Flux<User>> findAll() {
        log.info("Find all users");
        return ResponseEntity.ok(getUserUsecase.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<User>> findById(@PathVariable("id") final Long id) {
        log.info("Find user by id: {}", id);
        return ResponseEntity.ok(getUserUsecase.findById(id));
    }

}
