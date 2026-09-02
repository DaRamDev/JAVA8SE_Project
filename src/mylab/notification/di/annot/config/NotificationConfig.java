package mylab.notification.di.annot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.java.mylab.notification.di.annot.EmailNotificationService;
import main.java.mylab.notification.di.annot.SmsNotificationService;
import main.java.mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.*;
@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotificationService emailNotificationService() {
        // "smtp.gmail.com"과 587을 주입하여 객체 생성
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    @Bean
    public SmsNotificationService smsNotificationService() {
        // "SKT"를 주입하여 객체 생성
        return new SmsNotificationService("SKT");
    }

    @Bean
    public NotificationManager notificationManager() {
        // 위에서 만든 빈(메서드)을 호출하여 NotificationManager에 주입
        return new NotificationManager(emailNotificationService(), smsNotificationService());
    }
}