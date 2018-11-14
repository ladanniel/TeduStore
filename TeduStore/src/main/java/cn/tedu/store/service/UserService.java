package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface UserService {
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * 邮箱验证
	 * @param email
	 * @return 如果存在则返回true,不存在则返回false
	 */
	public boolean checkEmail(String email);
	public boolean checkPhone(String phone);
	public boolean checkUsername(String username);
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return 登录成功,返回user对象,登录失败抛出异常:1.账号不存在,2.密码错误
	 */
	public User login(String username,String password);
	/**
	 * 修改密码
	 * @param id
	 * @param oldPwd
	 * @param newPwd
	 */
	public void changePassword(Integer id,String oldPwd,String newPwd);
	/**
	 * 修改用户信息
	 * @param id
	 * @param username
	 * @param email
	 * @param phone
	 * @param gender
	 */
	public void updataUser(Integer id,String username,String email,String phone,Integer gender);
	/**
	 * 根据id查询用户
	 * @param id
	 * @return 查询结果以User对象返回
	 */
	public User getUserById(Integer id);
	public void changeImage(String image,Integer id);
}
