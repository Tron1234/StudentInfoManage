package student;

import department.DepartmentPO;

public class StudentPO {
	private int age;
	private String name,password,sex,department,phone,number;
	private DepartmentPO departmentPO;
	public DepartmentPO getDepartmentPO() {
		return departmentPO;
	}
	public void setDepartmentPO(DepartmentPO departmentPO) {
		this.departmentPO = departmentPO;
	}//因为对设置department设置了外键，所以必须在StudentPO中创建departmentPO对象;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number =number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
