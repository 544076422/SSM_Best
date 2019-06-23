package cn.rbc.web.controller;

import cn.rbc.domain.Role;
import cn.rbc.domain.UserInfo;
import cn.rbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<UserInfo> userInfoList = userService.findAll();
        model.addAttribute("userList",userInfoList);
        return "user-list";
    }
    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:/user/findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-show");
        UserInfo userInfo = userService.findById(id);
        modelAndView.addObject("user" , userInfo);
        System.out.println(userInfo);
        return modelAndView;
    }
    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(String id,Model model){
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("user",userInfo);
        List<Role> roles = userService.findNotHaveAllRole(id);
        model.addAttribute("roleList",roles);
        return "user-role-add";
    }
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId , String[] ids){
        userService.addRoleToUser(userId,ids);
        return "redirect:/user/findAll";
    }

}
