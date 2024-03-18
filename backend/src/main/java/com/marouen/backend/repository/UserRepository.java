package com.marouen.backend.repository;

import com.marouen.backend.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{

    boolean existsByEmail(String email);

    Optional<AppUser> findByEmail(String email);
}
