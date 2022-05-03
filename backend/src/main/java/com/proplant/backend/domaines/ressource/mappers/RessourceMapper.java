package com.proplant.backend.domaines.ressource.mappers;

import com.proplant.backend.domaines.ressource.repository.entity.Ressource;
import com.proplant.backend.domaines.ressource.web.dto.RessourceRequestDTO;
import com.proplant.backend.domaines.ressource.web.dto.RessourceResponseDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RessourceMapper{
    RessourceResponseDTO ressourceToRessourceDTO(Ressource ressource);
    Ressource ressourceRequestDtoToRessource(RessourceRequestDTO ressourceRequestDTO);
}
