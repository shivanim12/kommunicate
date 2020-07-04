package com.kommunicate.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;


public class EmailUtils {
    public static void sendEmail(String to, String from, String subject, String[] body) {


        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(System.getenv("SMTP_USER_NAME"), System.getenv("SMTP_PASSWORD"));

            }

        });

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject(subject);

            message.setText(StringUtils.join(body, "\n"));
            Transport.send(message);
            System.out.println("Sent email message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }


}
