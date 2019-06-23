package cn.rbc.web.controller;

import cn.rbc.dao.RoleDao;
import cn.rbc.domain.Permission;
import cn.rbc.domain.Role;
import cn.rbc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "role-list";
    }
    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/findAll";
    }
    @RequestMapping("/findRoleByIdAndAllPermission")
    public String findRoleByIdAndAllPermission(String id , Model model){
        Role role = roleService.findById(id);
        List<Permission> permissionList = roleService.findNotHaveAllPermission(id);
        model.addAttribute("role",role);
        model.addAttribute("permissionList",permissionList);
        return "role-permission-add";
    }
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(String roleId , String[] ids){
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:/role/findAll";
    }
}
