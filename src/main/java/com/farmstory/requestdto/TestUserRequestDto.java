package com.farmstory.requestdto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestUserRequestDto {
    private Long user_idx;
    private String user_id;
    private String user_pwd;
    private String user_name;
    private String user_nick;
    private String user_email;
    private String user_hp;
    private Date user_create_at;
    private String user_role;
}
