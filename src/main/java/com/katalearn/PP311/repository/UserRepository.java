package com.katalearn.PP311.repository;

import com.katalearn.PP311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
