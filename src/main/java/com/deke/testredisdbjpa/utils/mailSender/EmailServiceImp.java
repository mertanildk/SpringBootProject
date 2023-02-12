package com.deke.testredisdbjpa.utils.mailSender;

import com.deke.testredisdbjpa.entity.dto.request.MailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailServiceImp implements MailSenderService {

    private final JavaMailSender mailSender;

    public boolean sendEmail(MailDto mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mertanildk@gmail.com");
        message.setTo(mailDto.getMail());
        message.setSubject(mailDto.getSubject());
        message.setText(mailDto.getText());
        mailSender.send(message);
        return true;
    }





}