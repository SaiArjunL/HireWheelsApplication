package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Role;

public interface RoleService {
    public Role findByRoleName(String roleName);
}
