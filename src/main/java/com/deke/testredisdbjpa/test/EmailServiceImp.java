package com.deke.testredisdbjpa.test;

import com.deke.testredisdbjpa.dto.request.MailDto;
import com.deke.testredisdbjpa.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
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
        //String subject = "testEmailFromSpringBootProject";
        //String text = "Spring boot ile gönderilen mesaj içeriği TEST: DİKKATE ALMAYINIZ.";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mertanildk@gmail.com");
        message.setTo(mailDto.getMail());
        message.setSubject(mailDto.getSubject());
        message.setText(mailDto.getText());
        mailSender.send(message);
    }





}


/*
 public boolean testSender() {
        String mailTo = "mertanildeke@gmail.com";
        String subject = "testEmailFromSpringBootProject";
        String text = "Spring boot ile gönderilen mesaj içeriği TEST: DİKKATE ALMAYINIZ.";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mertanildk@gmail.com");
        message.setTo(mailTo);
        message.setText(text);
        message.setSubject(subject);
        mailSender.send(message);
        return true;

    }
 */