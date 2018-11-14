package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import cn.tedu.store.bean.User;

public class BaseController {
	public Integer getId(HttpSession session){
		User user = (User)session.getAttribute("user");
		Integer id = null;
		if(user!=null){
			id = user.getId();
		}
		return id;
	}

}
