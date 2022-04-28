package com.proplant.backend.domaines.ressource.web.controller;

import java.util.List;

import com.proplant.backend.domaines.ressource.service.RessourceService;
import com.proplant.backend.domaines.ressource.web.api.RessourceApi;
import com.proplant.backend.domaines.ressource.web.dto.RessourceRequestDTO;
import com.proplant.backend.domaines.ressource.web.dto.RessourceResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RessourceRestController implements RessourceApi{

    @Autowired
    private RessourceService ressourceService;

    @Override
    public ResponseEntity<RessourceResponseDTO> getRessources(Long ressourceId) {
       return ResponseEntity.ok(ressourceService.getRessources(ressourceId));
    }

    @Override
    public ResponseEntity<List<RessourceResponseDTO>> listRessources() {
        return ResponseEntity.ok(ressourceService.listRessources());
    }

    @Override
    public ResponseEntity<RessourceResponseDTO> newRessource(RessourceRequestDTO RessourceRequestDTO) {
        return ResponseEntity.ok(ressourceService.newRessource(RessourceRequestDTO));
    }

    @Override
    public ResponseEntity<Void> deleteRessource(Long ressourceId) {
    ressourceService.deleteRessource(ressourceId);
    return null;
    }
  
}
