package com.farmstory.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.concurrent.ThreadLocalRandom;

@Log4j2
@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;  // ThreadLocal을 제거하고 주입 받음

    @Async
    public void sendEmail(String to, String subject, String randomCode) {
        String text = "인증 코드는 :" + randomCode + "입니다. 코드를 입력하여 인증을 완료 해주세요";
        log.info("전송된 이메일: {}, 제목: {}, 인증 코드: {}", to, subject, text);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);  // 주입된 mailSender 사용
    }

    public String randomCode() {
        int randomCode = ThreadLocalRandom.current().nextInt(100000, 1000000);
        return String.valueOf(randomCode);
    }
}
