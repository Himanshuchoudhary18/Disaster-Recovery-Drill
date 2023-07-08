package com.drdrill;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class DrdrillApplication {
  private final EmailService emailService;

  public DrdrillApplication(EmailService emailService) {
    this.emailService = emailService;
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(DrdrillApplication.class, args);
    DrdrillApplication application = context.getBean(DrdrillApplication.class);
    application.run();
  }

  public void run() {
    // Perform the Selenium login process here
  
    // Once login is successful, send the email
    String recipientEmail = "owner@division.com";
    String subject = "Server Maintenance Notification";
    String content = "The server will undergo maintenance and will be unavailable for 1 hour.";
    emailService.sendEmail(recipientEmail, subject, content, null, null);
  }
  @Scheduled(cron = "0 0 0 * * ?") // Run at midnight
  public void scheduledProcess() {
	  run();
  }
}
