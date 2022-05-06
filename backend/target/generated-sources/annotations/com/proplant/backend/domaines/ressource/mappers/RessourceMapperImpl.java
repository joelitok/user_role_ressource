package com.proplant.backend.domaines.ressource.mappers;

import com.proplant.backend.domaines.ressource.repository.entity.Ressource;
import com.proplant.backend.domaines.ressource.web.dto.RessourceRequestDTO;
import com.proplant.backend.domaines.ressource.web.dto.RessourceResponseDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-06T11:23:49+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class RessourceMapperImpl implements RessourceMapper {

    @Override
    public RessourceResponseDTO ressourceToRessourceDTO(Ressource ressource) {
        if ( ressource == null ) {
            return null;
        }

        RessourceResponseDTO ressourceResponseDTO = new RessourceResponseDTO();

        ressourceResponseDTO.setId( ressource.getId() );
        ressourceResponseDTO.setName( ressource.getName() );

        return ressourceResponseDTO;
    }

    @Override
    public Ressource ressourceRequestDtoToRessource(RessourceRequestDTO ressourceRequestDTO) {
        if ( ressourceRequestDTO == null ) {
            return null;
        }

        Ressource ressource = new Ressource();

        ressource.setId( ressourceRequestDTO.getId() );
        ressource.setName( ressourceRequestDTO.getName() );

        return ressource;
    }
}
