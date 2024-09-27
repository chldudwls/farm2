package com.farmstory.controller.apicontroller;

import com.farmstory.entity.product.ProductEntity;
import com.farmstory.requestdto.TestRequestDto;
import com.farmstory.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ApiOrderController {

    private final OrderService orderService;

    @PostMapping("/order/direct")
    public ResponseEntity<String> postOrderDirect(
            @RequestBody
            TestRequestDto request
    ){
        System.out.println(request);
        String path = "/client/products?section=product&type=all";
        return ResponseEntity.ok().body(path);
    }

    @GetMapping("/order/direct/view")
    public ResponseEntity<Map<String, Object>> getOrderDirectView(
            @RequestParam Long prodIdx,
            @RequestParam Long cartItemQuantity
    ){




        return null;
    }

    @PostMapping("/order")
    public ResponseEntity<String> postOrder(
            @RequestBody TestRequestDto request
    ){
        System.out.println(request.getName());
        System.out.println(request.getAddr());

        String path = "/client/products?section=product&type=all";

        return ResponseEntity.ok().body(path);
    }

}
