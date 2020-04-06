package firstSpringApp;

public class Order {
	private String id;
	private Item item;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, Item item) {
		super();
		this.id = id;
		this.item = item;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", item=" + item + "]";
	}
	
}
