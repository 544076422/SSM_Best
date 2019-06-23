package cn.rbc.web.controller;

import cn.rbc.domain.Syslog;
import cn.rbc.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/syslog")
public class SyslogController {
    @Autowired
    private SyslogService syslogService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Syslog> syslogs = syslogService.findAll();
        model.addAttribute("syslogs",syslogs);
        return "syslog-list";
    }
}
