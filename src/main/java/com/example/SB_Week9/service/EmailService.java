package com.example.SB_Week9.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender mailSender;

    @Async
    public void sendEmail(String userEmail, String recipientEmail, String subject, String body) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(userEmail); // Gửi từ email của người dùng
            helper.setTo(recipientEmail);
            helper.setSubject(subject);
            helper.setText(body, true); // `true` cho phép định dạng HTML trong email

            mailSender.send(message);
            System.out.println("Email sent successfully from " + userEmail + " to " + recipientEmail);

        } catch (MessagingException e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}
