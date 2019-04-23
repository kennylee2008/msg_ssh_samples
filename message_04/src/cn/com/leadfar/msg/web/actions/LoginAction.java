package cn.com.leadfar.msg.web.actions;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.msg.model.User;
import cn.com.leadfar.msg.service.UserService;

import com.opensymphony.xwork2.ActionContext;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction {
	
	private String username;
	private String password;
	
	@Resource
	private UserService userService;
	
	public String execute(){
		
		try {
			User u = userService.validateUser(username, password);
			ActionContext.getContext().getSession().put("login", u);
		} catch (RuntimeException e) {
			ActionContext.getContext().put("exception", e);
			return "login";
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
