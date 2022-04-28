package com.proplant.backend.domaines.account.web.controller;

import java.security.Principal;

import com.proplant.backend.domaines.account.entity.AppUser;
import com.proplant.backend.domaines.account.entity.Register;
import com.proplant.backend.domaines.account.mappers.AccountMapper;
import com.proplant.backend.domaines.account.service.AccountService;
import com.proplant.backend.domaines.account.web.api.AccountApi;
import com.proplant.backend.domaines.account.web.dto.UserResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;



 @RestController
public class AccountRestController implements AccountApi {
  @Autowired  
  private AccountService accountService;
  
  @Autowired
  private AccountMapper accountMapper;

  @Override
  public ResponseEntity<UserResponseDTO> register(final Register register) {
    if(!register.getPassword().equals(register.getRepassword()))
      throw new RuntimeException("You must confirm your password");
      AppUser user = accountService.findUserByUsername(register.getUsername());
      if(user!=null) throw new RuntimeException("this  use already exist");
      AppUser appUser =new AppUser();
      appUser.setUsername(register.getUsername());
      appUser.setPassword(register.getPassword());
      accountService.saveUser(appUser);
      accountService.addRoleToUser(register.getUsername(), "USER");
      return ResponseEntity.ok(accountMapper.userToUserDTO(appUser));
  }

  @Override
  public ResponseEntity<UserResponseDTO> profile(final Principal principal) {
       AppUser appUser= accountService.findUserByUsername(principal.getName());
       return ResponseEntity.ok(accountMapper.userToUserDTO(appUser));
  }

}
