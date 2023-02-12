package com.deke.testredisdbjpa.entity.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MailDto {
    String text;
    String mail;
    String subject;
}
