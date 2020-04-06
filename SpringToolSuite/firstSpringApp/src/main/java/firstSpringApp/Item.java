package firstSpringApp;

public class Item {
	private String name;
	private double price;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Items [name=" + name + ", price=" + price + "]";
	}
	
}
