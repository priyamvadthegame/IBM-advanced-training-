package firstSpringApp;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class AcoountSpringFirstApp implements MessageSourceAware,InitializingBean,DisposableBean{
	
	private String name,id;
	private double balance;
	
	public AcoountSpringFirstApp() {
		super();
		System.out.println("Inside default constructor of AcoountSpringFirstApp");
		// TODO Auto-generated constructor stub
	}
	public AcoountSpringFirstApp(String name, String id, double balance) {
		super();
		System.out.println("Inside parameterized constructor of AcoountSpringFirstApp");
		this.name = name;
		this.id = id;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("Setter method setName of acoountSpringFirstApp called");
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		System.out.println("Setter method setId of acoountSpringFirstApp called");
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		System.out.println("Setter method setBalance of acoountSpringFirstApp called");
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AcoountSpringFirstApp [name=" + name + ", id=" + id + ", balance=" + balance + "]";
	}
	public void setMessageSource(MessageSource messageSource) {
		// TODO Auto-generated method stub
		System.out.println(messageSource);
	}
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AfterProperty Set is called");
	}
	public void initMethod()
	{
		System.out.println("InitMethod is called");
	}
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy method of disposableBean interface is called");
	}
	public void onDestroy()
	{
		System.out.println("Ondestroy method of destroy-method attribute is caled is called");
	}
	

}
