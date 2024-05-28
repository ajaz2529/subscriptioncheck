package com.subscriptioncheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(to);
        sm.setSubject(subject);
        sm.setText(text);
        emailSender.send(sm);
    }

}