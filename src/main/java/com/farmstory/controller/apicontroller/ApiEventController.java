package com.farmstory.controller.apicontroller;

import com.farmstory.requestdto.user.PostScheduleReqDto;
import com.farmstory.service.user.UserScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
public class ApiEventController {

    private final UserScheduleService userScheduleService;

    @PostMapping("/schedule")
    public ResponseEntity<String> postSchedule(
            @RequestBody PostScheduleReqDto dto
            ) {

        String result = userScheduleService.insertSchedule(dto);

        if("SU".equals(result)){
            return ResponseEntity.ok().body("http://localhost:8080/client/event?section=event&&type=schedule");
        }
        return ResponseEntity.ok().body("http://localhost:8080/view/login");
    }  // 일정 추가하기

}
