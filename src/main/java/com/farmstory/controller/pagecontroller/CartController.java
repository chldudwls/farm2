package com.farmstory.controller.pagecontroller;

import com.farmstory.responsedto.user.GetOrderUserDto;
import com.farmstory.service.cart.CartService;
import com.farmstory.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client")
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    @GetMapping("/carts")
    public ModelAndView getCart() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/cart/cart_list");
        mav.addObject("section" ,"product");


        cartService.selectCarts();




        return mav;
    }
}
