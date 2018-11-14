package test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.UserService;

public class TestUser {
	@Test
	public void insertUser(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um = aac.getBean("userMapper",UserMapper.class);
		User user = new User();
		user.setUsername("wudou66");
		user.setPassword("123456");
		user.setEmail("2696961144@qq.com");
		user.setPhone("11111111111");
		user.setGender(0);
		user.setImage("dasdjj145");
		user.setCreatedUser("wudou");
		Date date = new Date();
		user.setCreatedTime(date);
		um.insertUser(user);
		aac.close();
	}
	@Test
	public void testSelectByUsername(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um = aac.getBean("userMapper",UserMapper.class);
		User user = um.selectByUsername("add");
		System.out.println(user);
		aac.close();
	}
	@Test
	public void testAddUser(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		UserService us = aac.getBean("userServiceImpl",UserService.class);
		User user = new User();
		user.setUsername("app");
		user.setPassword("1478214");
		user.setEmail("261474@qq.com");
		user.setPhone("1354791214");
		user.setImage("ser.daojsd");
		user.setGender(1);
		user.setCreatedUser("wudou");
		Date date = new Date();
		user.setCreatedTime(date);
		us.addUser(user);
		aac.close();
	}
	@Test
	public void testEmail(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper mp = aac.getBean("userMapper",UserMapper.class);
		Integer email = mp.selectByEmail("2614747@qq.com");
		System.out.println(email);
		aac.close();
	}
	@Test
	public void testPhone(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper mp = aac.getBean("userMapper",UserMapper.class);
		Integer phone = mp.selectByPhone("1354791214");
		System.out.println(phone);
		aac.close();
	}
	@Test
	public void testCheckEmail(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		UserService us = aac.getBean("userServiceImpl",UserService.class);
		boolean result = us.checkEmail("26147489@qq.com");
		System.out.println(result);
		aac.close();
	}
	@Test
	public void testCheckPhone(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		UserService us = aac.getBean("userServiceImpl",UserService.class);
		boolean result = us.checkPhone("135479124");
		System.out.println(result);
		aac.close();
	}
	@Test
	public void testCheckUsername(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		UserService us = aac.getBean("userServiceImpl",UserService.class);
		System.out.println(us.checkUsername("ap"));
		aac.close();
	}
	@Test
	public void testLogin(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		UserService us = aac.getBean("userServiceImpl",UserService.class);
		User user = us.login("admin", "1234567");
		System.out.println(user);
		aac.close();
	}
	@Test
	public void testUpdateUser(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um = aac.getBean("userMapper", UserMapper.class);
		User user = new User();
		user.setId(8);
		user.setUsername("www");
		user.setGender(1);
		user.setEmail("77777@tedu.cn");
		user.setPhone("147852369");
		user.setModifiedUser("wudou");
		Date date = new Date();
		user.setModifiedTime(date);
		um.updateUser(user);
		aac.close();
	}
	@Test
	public void testSelectUserById(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um = aac.getBean("userMapper", UserMapper.class);
		User user = um.selectById(10);
		System.out.println(user);
		aac.close();
	}
	@Test
	public void testChangePassword(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		UserService us = aac.getBean("userServiceImpl",UserService.class);
		us.changePassword(13, "1478214", "5201314");
		aac.close();
	}
	@Test
	public void tesUpdateUser(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		UserService us = aac.getBean("userServiceImpl",UserService.class);
		us.updataUser(6, "app", "2696961144@tedu.cn", "12345678901", 1);
		aac.close();
	}
	@Test
	public void testUpdateImage(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um = aac.getBean("userMapper", UserMapper.class);
		um.updateImage("ddddddddd", 6);
		aac.close();
	}
}
