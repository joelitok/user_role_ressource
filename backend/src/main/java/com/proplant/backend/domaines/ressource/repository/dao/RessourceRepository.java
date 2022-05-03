package com.proplant.backend.domaines.ressource.repository.dao;

import com.proplant.backend.domaines.ressource.repository.entity.Ressource;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {
    
}
