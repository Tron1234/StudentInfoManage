package admin_action;

import java.util.Map;

import student.StudentPO;

import admin.AdminPO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class admin_update extends ActionSupport {
	private String name,password;

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
	private Map<String,Object> application=ActionContext.getContext().getApplication();
	@Override
	public String execute() throws Exception {
		if(this.getName().equals("")||this.getPassword().equals("")){
			return "error";
		}else{
			UserDao userdao = new UserDao();
			Map<String,Object> session=ActionContext.getContext().getSession();
			String number=(String) application.get("number");
			AdminPO admin=new AdminPO();
			admin.setName(this.getName());
			admin.setPassword(this.getPassword());
			userdao.update_admin(AdminPO.class, number, admin);
			return "success";
		}
	}
}
