package cn.rbc.service;


import cn.rbc.domain.Role;
import cn.rbc.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findNotHaveAllRole(String id);

    void addRoleToUser(String userId, String[] ids);
}
