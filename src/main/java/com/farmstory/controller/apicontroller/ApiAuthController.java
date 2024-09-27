package com.farmstory.controller.apicontroller;

import com.farmstory.requestdto.TestRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {
    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(
            @RequestBody TestRequestDto testRequestDto
            ){
        String result = "success";
        return ResponseEntity.ok().body(result);

    }
}
