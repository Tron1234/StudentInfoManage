package LoginInfo;

import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import student.StudentPO;

import admin.AdminPO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class loginAction extends ActionSupport {
	private String password,number,name;
	private String message = "input";
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String zs;
	
	public String getZs() {
		return zs;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	Map<String,Object> application=ActionContext.getContext().getApplication();
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String main() throws Exception{
		UserDao userdao = new UserDao();
		String zx=(String) session.getAttribute("ui");//在此进行值得获取
		if (getNumber()!=null&&!"".equals(getNumber())&&getPassword()!=null&&!"".equals(getPassword())) {
			if ("学生".equals(zx)) {
				String hql = "from StudentPO";
				List<Object> list = userdao.check(hql);
				StudentPO studentpo = new StudentPO();
				for (int i = 0; i < list.size(); i++) {
					studentpo = (StudentPO) list.get(i);
					if (this.getNumber().equals(studentpo.getNumber())
							&& this.getPassword().equals(
									studentpo.getPassword())) {
						application.put("number", this.getNumber());//application中存登录人员的信息，便于在后面所有页面中可以显示
						application.put("name", studentpo.getName());
						application.put("type", "学生");
						message = "success_student";
					}else{
						message = "error";
					}
					break;
				}
			}else if ("教师".equals(zx)) {
				String hql = "from AdminPO";
				List<Object> list = userdao.check(hql);
				AdminPO adminpo = new AdminPO();
				for (int i = 0; i < list.size(); i++) {
					adminpo = (AdminPO) list.get(i);
					if (this.getNumber().equals(adminpo.getNumber())
							&& this.getPassword().equals(adminpo.getPassword())) {
						application.put("number", this.getNumber());
						application.put("name", adminpo.getName());
						application.put("type", "教师");
						message = "success_admin";
					}else{
						message = "error";
					}
					break;
				}
			} else{
				message = "error1";
			}
		} else {
			message = "input";
		}
		session.invalidate();
		return message;
	}
	
	public void type() throws Exception {
		zs=request.getParameter("type").trim();//获取登录页面选中人员信息的值
		session.setAttribute("ui", zs);//并传入session
	}
}
