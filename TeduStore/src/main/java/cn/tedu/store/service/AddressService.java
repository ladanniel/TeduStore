package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Address;
//@Transactional表示接口的所有实现类都实现事务
@Transactional
public interface AddressService {
	//添加收货人地址信息
	public void addAddress(Address address);
	//获取用户的收货地址
	public List<Address> getAddress(Integer uid);
	//设置默认收货地址
	public void setDefault(Integer uid,Integer id);
	//根据id查询收货人地址信息
	public Address getById(Integer id);
	//修改收货人地址信息
	public void updateAddress(Address address);
	//删除收货人信息
	public void removeAddress(Integer id);
}
