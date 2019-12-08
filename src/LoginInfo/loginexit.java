package LoginInfo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class loginexit extends ActionSupport {

	@Override
	public String execute() throws Exception {
		Map<String,Object> application=ActionContext.getContext().getApplication();
		application.clear();//清空application中的数据
		return "success";
	}
}
