package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	@Value("#{config.salt}")
	private String salt;
	public void addUser(User user) {
		User user1 = userMapper.selectByUsername(user.getUsername());
		if(user1==null){
			String pwd = user.getPassword();
			user.setPassword(DigestUtils.md5Hex(pwd+salt));
			userMapper.insertUser(user);
		}else{
			throw new UsernameAlreadyExistException("用户名已经存在!");
		}
	}
	public boolean checkEmail(String email) {
		Integer result = userMapper.selectByEmail(email);
		boolean count = false;
		if(result>0){
			count = true;
		}
		return count;
	}
	public boolean checkPhone(String phone) {
		return userMapper.selectByPhone(phone)>0;
	}
	public boolean checkUsername(String username) {
		return userMapper.selectByUsername(username)!=null;
	}
	public User login(String username, String password) {
		System.out.println("登录方法。。。。。");
		User user = userMapper.selectByUsername(username);
		if(user==null){
			throw new UserNotFoundException("账号不存在");
		}else{
			String md5 = DigestUtils.md5Hex(password+salt);
			if(user.getPassword().equals(md5)){
				return user;
			}else{
				throw new PasswordNotMatchException("密码错误");
			}
		}
	}
	public void changePassword(Integer id, String oldPwd, String newPwd) {
		User user = userMapper.selectById(id);
		if(user!=null){
			//旧密码加盐后加密验证
			String md5 = DigestUtils.md5Hex(oldPwd+salt);
			if(user.getPassword().equals(md5)){
				User u = new User();
				u.setId(id);
				//新密码加密后保存到数据库
				u.setPassword(DigestUtils.md5Hex(newPwd+salt));
				userMapper.updateUser(u);
			}else{
				throw new PasswordNotMatchException("原密码不匹配");
			}
		}else{
			throw new UserNotFoundException("账户不存在");
		}
	}
	public void updataUser(Integer id, String username, String email, String phone, Integer gender) {
		User user = userMapper.selectById(id);
		//用户存在
		if(user!=null){
			//检查用户名是否重复
			User user1 = userMapper.selectByUsername(username);
			/*
			 * 如果user1不为空,说明欲修改的用户名在数据库中已经存在,不能使用,抛异常,
			 * 但是需要去掉一种特例.就是欲修改的用户名与登录的用户名一致.这种情况可以修改
			 */
			if(user1!=null&&!user.getUsername().equals(username)){
				throw new UsernameAlreadyExistException("用户名已存在");
			}else{
				User user2 = new User();
				user2.setId(id);
				user2.setUsername(username);
				user2.setEmail(email);
				user2.setPhone(phone);
				user2.setGender(gender);
				userMapper.updateUser(user2);
			}
		}else{
			//用户不存在
			throw new UserNotFoundException("用户不存在");
		}
	}
	public User getUserById(Integer id) {
		return userMapper.selectById(id);
	}
	public void changeImage(String image, Integer id) {
		userMapper.updateImage(image, id);
	}
}
