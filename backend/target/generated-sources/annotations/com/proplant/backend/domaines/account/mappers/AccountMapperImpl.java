package com.proplant.backend.domaines.account.mappers;

import com.proplant.backend.domaines.account.entity.AppRole;
import com.proplant.backend.domaines.account.entity.AppUser;
import com.proplant.backend.domaines.account.web.dto.RoleRequestDTO;
import com.proplant.backend.domaines.account.web.dto.RoleResponseDTO;
import com.proplant.backend.domaines.account.web.dto.UserRequestDTO;
import com.proplant.backend.domaines.account.web.dto.UserResponseDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T14:04:33+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public UserResponseDTO userToUserDTO(AppUser user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId( user.getId() );
        userResponseDTO.setPassword( user.getPassword() );
        Collection<AppRole> collection = user.getRoles();
        if ( collection != null ) {
            userResponseDTO.setRoles( new ArrayList<AppRole>( collection ) );
        }
        userResponseDTO.setUsername( user.getUsername() );

        return userResponseDTO;
    }

    @Override
    public AppUser userRequestDtoToUser(UserRequestDTO userRequestDTO) {
        if ( userRequestDTO == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        appUser.setId( userRequestDTO.getId() );
        appUser.setPassword( userRequestDTO.getPassword() );
        List<AppRole> list = userRequestDTO.getRoles();
        if ( list != null ) {
            appUser.setRoles( new ArrayList<AppRole>( list ) );
        }
        appUser.setUsername( userRequestDTO.getUsername() );

        return appUser;
    }

    @Override
    public RoleResponseDTO roleToRoleDTO(AppRole role) {
        if ( role == null ) {
            return null;
        }

        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();

        roleResponseDTO.setId( role.getId() );

        return roleResponseDTO;
    }

    @Override
    public AppRole roleRequestDtoToRole(RoleRequestDTO roleRequestDTO) {
        if ( roleRequestDTO == null ) {
            return null;
        }

        AppRole appRole = new AppRole();

        appRole.setId( roleRequestDTO.getId() );

        return appRole;
    }
}
