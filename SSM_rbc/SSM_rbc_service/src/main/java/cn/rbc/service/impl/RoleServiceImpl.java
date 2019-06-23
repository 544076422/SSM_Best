package cn.rbc.service.impl;

import cn.rbc.dao.RoleDao;
import cn.rbc.domain.Permission;
import cn.rbc.domain.Role;
import cn.rbc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Permission> findNotHaveAllPermission(String id) {
        return roleDao.findNotHavePermission(id);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        for (String permissionId : ids){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
