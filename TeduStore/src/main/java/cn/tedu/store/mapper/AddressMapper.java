package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	public void insertAddress(Address address);
	public List<Address> selectAddressByUid(Integer uid);
	public Integer updateByUid(Integer uid);
	public Integer updateById(Integer id);
	public Address selectById(Integer id);
	public void updateAddressById(Address address);
	public void deleteById(Integer id);
}
