package com.farmstory.service.user;

import com.farmstory.entity.user.UserEntity;
import com.farmstory.entity.user.UserScheduleEntity;
import com.farmstory.repository.user.UserRepository;
import com.farmstory.repository.user.UserScheduleRepository;
import com.farmstory.requestdto.user.PostScheduleReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserScheduleService {
    private final UserScheduleRepository userScheduleRepository;
    private final UserRepository userRepository;

    public String insertSchedule(PostScheduleReqDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // 사용자 이름(일반적으로 username or email)


        UserEntity user = UserEntity.builder().userId(username).build();
        Optional<UserEntity> userIdx = userRepository.findByUserId(user.getUserId());
        System.out.println(userIdx.get().getUserIdx());
        dto.setUserIdx(userIdx.get().getUserIdx());

        UserScheduleEntity userScheduleEntity = dto.toEntity();
        userScheduleRepository.save(userScheduleEntity);
        return "SU";
    } // 일정 추가하기

    public List<PostScheduleReqDto> selectSchedules() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // 사용자 이름(일반적으로 username or email)

        UserEntity user = UserEntity.builder().userId(username).build();
        Optional<UserEntity> userIdx = userRepository.findByUserId(user.getUserId());


        if (userIdx.isPresent()) {
            List<UserScheduleEntity> schedules = userScheduleRepository.findAllByUserIdx(userIdx.get().getUserIdx());

            // DTO로 변환된 리스트를 반환
            return schedules.stream()
                    .map(UserScheduleEntity::toPostScheduleReqDto) // DTO로 변환
                    .collect(Collectors.toList());
        } else {
            // 사용자 엔티티를 찾지 못한 경우 빈 리스트 반환
            return Collections.emptyList();
        }
    } // 달력 화면 출력
}
