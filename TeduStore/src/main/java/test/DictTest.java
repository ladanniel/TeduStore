package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;

public class DictTest {
	@Test
	//≤‚ ‘≤È—Ø °∑›
	public void testProvince(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper dict = aac.getBean("dictMapper", DictMapper.class);
		List<Province> list = dict.selectProvince();
		for(Province p : list){
			System.out.println(p);
		}
		aac.close();
	}
	@Test
	public void testCity(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper dict = aac.getBean("dictMapper", DictMapper.class);
		List<City> list = dict.selectCity("520000");
		for(City c : list){
			System.out.println(c);
		}
		aac.close();
	}
	@Test
	public void testArea(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper dict = aac.getBean("dictMapper", DictMapper.class);
		List<Area> list = dict.selectArea("520100");
		for(Area a : list){
			System.out.println(a);
		}
		aac.close();
	}
	@Test
	public void testSelectByProvinceCode(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper dict = aac.getBean("dictMapper", DictMapper.class);
		System.out.println(dict.selectByProvinceCode("520000"));
		aac.close();
	}
	@Test
	public void testSelectByCityCode(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper dict = aac.getBean("dictMapper", DictMapper.class);
		System.out.println(dict.selectByCityCode("520100"));
		aac.close();
	}
	@Test
	public void testSelectByAreaCode(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper dict = aac.getBean("dictMapper", DictMapper.class);
		System.out.println(dict.selectByAreaCode("520103"));
		aac.close();
	}
}
