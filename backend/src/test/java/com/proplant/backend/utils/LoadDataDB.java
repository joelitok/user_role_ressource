package com.proplant.backend.utils;

import com.proplant.backend.domaines.account.service.AccountService;
import com.proplant.backend.domaines.ressource.mappers.RessourceMapper;
import com.proplant.backend.domaines.ressource.repository.dao.RessourceRepository;
import com.proplant.backend.domaines.ressource.repository.entity.Ressource;
import com.proplant.backend.domaines.ressource.service.RessourceService;
import com.proplant.backend.domaines.ressource.web.dto.RessourceRequestDTO;
import com.proplant.backend.domaines.ressource.web.dto.RessourceResponseDTO;

import org.springframework.http.ResponseEntity;

public class LoadDataDB{
    public final RessourceService ressourceService;
    public final AccountService accountService;
    public final RessourceMapper ressourceMapper;
    public final RessourceRepository ressourceRepository;

    public LoadDataDB(
    RessourceService ressourceService, 
    AccountService accountService,
    RessourceMapper ressourceMapper,
    RessourceRepository ressourceRepository
    ) {
        this.ressourceService = ressourceService;
        this.accountService = accountService;
        this.ressourceMapper = ressourceMapper;
        this.ressourceRepository = ressourceRepository;
    }

    
    public ResponseEntity<RessourceResponseDTO> loadRessourceDB(RessourceRequestDTO ressourceRequestDTO){
            Ressource ressource =ressourceMapper.ressourceRequestDtoToRessource(ressourceRequestDTO);
            ressource.setName(ressourceRequestDTO.getName());
            Ressource saveRessource = ressourceRepository.save(ressource);
            return ResponseEntity.ok(ressourceMapper.ressourceToRessourceDTO(saveRessource));
  
    }
}
