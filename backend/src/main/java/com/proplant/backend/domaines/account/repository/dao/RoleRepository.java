package com.proplant.backend.domaines.account.repository.dao;

import com.proplant.backend.domaines.account.repository.entity.AppRole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<AppRole,Long>{
    public AppRole findByRoleName(String roleName);
    
}
