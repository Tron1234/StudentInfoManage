package student_action;

import student.StudentPO;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class student_delete extends ActionSupport {
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
		userdao.delete(StudentPO.class, getSelect());
		return "success";
	}
	
}
