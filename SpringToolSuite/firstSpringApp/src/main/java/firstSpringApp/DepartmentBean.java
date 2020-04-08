package firstSpringApp;

public class DepartmentBean {
	private String id,name;

	@Override
	public String toString() {
		return "DepartmentBean [id=" + id + ", name=" + name + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentBean(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public DepartmentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
