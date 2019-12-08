package student1_action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import student.StudentPO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class student_check extends ActionSupport {
	private String password;
	private HttpServletRequest request;
	private String message="input";
	private Map<String,Object> application=ActionContext.getContext().getApplication();

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		request=ServletActionContext.getRequest();
		String number=(String) application.get("number");
		UserDao user=new UserDao();
		String hql="from StudentPO u where u.number='"+number+"'";
		List<Object> list=user.check(hql);
		request.getSession().setAttribute("allinfo", list);
		message="success";
		return message;
	}
}
