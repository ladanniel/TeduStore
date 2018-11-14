package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Address;
//@Transactional��ʾ�ӿڵ�����ʵ���඼ʵ������
@Transactional
public interface AddressService {
	//����ջ��˵�ַ��Ϣ
	public void addAddress(Address address);
	//��ȡ�û����ջ���ַ
	public List<Address> getAddress(Integer uid);
	//����Ĭ���ջ���ַ
	public void setDefault(Integer uid,Integer id);
	//����id��ѯ�ջ��˵�ַ��Ϣ
	public Address getById(Integer id);
	//�޸��ջ��˵�ַ��Ϣ
	public void updateAddress(Address address);
	//ɾ���ջ�����Ϣ
	public void removeAddress(Integer id);
}
