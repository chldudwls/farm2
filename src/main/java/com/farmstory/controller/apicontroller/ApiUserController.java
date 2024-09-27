package com.farmstory.controller.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApiUserController {

    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(
            Long userIdx
    ) {
        String path = "/";
        return ResponseEntity.ok().body(path);
    }
}
