package cn.rbc.service;

import cn.rbc.domain.Permission;
import cn.rbc.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();

    void save(Role role);

    Role findById(String id);

    List<Permission> findNotHaveAllPermission(String id);

    void addPermissionToRole(String roleId, String[] ids);
}
