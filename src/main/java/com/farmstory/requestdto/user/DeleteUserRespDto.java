package com.farmstory.requestdto.user;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class DeleteUserRespDto {
    private List<String> userIdx;
}
