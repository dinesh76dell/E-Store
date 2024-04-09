package com.ecommerce.shop.services;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    public boolean sendEmail(String subject, String message, String to) {
        boolean flage = false;
        String host = "smtp.gmail.com";
        String from = "dinesh7627000@gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dinesh7627000@gmail.com", "nqai usvr njyw xlgj");
            }
        });
        session.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(from);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject(subject);
            // mimeMessage.setText(message);
            mimeMessage.setContent(message, "text/html");
            Transport.send(mimeMessage);

            flage = true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return flage;
    }
}
