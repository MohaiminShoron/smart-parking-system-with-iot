package com.seng696.Seng696.repository;

import com.seng696.Seng696.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByFullName(String fullName);
    User findByEmail(String email);
    boolean existsByEmail(String email);
}