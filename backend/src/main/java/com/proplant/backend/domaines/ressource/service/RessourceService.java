package com.proplant.backend.domaines.ressource.service;

import java.util.List;

import com.proplant.backend.domaines.ressource.web.dto.RessourceRequestDTO;
import com.proplant.backend.domaines.ressource.web.dto.RessourceResponseDTO;

public interface RessourceService{

    RessourceResponseDTO getRessources(Long id);
    
    List<RessourceResponseDTO> listRessources();
    
    RessourceResponseDTO newRessource(RessourceRequestDTO ressourceRequestDTO);

    void deleteRessource(Long id);
    
}
