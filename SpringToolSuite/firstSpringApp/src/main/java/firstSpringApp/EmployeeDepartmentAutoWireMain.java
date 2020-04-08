package firstSpringApp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeDepartmentAutoWireMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext iocContainer=new ClassPathXmlApplicationContext("Bean_Assignment4.xml");
		EmployeBean employee=(EmployeBean)iocContainer.getBean("EmployeeCreator");
		System.out.println(employee);
	}

}
