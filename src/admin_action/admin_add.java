package admin_action;

import java.util.List;
import java.util.Map;

import student.StudentPO;

import admin.AdminPO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import department.DepartmentPO;

public class admin_add extends ActionSupport {
	private String name,password,number,passwordcheck;
	private boolean message;
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
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
	public String getPasswordcheck() {
		return passwordcheck;
	}

	public void setPasswordcheck(String passwordcheck) {
		this.passwordcheck = passwordcheck;
	}

	@Override
	public String execute() throws Exception {
		if(this.getName().equals("")||this.getPassword().equals("")||this.getNumber().equals("")){
			return "input";
		}else{
			if(find()==false){
				return "error";
			}else if(!this.getPassword().equals(this.getPasswordcheck())){
				return "error1";
			}else{
				UserDao userdao=new UserDao();
				AdminPO admin=new AdminPO();
				admin.setName(this.getName());
				admin.setNumber(this.getNumber());
				admin.setPassword(this.getPassword());
				userdao.save(admin);
				return "success";
			}
		}
	}
	public boolean find(){
		UserDao userdao=new UserDao();
		String hql="from AdminPO s where s.number='"+this.getNumber()+"'";
		List<Object> list=userdao.check(hql);
		if(list.isEmpty()){
			message=true;
		}
		return message;
	}
}
