package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
@Service
public class AddressServiceImpl implements AddressService{
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
	//��ȡʡ����������
	private String getDistrict(Address address){
		String provinceName = dictMapper.selectByProvinceCode(address.getRecvProvince());
		String cityName = dictMapper.selectByCityCode(address.getRecvCity());
		String areaName = dictMapper.selectByAreaCode(address.getRecvArea());
		return provinceName+cityName+areaName;
	}
	public void addAddress(Address address) {
		address.setRecvDistrict(this.getDistrict(address));
		Integer count = addressMapper.selectAddressByUid(address.getUid()).size();
		if(count==0){
			address.setIsDefault(1);
		}else{
			address.setIsDefault(0);
		}
		addressMapper.insertAddress(address);
	}
	//��ȡ��ǰ�û����ջ���ַ
	public List<Address> getAddress(Integer uid) {
		return addressMapper.selectAddressByUid(uid);
	}
	//����Ĭ�ϵ�ַ
	public void setDefault(Integer uid, Integer id) {
		Integer n1 = addressMapper.updateByUid(uid);
		Integer n2 = addressMapper.updateById(id);
		if(n1 == 0){
			//ssm��������,Ĭ��RuntimeException�Զ��ع�
			throw new RuntimeException("uid�޸Ĵ���");
		}
		if(n2 == 0){
			throw new RuntimeException("id�޸Ĵ���");
		}
	}
	public Address getById(Integer id) {
		return addressMapper.selectById(id);
	}
	public void updateAddress(Address address) {
		address.setRecvDistrict(this.getDistrict(address));
		addressMapper.updateAddressById(address);
	}
	public void removeAddress(Integer id) {
		addressMapper.deleteById(id);
	}
}
