package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	
	@Test
	void helloBeanSetter() {
		//1. Spring Container 객체생성
		ApplicationContext context = new GenericXmlApplicationContext("");
	}

}
