package firstSpringApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeBean {
	String id,name;
	@Autowired
	@Qualifier("department1")
	private DepartmentBean department;
	public EmployeBean(DepartmentBean department) {
		super();
		this.department = department;
	}
	public EmployeBean(String id, String name, DepartmentBean department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}
	public EmployeBean() {
		super();
		// TODO Auto-generated constructor stub
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
	public DepartmentBean getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentBean department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "EmployeBean [id=" + id + ", name=" + name + ", department=" + department + "]";
	}

}
