package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface UserService {
	/**
	 * ����û�
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * ������֤
	 * @param email
	 * @return ��������򷵻�true,�������򷵻�false
	 */
	public boolean checkEmail(String email);
	public boolean checkPhone(String phone);
	public boolean checkUsername(String username);
	/**
	 * ��¼��֤
	 * @param username
	 * @param password
	 * @return ��¼�ɹ�,����user����,��¼ʧ���׳��쳣:1.�˺Ų�����,2.�������
	 */
	public User login(String username,String password);
	/**
	 * �޸�����
	 * @param id
	 * @param oldPwd
	 * @param newPwd
	 */
	public void changePassword(Integer id,String oldPwd,String newPwd);
	/**
	 * �޸��û���Ϣ
	 * @param id
	 * @param username
	 * @param email
	 * @param phone
	 * @param gender
	 */
	public void updataUser(Integer id,String username,String email,String phone,Integer gender);
	/**
	 * ����id��ѯ�û�
	 * @param id
	 * @return ��ѯ�����User���󷵻�
	 */
	public User getUserById(Integer id);
	public void changeImage(String image,Integer id);
}
