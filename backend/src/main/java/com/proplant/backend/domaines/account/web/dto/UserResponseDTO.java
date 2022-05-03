package com.proplant.backend.domaines.account.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.proplant.backend.domaines.account.repository.entity.AppRole;

import lombok.Data;

@Data
public class UserResponseDTO {
	private Long id;

	@NotNull
    @Valid
	private String username;

	@NotNull
    @Valid
	private String password;
	
	private List<AppRole> roles = new ArrayList<>(); 
 }
