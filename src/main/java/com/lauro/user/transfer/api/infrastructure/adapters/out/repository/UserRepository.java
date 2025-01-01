package com.lauro.user.transfer.api.infrastructure.adapters.out.repository;

import com.lauro.user.transfer.api.domain.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
