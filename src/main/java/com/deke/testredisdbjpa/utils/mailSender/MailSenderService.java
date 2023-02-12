package com.deke.testredisdbjpa.utils.mailSender;

import com.deke.testredisdbjpa.entity.dto.request.MailDto;

public interface MailSenderService {

    boolean sendEmail(MailDto mailDto);
}
