package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xzc.mybatis.entities.Cust;
import com.xzc.mybatis.service.CustService;

public class RedisCacheTest {
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-context.xml");
	
	@Test
	public void test(){
		CustService custService = ioc.getBean(CustService.class);
		Cust cust = custService.getCustById(1);
		System.out.println(cust);
		System.out.println("-------------------------------");
		cust = custService.getCustById(1);
		System.out.println(cust);
		
	}
}
