package cn.rbc.web.controller;

import cn.rbc.domain.Permission;
import cn.rbc.service.PermissionService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("permissionList",permissionService.findAll());
        return "permission-list";
    }
    @RequestMapping("/save")
    public ModelAndView save(Permission permission){
        permissionService.save(permission);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/permission/findAll");
        return modelAndView;
    }
}
