package cn.com.leadfar.msg.web.actions;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.msg.service.InitService;

@Controller("initAction")
@Scope("prototype")
public class InitAction {
	
	@Resource
	private InitService initService;
	
	public String execute(){
		initService.addInitDatas();
		return "init_success";
	}
}
