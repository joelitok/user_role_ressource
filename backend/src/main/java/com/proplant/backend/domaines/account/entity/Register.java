package com.proplant.backend.domaines.account.entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Register {

    @NotNull
    @Valid
    private String username;

    @NotNull
    @Valid
    private String password;

    @NotNull
    @Valid
    private String repassword;
}
