package com.proplant.backend.domaines.ressource.web.controller;

import java.util.List;
import java.util.logging.Logger;

import com.proplant.backend.domaines.ressource.service.RessourceService;
import com.proplant.backend.domaines.ressource.web.api.RessourceApi;
import com.proplant.backend.domaines.ressource.web.dto.RessourceRequestDTO;
import com.proplant.backend.domaines.ressource.web.dto.RessourceResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ressource")
@RestController
public class RessourceRestController implements RessourceApi{
    private  Logger logger ; //= LoggerFactory.getLogger(UserResponseDTO.class);
    @Autowired
    private RessourceService ressourceService;

    @Override
    public ResponseEntity<RessourceResponseDTO> getRessources(Long ressourceId) {
        logger.info("get ressource");
       return ResponseEntity.ok(ressourceService.getRessources(ressourceId));
    }

    @Override
    public ResponseEntity<List<RessourceResponseDTO>> listRessources() {
        //logger.info("list all ressources");
        return ResponseEntity.ok(ressourceService.listRessources());
    }

    @Override
    public ResponseEntity<RessourceResponseDTO> newRessource(RessourceRequestDTO RessourceRequestDTO) {
        logger.info("add new ressource");
        return ResponseEntity.ok(ressourceService.newRessource(RessourceRequestDTO));
    }

    @Override
    public ResponseEntity<Void> deleteRessource(Long ressourceId) {
        logger.info("delete ressource");
    ressourceService.deleteRessource(ressourceId);
    return null;
    }
  
}
