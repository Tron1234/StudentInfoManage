package admin_action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class admin_update_check extends ActionSupport {
	private String message="input";
	private Map<String,Object> application=ActionContext.getContext().getApplication();
	@Override
	public String execute() throws Exception {
		UserDao userdao = new UserDao();
		String number=(String) application.get("number");
		String hql = "from AdminPO a where a.number='"+number+"'";
		List<Object> list = userdao.check(hql);
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.put("allinfo", list);
		return message;
	}
}
