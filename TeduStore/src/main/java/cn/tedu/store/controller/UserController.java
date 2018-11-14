package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private UserService userService;
	@RequestMapping("/showRegister.do")
	public String showRegister(){
		return "register";
	}
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){
		ResponseResult<Void> rr = null;
		boolean check = userService.checkUsername(username);
		if(check){
			rr = new ResponseResult<Void>(0,"用户名不可以使用");
		}else{
			rr = new ResponseResult<Void>(1,"用户名可以使用");
		}
		return rr;
	}
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr = null;
		boolean check = userService.checkEmail(email);
		if(check){
			rr = new ResponseResult<Void>(0,"邮箱不可以使用");
		}else{
			rr = new ResponseResult<Void>(1,"邮箱可以使用");
		}
		return rr;
	}
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr = null;
		boolean check = userService.checkPhone(phone);
		if(check){
			rr = new ResponseResult<Void>(0,"电话不可以使用");
		}else{
			rr = new ResponseResult<Void>(1,"电话可以使用");
		}
		return rr;
	}
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname") String username,@RequestParam("upwd") String password,
			String email,String phone){
		ResponseResult<Void> rr = null;
		try{
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			userService.addUser(user);
			rr = new ResponseResult<Void>(1,"用户添加成功");
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	@RequestMapping("/showLogin.do")
	public String showLogin(){
		return "login";
	}
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,String password,HttpSession session){
		ResponseResult<Void> rr = null;
		try{
			User user = userService.login(username, password);
			session.setAttribute("user", user);
			rr = new ResponseResult<Void>(1,"登录成功");
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	@RequestMapping("/exit.do")
	public String exit(HttpSession session){
		session.invalidate();
		return "redirect:../main/showIndex.do";
	}
	@RequestMapping("/showPassword.do")
	public String showPassword(){
		return "personal_password";
	}
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(HttpSession session,String oldPwd,String newPwd){
		ResponseResult<Void> rr = null;
		try{
			userService.changePassword(this.getId(session), oldPwd, newPwd);
			rr = new ResponseResult<Void>(1,"密码修改成功");
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	@RequestMapping("/showPersonpage.do")
	public String showPersonpage(){
		return "personpage";
	}
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(HttpSession session,String username,String email,String phone,Integer gender){
		ResponseResult<Void> rr = null;
		try{
			userService.updataUser(this.getId(session), username, email, phone, gender);
			rr = new ResponseResult<Void>(1,"修改成功!");
			session.setAttribute("user",userService.getUserById(this.getId(session)));
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	@RequestMapping("/getImage.do")
	@ResponseBody
	public ResponseResult<Void> getImage(MultipartFile file,HttpSession session){
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"上传成功");
		//获取应用的真实路径
		String path = session.getServletContext().getRealPath("/");
		System.out.println("真实路径："+path);
		try {
			file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//修改数据库头像文件路径
		userService.changeImage("/upload/"+file.getOriginalFilename(), this.getId(session));
		return rr;
	}
}
