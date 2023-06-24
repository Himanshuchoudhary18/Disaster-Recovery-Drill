package com.drdrill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public void sendEmail() {
        // Perform any necessary processing or validation
        
        // Trigger email sending
        String recipient = "recipient@example.com";
        String subject = "Email Subject";
        String body = "Email Body";
        emailService.sendEmail(recipient, subject, body);
    }
}
