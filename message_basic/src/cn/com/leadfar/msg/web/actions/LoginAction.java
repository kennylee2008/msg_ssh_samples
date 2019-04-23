package cn.com.leadfar.msg.web.actions;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.msg.model.User;
import cn.com.leadfar.msg.service.UserService;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction {
	
	private String username;
	private String password;
	
	@Resource
	private UserService userService;
	
	public String execute(){
		User user = userService.login(username, password);
		if(user != null){
			ServletActionContext.getRequest().getSession().setAttribute("login", user);
		}
		return "back_index";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
