package com.farmstory.controller.pagecontroller;

import com.farmstory.entity.product.ProductEntity;
import com.farmstory.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/client")

@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/order/direct")
    public ModelAndView postOrder(
            @RequestParam Long prodIdx,
            @RequestParam Long cartItemQuantity
    ){
        ModelAndView mav = new ModelAndView();
        ProductEntity prod = orderService.getDirectView(prodIdx,cartItemQuantity);
        mav.setViewName("pages/order/order_direct");
        mav.addObject("prodIdx", prodIdx);
        mav.addObject("quantity", cartItemQuantity);
        mav.addObject("section","product");
        mav.addObject("product", prod);
        return mav;
    }
}
