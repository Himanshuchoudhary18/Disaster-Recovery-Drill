import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static void sendEmail(String recipient, String subject, String body) {
        // SMTP server configuration (change these values according to your email provider)
        final String smtpHost = "your_smtp_host";
        final String username = "your_username";
        final String password = "your_password";
        final int smtpPort = 587;

        // Sender's email address
        final String senderEmail = "your_sender_email@example.com";

        // Create properties for the SMTP session
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(body);

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.out.println("Failed to send email. Error message: " + e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        String recipient = "recipient@example.com";
//        String subject = "Test Email";
//        String body = "This is a test email.";
//
//        sendEmail(recipient, subject, body);
//    }
}
