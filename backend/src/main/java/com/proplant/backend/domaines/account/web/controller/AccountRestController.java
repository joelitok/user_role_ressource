package com.proplant.backend.domaines.account.web.controller;

import java.security.Principal;
import java.util.List;
import java.util.logging.LogManager;

import com.proplant.backend.domaines.account.mappers.AccountMapper;
import com.proplant.backend.domaines.account.repository.entity.AppUser;
import com.proplant.backend.domaines.account.repository.entity.Register;
import com.proplant.backend.domaines.account.service.AccountService;
import com.proplant.backend.domaines.account.web.api.AccountApi;
import com.proplant.backend.domaines.account.web.dto.UserResponseDTO;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import javassist.bytecode.stackmap.TypeData.ClassName;



 @RestController
public class AccountRestController implements AccountApi {
  private  Logger logger ; //= LoggerFactory.getLogger(UserResponseDTO.class);

  @Autowired  
  private AccountService accountService;
  
  @Autowired
  private AccountMapper accountMapper;

  @Override
  public ResponseEntity<UserResponseDTO> register(final Register register) {
    logger.info("register new user");
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
    logger.info("get user profile");
       AppUser appUser= accountService.findUserByUsername(principal.getName());
       return ResponseEntity.ok(accountMapper.userToUserDTO(appUser));
  }

  @Override
  public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
    logger.info("list all users");
    return null;
  }

  @Override
  public ResponseEntity<List<UserResponseDTO>> getAllUsers(String username) {
    logger.info("list all users by username");
    return null;
  }

  @Override
  public ResponseEntity<List<UserResponseDTO>> getAllUsersSortByParam(String contextId, String dirdId) {
    logger.info("sort users");
    return null;
  }

}
