package com.proplant.backend.domaines.account.mappers;

import com.proplant.backend.domaines.account.entity.AppRole;
import com.proplant.backend.domaines.account.entity.AppUser;
import com.proplant.backend.domaines.account.web.dto.RoleRequestDTO;
import com.proplant.backend.domaines.account.web.dto.RoleResponseDTO;
import com.proplant.backend.domaines.account.web.dto.UserRequestDTO;
import com.proplant.backend.domaines.account.web.dto.UserResponseDTO;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AccountMapper {

UserResponseDTO userToUserDTO(AppUser user);

AppUser userRequestDtoToUser(UserRequestDTO userRequestDTO);

RoleResponseDTO roleToRoleDTO(AppRole role);

AppRole roleRequestDtoToRole(RoleRequestDTO roleRequestDTO);
    
}
