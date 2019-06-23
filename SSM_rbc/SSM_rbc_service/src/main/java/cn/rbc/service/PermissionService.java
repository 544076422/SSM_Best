package cn.rbc.service;

import cn.rbc.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    void save(Permission permission);
}
