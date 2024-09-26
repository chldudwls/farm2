package com.farmstory.controller.apicontroller;

import com.farmstory.requestdto.TestRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApiOrderController {

    @PostMapping("/order/direct")
    public ResponseEntity<String> postOrderDirect(
            @RequestBody
            TestRequestDto request
    ){
        String path = "/client/products?section=product&type=all";
        return ResponseEntity.ok().body(path);
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
