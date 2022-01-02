package com.ulrich.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ulrich.api.model.User;

@Repository
@EnableJpaRepositories("com.ulrich.api.repository")
public interface UserRepository extends JpaRepository<User, Long>{

}
