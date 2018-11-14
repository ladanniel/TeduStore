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
			throw new UsernameAlreadyExistException("�û����Ѿ�����!");
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
		System.out.println("��¼��������������");
		User user = userMapper.selectByUsername(username);
		if(user==null){
			throw new UserNotFoundException("�˺Ų�����");
		}else{
			String md5 = DigestUtils.md5Hex(password+salt);
			if(user.getPassword().equals(md5)){
				return user;
			}else{
				throw new PasswordNotMatchException("�������");
			}
		}
	}
	public void changePassword(Integer id, String oldPwd, String newPwd) {
		User user = userMapper.selectById(id);
		if(user!=null){
			//��������κ������֤
			String md5 = DigestUtils.md5Hex(oldPwd+salt);
			if(user.getPassword().equals(md5)){
				User u = new User();
				u.setId(id);
				//��������ܺ󱣴浽���ݿ�
				u.setPassword(DigestUtils.md5Hex(newPwd+salt));
				userMapper.updateUser(u);
			}else{
				throw new PasswordNotMatchException("ԭ���벻ƥ��");
			}
		}else{
			throw new UserNotFoundException("�˻�������");
		}
	}
	public void updataUser(Integer id, String username, String email, String phone, Integer gender) {
		User user = userMapper.selectById(id);
		//�û�����
		if(user!=null){
			//����û����Ƿ��ظ�
			User user1 = userMapper.selectByUsername(username);
			/*
			 * ���user1��Ϊ��,˵�����޸ĵ��û��������ݿ����Ѿ�����,����ʹ��,���쳣,
			 * ������Ҫȥ��һ������.�������޸ĵ��û������¼���û���һ��.������������޸�
			 */
			if(user1!=null&&!user.getUsername().equals(username)){
				throw new UsernameAlreadyExistException("�û����Ѵ���");
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
			//�û�������
			throw new UserNotFoundException("�û�������");
		}
	}
	public User getUserById(Integer id) {
		return userMapper.selectById(id);
	}
	public void changeImage(String image, Integer id) {
		userMapper.updateImage(image, id);
	}
}
