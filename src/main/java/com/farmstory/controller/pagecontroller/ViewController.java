package com.farmstory.controller.pagecontroller;

import com.farmstory.requestdto.TestUserRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class ViewController {

//    @GetMapping("/auth")
//    public ModelAndView getView(@RequestParam String view){
//        ModelAndView mav = new ModelAndView();
//
//        String prefix = "/pages/";
//        mav.setViewName(prefix + "auth" + view);
//        mav.addObject("view", view);
//        if(view.equals("/signup")){
//            mav.addObject("postUserRequestDto", new TestUserRequestDto());
//        }
//
//        return mav;
//    }

    @GetMapping("/signup")
    public ModelAndView signupPage(){
        ModelAndView mav = new ModelAndView();
//        mav.addObject("postUserRequestDto", new TestUserRequestDto());
        mav.setViewName("pages/auth/signup");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView loginPage(
    ){
        ModelAndView mav = new ModelAndView();

            mav.setViewName("pages/auth/login");

        return mav;
    }

    @GetMapping("/find/id")
    public ModelAndView findId(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/pages/auth/find_id");

        return mav;
    }

    @GetMapping("/find/pwd")
    public ModelAndView findPwd(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/pages/auth/find_pwd");

        return mav;
    }



}
