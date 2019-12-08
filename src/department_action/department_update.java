package department_action;

import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import department.DepartmentPO;

public class department_update extends ActionSupport {
	private String name,type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String execute() throws Exception {
		if(this.getName().equals("")||this.getType().equals("")){
			return "error";
		}else{
			Map<String,Object> session=ActionContext.getContext().getSession();
			String select=(String) session.get("select");
			UserDao userdao=new UserDao();
			DepartmentPO department=new DepartmentPO();
			department.setName(this.getName());
			department.setType(this.getType());
			userdao.update_department(DepartmentPO.class, select, department);
			return "success";
		}
	}
}
