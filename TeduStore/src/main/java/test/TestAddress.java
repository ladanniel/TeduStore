package test;

import java.util.Date;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.AddressService;

public class TestAddress {
	@Test
	public void testInsertAddress(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		AddressMapper am = aac.getBean("addressMapper",AddressMapper.class);
		Address ad = new Address();
		ad.setUid(1);
		ad.setRecvName("�⾩");
		ad.setRecvProvince("ɽ��");
		ad.setRecvCity("̫ԭ");
		ad.setRecvArea("С����");
		ad.setRecvDistrict("ͨ���");
		ad.setRecvAddress("����Է");
		ad.setRecvPhone("13458763248");
		ad.setRecvTel("030021");
		ad.setRecvZip("147852");
		ad.setRecvTag("��˾");
		ad.setCreatedUser("wudou");
		Date date = new Date();
		ad.setCreatedTime(date);
		ad.setIsDefault(0);
		am.insertAddress(ad);
		aac.close();
	}
	@Test
	public void testSelectAddressByUid(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		AddressMapper am = aac.getBean("addressMapper",AddressMapper.class);
		System.out.println(am.selectAddressByUid(2));
		aac.close();
	}
	@Test
	public void testAddAddress(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		AddressService as = aac.getBean("addressServiceImpl", AddressService.class);
		Address ad = new Address();
		ad.setUid(4);
		ad.setRecvName("nans");
		ad.setRecvProvince("520000");
		ad.setRecvCity("520100");
		ad.setRecvArea("520102");
		ad.setRecvAddress("�Ӱ���·");
		ad.setRecvPhone("15625479654");
		ad.setRecvTel("030021");
		ad.setRecvZip("0085");
		ad.setRecvTag("ѧУ");
		ad.setCreatedUser("wudou");
		Date date = new Date();
		ad.setCreatedTime(date);
		as.addAddress(ad);
		aac.close();
	}
	@Test
	public void testUpdateByUid(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		AddressMapper am = aac.getBean("addressMapper",AddressMapper.class);
		System.out.println("Uid:"+am.updateByUid(1));
		System.out.println("id:"+am.updateById(5));
		aac.close();
	}
	@Test
	public void testSetDefault(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		AddressService as = aac.getBean("addressServiceImpl", AddressService.class);
		as.setDefault(1,4);
		aac.close();
	}
	@Test
	public void testSelectById(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		AddressMapper am = aac.getBean("addressMapper",AddressMapper.class);
		System.out.println(am.selectById(7));
		aac.close();
	}
	@Test
	public void testUpdateAddressById(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		AddressMapper am = aac.getBean("addressMapper",AddressMapper.class);
		Address ad = new Address();
		ad.setId(8);
		ad.setRecvName("����");
		ad.setRecvProvince("520000");
		ad.setRecvCity("520100");
		ad.setRecvArea("520102");
		ad.setRecvAddress("�Ӱ���·");
		ad.setRecvPhone("15625479654");
		ad.setRecvTel("030021");
		ad.setRecvZip("0085");
		ad.setRecvTag("ѧУ");
		ad.setRecvDistrict("�㶫ʡ������������");
		am.updateAddressById(ad);
		aac.close();
	}
	@Test
	public void testUpdateAddress(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		AddressService as = aac.getBean("addressServiceImpl", AddressService.class);
		Address ad = new Address();
		ad.setId(8);
		ad.setRecvName("ͨ��");
		ad.setRecvProvince("140000");
		ad.setRecvCity("140100");
		ad.setRecvArea("140105");
		ad.setRecvAddress("������");
		ad.setRecvPhone("15625479654");
		ad.setRecvTel("030021");
		ad.setRecvZip("0085");
		ad.setRecvTag("ѧУ");
		as.updateAddress(ad);
		aac.close();
	}
	@Test
	public void testDeleteAddress(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		AddressMapper am = aac.getBean("addressMapper",AddressMapper.class);
		am.deleteById(8);
		aac.close();
	}
}
