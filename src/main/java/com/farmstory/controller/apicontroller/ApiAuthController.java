package com.farmstory.controller.apicontroller;

import com.farmstory.entity.user.UserEntity;
import com.farmstory.requestdto.TestRequestDto;
import com.farmstory.requestdto.user.PutUserReqDto;
import com.farmstory.service.user.EmailService;
import com.farmstory.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.mapping.ResultMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Log4j2
@RequiredArgsConstructor
public class ApiAuthController {

    private final UserService userService;
    private final EmailService emailService;

    @GetMapping("/check/id")
    public ResponseEntity<String> checkId(@RequestParam String userId) {
       log.info("Received userId: " + userId); // 로그 추가

        if(userId.contains(" ")) {
            return ResponseEntity.ok().body("EW");
        }
        if(userId.isEmpty()){
            return ResponseEntity.ok().body("EUI");
        }

        String result = userService.checkId(userId);
        System.out.println("Check ID result: " + result); // 로그 추가

        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/check/nick")
    public ResponseEntity<String> checkNick(@RequestParam String userNick){
        if (userNick.contains(" ")){
            return ResponseEntity.ok().body("EW"); // 공백이 포함된 경우
        }
        if (userNick.isEmpty()){
            return ResponseEntity.ok().body("EUI");
        }
        String result = userService.checkNick(userNick);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/send/email")
    public ResponseEntity<Map<String, Object>> sendEmail(
            @RequestParam String userEmail,
            @RequestParam(value = "userName", defaultValue = "0") String userName,
            @RequestParam(value = "userId", defaultValue = "0") String userId) {

        Map<String, Object> response = new HashMap<>();
        long expiryTime = System.currentTimeMillis() + 300 * 1000;

        String result;
        if (!userName.equals("0")) {
            result = userId.equals("0") ? userService.findIdEmail(userName, userEmail)
                    : userService.findPassEmail(userId, userEmail);
        } else {
            result = userService.sendEmail(userEmail);
        }

        response.put("expiryTime", expiryTime);
        response.put("result", result);

        return ResponseEntity.ok().body(response);
    }


}
