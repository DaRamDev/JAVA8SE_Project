package mylab.notification.di.annot.config;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 상위 패키지의 서비스 및 모델 클래스 import 추가
import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    public void testNotificationManager() {
        // 1. NotificationManager 레퍼런스가 Not Null 인지 검증
        assertNotNull("NotificationManager가 Null입니다.", notificationManager);

        // 2. 이메일 서비스 검증
        assertNotNull("이메일 서비스가 Null입니다.", notificationManager.getEmailService());
        
        EmailNotificationService emailService = (EmailNotificationService) notificationManager.getEmailService();
        assertEquals("smtp.gmail.com", emailService.getSmtpServer());
        assertEquals(587, emailService.getPort());

        // 3. SMS 서비스 검증
        assertNotNull("SMS 서비스가 Null입니다.", notificationManager.getSmsService());
        
        SmsNotificationService smsService = (SmsNotificationService) notificationManager.getSmsService();
        assertEquals("SKT", smsService.getProvider());

        // 4. NotificationManager의 메서드 실행
        System.out.println("=== 알림 전송 시작 ===");
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
        System.out.println("=== 알림 전송 완료 ===");
    }
}