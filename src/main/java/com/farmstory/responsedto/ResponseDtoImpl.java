package com.farmstory.responsedto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.ModelAndView;

@Getter
@Setter
public class ResponseDtoImpl implements ResponseDto {
    private String code;
    private String section;
    private String type;
    private ModelAndView mav;
}
