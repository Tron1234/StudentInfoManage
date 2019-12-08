package department_action;



import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import department.DepartmentPO;

public class department_delete extends ActionSupport {
	private UserDao userdao=new UserDao();
	private String select;
	


	public String getSelect() {
		return select;
	}



	public void setSelect(String select) {
		this.select = select;
	}



	@Override
	public String execute() throws Exception {
		userdao.delete(DepartmentPO.class, select);
		return "success";
	}
}
