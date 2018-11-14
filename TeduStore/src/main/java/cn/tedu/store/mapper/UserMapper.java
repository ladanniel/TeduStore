package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

public interface UserMapper {
	/*
	 * 插入数据
	 */
	public void insertUser(User user);
	/*
	 * 根据用户名查找数据,如果查询到数据,则将数据封装为user对象并返回,
	 */
	public User selectByUsername(String username);
	/*
	 * 根据邮箱验证邮箱是否存在.
	 */
	public Integer selectByEmail(String email);
	/**
	 * 根据电话号码验证电话是否已存在.
	 * @param phone
	 * @return 查询结果的条数
	 */
	public Integer selectByPhone(String phone);
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return 返回用户信息,以user对象封装
	 */
	public User selectById(Integer id);
	/**
	 * 根据id将头像文件的路径存放到数据库中
	 * @param image
	 * @param id
	 */
	public void updateImage(@Param("image")String image,@Param("id")Integer id);
}
