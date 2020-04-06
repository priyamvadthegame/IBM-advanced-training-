package firstSpringApp;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		AbstractApplicationContext iocContainer=new ClassPathXmlApplicationContext("Beans_Assignment1.xml");
		Map<String,Order> orderMap=iocContainer.getBeansOfType(Order.class);
		for(String key :orderMap.keySet())
		{
			Order o=orderMap.get(key);
			sum+=o.getItem().getPrice();
		}
		System.out.println(sum);
	}

}
