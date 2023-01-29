package com.deke.testredisdbjpa.test;

import com.deke.testredisdbjpa.dto.request.MailDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImp {

    private final JavaMailSender mailSender;

    public EmailServiceImp(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(MailDto mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mertanildk@gmail.com");
        message.setTo(mailDto.getMail());
        message.setSubject(mailDto.getSubject());
        message.setText(mailDto.getText());
        mailSender.send(message);
    }





}