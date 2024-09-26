package com.farmstory.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/client")
public class OrderController {

    @GetMapping("/order/direct")
    public ModelAndView postOrder(
            @RequestParam Long prodIdx,
            @RequestParam int quantity
            ){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/pages/order/order_direct");
        mav.addObject("prodIdx", prodIdx);
        mav.addObject("quantity", quantity);
        mav.addObject("section","product");
        return mav;
    }
}
