package com.farmstory.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {
    private final CartService cartService;

    @GetMapping("/carts")
    public ModelAndView getCarts(
            @RequestParam String section,
            @RequestParam String type
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/cart/cart_list");
        mav.addObject("section" ,section);
        mav.addObject("type", type);

        List<GetCartItemsRespDto> getCartItemsRespDtoList = cartService.selectCarts();

        mav.addObject("getCartItemsRespDtoList" , getCartItemsRespDtoList);

        return mav;
    }

    @GetMapping("/orders")
    public ModelAndView getOrders(
            @RequestParam String section,
            @RequestParam String type
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/order/order_list");
        mav.addObject("section" ,section);
        mav.addObject("type", type);
        return mav;
    }

    @GetMapping("/user")
    public ModelAndView getUser(
            @RequestParam String section,
            @RequestParam String type
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/user/user_info");
        mav.addObject("section" ,section);
        mav.addObject("type", type);
        return mav;
    }
}
