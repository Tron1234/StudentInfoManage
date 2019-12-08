package student1_action;

import java.util.Map;

import student.StudentPO;

import admin.AdminPO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class student_update extends ActionSupport {
	private String phone,password;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	private Map<String,Object> application=ActionContext.getContext().getApplication();
	@Override
	public String execute() throws Exception {
		if(this.getPassword().equals("")||this.getPhone().equals("")){
			return "error";
		}else{
			UserDao userdao = new UserDao();
			Map<String,Object> session=ActionContext.getContext().getSession();
			String number=(String) application.get("number");
			StudentPO student=new StudentPO();
			student.setPhone(this.getPhone());
			student.setPassword(this.getPassword());
			userdao.update_student1(StudentPO.class, number, student);
			return "success";
		}
	}
}
