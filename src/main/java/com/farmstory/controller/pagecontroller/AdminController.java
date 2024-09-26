package com.farmstory.controller.pagecontroller;

import com.farmstory.entity.product.ProductEntity;
import com.farmstory.requestdto.product.GetProductDto;
import com.farmstory.responsedto.user.GetUsersRespDto;
import com.farmstory.service.product.ProductService;
import com.farmstory.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final ProductService productService;

    @GetMapping("/users/products/orders")
    public ModelAndView orders(
            @RequestParam(value="page", defaultValue="0") int page
    ){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/admin/admin_main");

        Page<GetProductDto> products = productService.selectPageProduct(page);
        Page<GetUsersRespDto> users = userService.selectUsers(page);

        mav.addObject("products", products);
        mav.addObject("users", users);

        return mav;
    }

    @GetMapping("/products")
    public ModelAndView product(
            @RequestParam(value="page", defaultValue="0") int page
    ){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/admin/admin_product_list");
        mav.addObject("section","product");

        Page<GetProductDto> products2 = productService.selectPageProduct(page);
        mav.addObject("products", products2);
        mav.addObject("currentPage", page);
        mav.addObject("totalPage", Math.ceil((double)products2.getTotalElements()/10));

        return mav;
    }

    @GetMapping("/view/product")
    public ModelAndView viewProduct(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/admin/admin_post_product");
        mav.addObject("section","postproduct");

        return mav;
    }

    @GetMapping("/orders")
    public ModelAndView order(

    ){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/admin/admin_order_list");
        mav.addObject("section","order");

        return mav;
    }

    @GetMapping("/users")
    public ModelAndView user(
            @RequestParam(value="page", defaultValue="0") int page
    ){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/admin/admin_user_list");
        mav.addObject("section","user");

        Page<GetUsersRespDto> users = userService.selectUsers(page);
        users.forEach(v->{
            System.out.println(v);
        });
        List<String> roles = new ArrayList<>();
        roles.add("user");
        roles.add("admin");
        roles.add("withdrawal");
        mav.addObject("users", users);
        mav.addObject("currentPage", page);
        mav.addObject("totalPage", Math.ceil((double)users.getTotalElements()/10));
        mav.addObject("roles", roles);

        return mav;
    }
}
