package com.proplant.backend.domaines.account.service;

import com.proplant.backend.domaines.account.entity.AppRole;
import com.proplant.backend.domaines.account.entity.AppUser;

public interface AccountService{
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUser(String username,String roleName);
    public AppUser findUserByUsername(String username);
    public void deleteUsers();
    public void deleteRoles();
}
