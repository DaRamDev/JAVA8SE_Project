package test.java.mylab.user.di.annot;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.java.mylab.user.di.annot.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
// 경로에 main/resources/ 를 붙여서 실제 위치를 지정합니다.
@ContextConfiguration(locations = "classpath:main/resources/mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserServiceDI() {
        assertNotNull("UserService가 주입되지 않았습니다.", userService);
        assertNotNull("UserRepository가 주입되지 않았습니다.", userService.getUserRepository());
        assertEquals("DB 타입이 MySQL이 아닙니다.", "MySQL", userService.getUserRepository().getDbType());
        assertNotNull("SecurityService가 주입되지 않았습니다.", userService.getSecurityService());

        boolean isRegistered = userService.registerUser("user01", "테스터", "password123");
        assertTrue("비밀번호가 있으므로 가입이 성공해야 합니다.", isRegistered);

        boolean isFailed = userService.registerUser("user02", "테스터2", null);
        assertFalse("비밀번호가 없으므로 가입이 실패해야 합니다.", isFailed);
    }
}