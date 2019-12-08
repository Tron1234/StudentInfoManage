package student_action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class student_check_select extends ActionSupport {
	private String message = "input";
	private String select;
	
	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	@Override
	public String execute() throws Exception {
		UserDao userdao = new UserDao();
		String hql = "from StudentPO s where s.number='"+getSelect()+"'";
		List<Object> list = userdao.check(hql);
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.put("allinfo", list);
		session.put("select",getSelect());
		UserDao userdao1 = new UserDao();
		String hql1 = "from DepartmentPO";
		List<Object> list1 = userdao1.check(hql1);
		session.put("allinfo1",list1);
		return message;
	}
}
