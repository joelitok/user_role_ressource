package com.proplant.backend.domaines.account.repository.dao;

import com.proplant.backend.domaines.account.repository.entity.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String username);
    
}
