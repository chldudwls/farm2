package com.farmstory.controller.pagecontroller;

import com.farmstory.requestdto.user.PostScheduleReqDto;
import com.farmstory.service.user.UserScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/client/event")
@RequiredArgsConstructor
public class EventController {

    private final UserScheduleService userScheduleService;

    @GetMapping()
    public ModelAndView calendar(
            @RequestParam String section,
            @RequestParam String type
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/event/event_calendar");
        mav.addObject("section",section);
        mav.addObject("type",type);

        List<PostScheduleReqDto> schedules = userScheduleService.selectSchedules();
        mav.addObject("schedules",schedules);

        return mav;
    }

}
