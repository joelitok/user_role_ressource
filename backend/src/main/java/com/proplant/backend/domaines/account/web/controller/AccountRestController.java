package com.proplant.backend.domaines.account.web.controller;

import java.security.Principal;
import java.util.List;

import com.proplant.backend.domaines.account.mappers.AccountMapper;
import com.proplant.backend.domaines.account.repository.entity.AppUser;
import com.proplant.backend.domaines.account.repository.entity.Register;
import com.proplant.backend.domaines.account.service.AccountService;
import com.proplant.backend.domaines.account.web.api.AccountApi;
import com.proplant.backend.domaines.account.web.dto.UserResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;




@RequestMapping("/user")
@RestController
public class AccountRestController implements AccountApi {
    Logger logger= LoggerFactory.getLogger(AccountRestController.class);

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
