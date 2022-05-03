package com.proplant.backend.domaines.ressource.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.proplant.backend.domaines.ressource.mappers.RessourceMapper;
import com.proplant.backend.domaines.ressource.repository.dao.RessourceRepository;
import com.proplant.backend.domaines.ressource.repository.entity.Ressource;
import com.proplant.backend.domaines.ressource.web.dto.RessourceRequestDTO;
import com.proplant.backend.domaines.ressource.web.dto.RessourceResponseDTO;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RessourceServiceImpl implements RessourceService{
    private final RessourceRepository ressourceRepository;
    private final RessourceMapper ressourceMapper;

    @Override
    public RessourceResponseDTO getRessources(Long id) {
       Ressource ressource = ressourceRepository.findById(id).orElse(null);
       if(ressource==null) throw new RuntimeException("Ressource not found");
        return ressourceMapper.ressourceToRessourceDTO(ressource);
    }

    
    @Override
    public List<RessourceResponseDTO> listRessources() {
        List<Ressource> ressources = ressourceRepository.findAll();
        return ressources.stream().map((res)->ressourceMapper.ressourceToRessourceDTO(res)).collect(Collectors.toList());
    }

    
    @Override
    public RessourceResponseDTO newRessource(RessourceRequestDTO ressourceRequestDTO) {
        Ressource ressource =ressourceMapper.ressourceRequestDtoToRessource(ressourceRequestDTO);
        ressource.setId(ressourceRequestDTO.getId());
        ressource.setName(ressourceRequestDTO.getName());
        Ressource saveRessource =ressourceRepository.save(ressource);
        return ressourceMapper.ressourceToRessourceDTO(saveRessource);
    }


    @Override
    public void deleteRessource(Long id) {
    ressourceRepository.deleteById(id);  
    }

    
    
}
