package firstSpringApp;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class firstSpringAppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext iocContainer=new ClassPathXmlApplicationContext("Beans.xml");
		AcoountSpringFirstApp account=(AcoountSpringFirstApp)iocContainer.getBean("accountCreator");
		System.out.println(account);
	}

}
