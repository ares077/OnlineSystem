package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.InAdminMatchedDAO;

public class Test11 {
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ac.getBean("adminMatchedDAO",InAdminMatchedDAO.class));
	}
}
