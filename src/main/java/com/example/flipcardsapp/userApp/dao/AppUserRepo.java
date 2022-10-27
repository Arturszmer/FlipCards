package com.example.flipcardsapp.userApp.dao;

import com.example.flipcardsapp.userApp.dao.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    Optional<AppUser> deleteByUserName(String userName);

    Optional<AppUser> findByUserName(String userName);
}
