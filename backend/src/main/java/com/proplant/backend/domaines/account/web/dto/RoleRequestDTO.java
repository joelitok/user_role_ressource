package com.proplant.backend.domaines.account.web.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RoleRequestDTO {
private Long id;

@NotNull
@Valid
private String name;    
}
