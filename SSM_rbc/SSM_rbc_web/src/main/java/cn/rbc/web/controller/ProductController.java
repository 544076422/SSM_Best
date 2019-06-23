package cn.rbc.web.controller;

import cn.rbc.domain.Product;
import cn.rbc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("/ProductController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("productList",productService.findAll());
        return "product-list";
    }
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:/ProductController/findAll";
    }
}
