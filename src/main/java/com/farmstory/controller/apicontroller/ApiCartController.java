package com.farmstory.controller.apicontroller;

import com.farmstory.requestdto.TestCartRequestDto;
import com.farmstory.requestdto.TestRequestDto;
import com.farmstory.requestdto.cart.PostCartItemReqDto;
import com.farmstory.service.cart.CartService;
import com.farmstory.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ApiCartController {

    private final CartService cartService;

    @PostMapping("/cart")
    public ResponseEntity<String> postCart(
            @RequestBody PostCartItemReqDto request
    ){
        System.out.println("Post cart request: {}" + request);

        String result = cartService.insertCart(request);
        System.out.println(result+"=======================");

        String path = "/client/products?section=product&type=all";

        return ResponseEntity.ok().body(path);
    }

    @DeleteMapping("/cart")
    public ResponseEntity<String> deleteCart(
            @RequestParam Long cartIdx){

        String path = "/mypage/carts?section=mypage&type=cart";

        return ResponseEntity.ok(path);
    }
}
