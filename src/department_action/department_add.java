package department_action;

import java.util.List;

import student.StudentPO;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import department.DepartmentPO;

public class department_add extends ActionSupport {
	private String name,type,id;
	private boolean message=false;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String execute() throws Exception {
		if(this.getName()==null||this.getId()==null||this.getType()==null){
			return "input";
		}else if(find()==false){
			return "error";
		}else{
			UserDao userdao=new UserDao();
			DepartmentPO department=new DepartmentPO();
			department.setName(this.getName());
			department.setId(this.getId());
			department.setType(this.getType());
			userdao.save(department);
			return "success";
		}
	}
	public boolean find(){
		UserDao userdao=new UserDao();
		String hql="from DepartmentPO s where s.id='"+this.getId()+"'";
		List<Object> list=userdao.check(hql);
		if(list.isEmpty()){
			message=true;
		}
		return message;
	}
}
