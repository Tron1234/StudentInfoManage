package student_action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class student_check extends ActionSupport {
	private String message = "input";

	@Override
	public String execute() throws Exception {
		UserDao userdao = new UserDao();
		String hql = "from StudentPO";
		List<Object> list = userdao.check(hql);
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.put("allinfo", list);
		message = "success";
		return message;
	}
}
