package com.rahul.devops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.devops.domain.Auth;

@Repository
public interface AuthRepository extends JpaRepository<Auth,String> {
    Auth findByUsernameAndPassword(String username,String password);
}
