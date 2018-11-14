package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

public interface UserMapper {
	/*
	 * ��������
	 */
	public void insertUser(User user);
	/*
	 * �����û�����������,�����ѯ������,�����ݷ�װΪuser���󲢷���,
	 */
	public User selectByUsername(String username);
	/*
	 * ����������֤�����Ƿ����.
	 */
	public Integer selectByEmail(String email);
	/**
	 * ���ݵ绰������֤�绰�Ƿ��Ѵ���.
	 * @param phone
	 * @return ��ѯ���������
	 */
	public Integer selectByPhone(String phone);
	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * ����id��ѯ�û���Ϣ
	 * @param id
	 * @return �����û���Ϣ,��user�����װ
	 */
	public User selectById(Integer id);
	/**
	 * ����id��ͷ���ļ���·����ŵ����ݿ���
	 * @param image
	 * @param id
	 */
	public void updateImage(@Param("image")String image,@Param("id")Integer id);
}
