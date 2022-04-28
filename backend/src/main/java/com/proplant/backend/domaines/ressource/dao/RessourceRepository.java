package com.proplant.backend.domaines.ressource.dao;

import com.proplant.backend.domaines.ressource.entity.Ressource;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {
    
}
