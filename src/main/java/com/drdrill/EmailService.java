package com.drdrill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String recipient, String subject, String body, String cc, String bcc) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(body);
        if (cc != null) {
            message.setCc(cc);
        }
        
        if (bcc != null) {
            message.setBcc(bcc);
        }
        javaMailSender.send(message);
    }
}
