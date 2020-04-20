package com.example.edu.booking.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJpaRepository extends JpaRepository<UserJpaEntity, String> {
}
