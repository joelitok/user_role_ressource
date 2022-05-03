package com.proplant.backend.domaines.account.service;

import javax.transaction.Transactional;

import com.proplant.backend.domaines.account.repository.dao.RoleRepository;
import com.proplant.backend.domaines.account.repository.dao.UserRepository;
import com.proplant.backend.domaines.account.repository.entity.AppRole;
import com.proplant.backend.domaines.account.repository.entity.AppUser;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    

    @Override
    public AppUser saveUser(AppUser user) {
       String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
       user.setPassword(hashPW);
        return userRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole role =roleRepository.findByRoleName(roleName);
        AppUser user =userRepository.findByUsername(username);
        user.getRoles().add(role);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUsers() {
        userRepository.deleteAll();   
    }

    @Override
    public void deleteRoles() {
        roleRepository.deleteAll(); 
    }
    
    
}
