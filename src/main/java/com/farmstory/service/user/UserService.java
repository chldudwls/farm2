package com.farmstory.service.user;

import com.farmstory.config.SecurityConfig;
import com.farmstory.entity.user.UserAddressEntity;
import com.farmstory.entity.user.UserEntity;
import com.farmstory.entity.user.UserPointEntity;
import com.farmstory.entity.user.UserScheduleEntity;
import com.farmstory.repository.user.UserAddressRepository;
import com.farmstory.repository.user.UserPointRepository;
import com.farmstory.repository.user.UserRepository;
import com.farmstory.repository.user.UserScheduleRepository;
import com.farmstory.requestdto.user.DeleteUserRespDto;
import com.farmstory.requestdto.user.PutUserReqDto;
import com.farmstory.requestdto.user.SignupUserAddressDto;
import com.farmstory.requestdto.user.SignupUserDto;
import com.farmstory.responsedto.user.GetUserAllInfoDto;
import com.farmstory.responsedto.user.GetUsersRespDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserScheduleRepository userScheduleRepository;
    private final UserPointRepository userPointRepository;
    private final EmailService emailService;
    private final SecurityConfig securityConfig;

    public String deleteUser(DeleteUserRespDto request) {
        request.getUserIdx().forEach(v->{
            userRepository.delete(UserEntity.builder().userIdx(Long.parseLong(v)).build());
        });

        return "SU";
    }


    @Transactional
    public void insertUser(SignupUserDto user, SignupUserAddressDto address) {

        UserEntity userEntity = user.dtoToEntity(passwordEncoder);
        UserEntity newUser = userRepository.save(userEntity);
        Long userIdx =newUser.getUserIdx();
        UserAddressEntity userAddressEntity = address.toEntity(userIdx);
        userAddressRepository.save(userAddressEntity);
    }

    public Page<GetUsersRespDto> selectUsers(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<UserEntity> users = userRepository.findAll(pageable);
        List<GetUsersRespDto> dto = users.stream()
                .map(UserEntity::toDto)
                .collect(Collectors.toList());

        return new PageImpl<>(dto, pageable, users.getTotalElements());
    }

    @Transactional
    public String putUserRole(PutUserReqDto dto) {
        Optional<UserEntity> optUser = userRepository.findById(dto.getUserIdx());
        if(optUser.isPresent()) {
            int updatedRows = userRepository.updateUserRole(dto.getUserRole(), dto.getUserIdx());
            if (updatedRows > 0) {
                return "SU";
            }
            return "FAIL";
        }


        return "FAIL";
    }

    public GetUserAllInfoDto selectUser(Long userIdx) {
        Optional<UserEntity> optUser = userRepository.findById(userIdx);
        UserAddressEntity userAddressEntity = userAddressRepository.findByUserIdx(userIdx);
        UserPointEntity userPointEntity = userPointRepository.findByUserIdx(userIdx);

        GetUserAllInfoDto user = new GetUserAllInfoDto(optUser.get(), userAddressEntity, userPointEntity);

        return user;
    }

    public String checkId(String userId) {
        Optional<UserEntity> optUser = userRepository.findByUserId(userId);

        if(optUser.isPresent()) {
            return "DBI";
        }
        return "SU";
    }
    public String checkNick(String userNick) {
        Optional<UserEntity> optNick = userRepository.findByUserNick(userNick);
        if(optNick.isPresent()) {
            return "DBN";
        }
        return "SU";
    }
    public String sendEmail(String userEmail) {
        Optional<UserEntity> optUser = userRepository.findByUserEmail(userEmail);
        if(optUser.isPresent()) {
            return "SU";
        }

        String code = emailService.randomCode();
        emailService.sendEmail(userEmail,"회원가입 인증 이메일발송", code);
        return code;
    }
    public String findIdEmail(String userName, String userEmail) {
        Optional<UserEntity> optUser = userRepository.findByUserNameAndUserEmail(userName, userEmail);
        if(optUser.isPresent()) {
            String code = emailService.randomCode();
            emailService.sendEmail(userEmail,"팜스토리 아이디 찾기 인증 코드입니다", code);
            log.info(code);
            return code;
        }
        return "false";
    }
    public String findPassEmail(String userId, String userEmail ) {
        Optional<UserEntity> optUser = userRepository.findByUserIdAndUserEmail(userId, userEmail);
        if(optUser.isPresent()) {
            String code = emailService.randomCode();
            emailService.sendEmail(userEmail,"팜스토리 비밀번호 변경 인증 코드입니다", code);
            log.info(code);
            return code;

        }
        return "false";
    }

    public String checkPwd(String pwd){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        UserEntity userEntity = userRepository.findByUserId(userName)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if(securityConfig.passwordEncoder().matches(pwd, userEntity.getUserPwd())){
            return "SU";
        }
        return "FA";
    }



}
