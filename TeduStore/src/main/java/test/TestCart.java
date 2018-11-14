package test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;

public class TestCart {
	@Test
	public void testInsertCart(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		CartMapper cm = aac.getBean("cartMapper", CartMapper.class);
		Cart cart = new Cart();
		cart.setUid(1);
		cart.setGoodsId("10000010");
		cart.setNum(1);
		cart.setCreatedUser("wudou");
		Date date = new Date();
		cart.setCreatedTime(date);
		cm.insertCart(cart);
		aac.close();
	}
	@Test
	public void testSelectGoodsByUid(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		CartMapper cm = aac.getBean("cartMapper", CartMapper.class);
		System.out.println(cm.selectGoodsByUid(3));
		aac.close();
	}
	@Test
	public void testDeleteByIds(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		CartMapper cm = aac.getBean("cartMapper", CartMapper.class);
		Integer[] ids = new Integer[]{2,3,4};
		cm.deleteByIds(ids);
		aac.close();
	}
	@Test
	public void testDeleteById(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		CartMapper cm = aac.getBean("cartMapper", CartMapper.class);
		cm.deleteById(9);
		aac.close();
	}
	@Test
	public void testUpdateNumById(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		CartMapper cm = aac.getBean("cartMapper", CartMapper.class);
		cm.updateNumById(15,9);
		aac.close();
	}
}
