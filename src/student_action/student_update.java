package student_action;

import java.util.Map;

import student.StudentPO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class student_update extends ActionSupport {
	private int age;
	private String name,password,sex,department,phone;
	
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
		if(this.getName().equals("")||this.getSex().equals("")||this.getAge()==0||this.getPassword().equals("")||this.getPhone().equals("")){
			return "error";
		}else{
			Map<String,Object> session=ActionContext.getContext().getSession();
			String select=(String) session.get("select");
			UserDao userdao=new UserDao();
			StudentPO student=new StudentPO();
			student.setName(this.getName());
			student.setPassword(this.getPassword());
			student.setAge(this.getAge());
			student.setPhone(this.getPhone());
			student.setSex(this.getSex());
			student.setDepartment(this.getDepartment());
			userdao.update_student(StudentPO.class, select, student);
			return "success";
		}
	}
}
