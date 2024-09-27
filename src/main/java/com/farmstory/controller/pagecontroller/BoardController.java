package com.farmstory.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/client")
public class BoardController {

    @GetMapping("/boards")
    public ModelAndView getBoards(@RequestParam String section, @RequestParam String type){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/board/board_list");
        mav.addObject("section", section);
        mav.addObject("type", type);

        return mav;
    }
}
