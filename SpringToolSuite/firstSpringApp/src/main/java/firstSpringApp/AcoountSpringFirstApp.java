package firstSpringApp;

public class AcoountSpringFirstApp {
	
	private String name,id;
	private double balance;
	
	public AcoountSpringFirstApp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AcoountSpringFirstApp(String name, String id, double balance) {
		super();
		this.name = name;
		this.id = id;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AcoountSpringFirstApp [name=" + name + ", id=" + id + ", balance=" + balance + "]";
	}
	

}
