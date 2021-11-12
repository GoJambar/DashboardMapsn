package com.mapsnDashbaord.repository;
import com.mapsnDashbaord.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}