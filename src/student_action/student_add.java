package student_action;

import java.util.List;

import student.StudentPO;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import department.DepartmentPO;

public class student_add extends ActionSupport {
	private int age;
	private String name,password,sex,department,phone,number;
	private boolean message=false;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	@Override
	public String execute() throws Exception {
		if(this.getName()==null||this.getSex()==null||this.getAge()==0||this.getNumber()==null||this.getPassword()==null||this.getPhone()==null){
			return "input";
		}else if(find()==false){
			return "error";
		}else{
			UserDao userdao=new UserDao();
			DepartmentPO departmentPO=new DepartmentPO();
			StudentPO stu=new StudentPO();
			stu.setName(this.getName());
			stu.setSex(this.getSex());
			stu.setAge(this.getAge());
			stu.setNumber(this.getNumber());
			stu.setDepartment(this.getDepartment());
			stu.setPhone(this.phone);
			stu.setPassword(this.getPassword());
			userdao.save(stu);
			return "success";
		}
	}
	public boolean find(){
		UserDao userdao=new UserDao();
		String hql="from StudentPO s where s.number='"+this.getNumber()+"'";
		List<Object> list=userdao.check(hql);
		if(list.isEmpty()){
			message=true;
		}
		return message;
	}
}
