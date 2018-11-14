package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;

public class TestGoodsCategory {
	@Test
	public void testSelectByParentId(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		GoodsCategoryMapper gc = aac.getBean("goodsCategoryMapper", GoodsCategoryMapper.class);
		System.out.println(gc.selectByParentId(903, 0, 3));
		System.out.println(gc.selectByParentId(162, null, null));
		System.out.println(gc.selectByParentId(171, null, null));
		System.out.println(gc.selectByParentId(186, null, null));
		aac.close();
	}
	@Test
	public void testSelectByCategoryId(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		GoodsMapper gm = aac.getBean("goodsMapper", GoodsMapper.class);
		System.out.println(gm.selectByCategoryId(163,0,6));
		aac.close();
	}
	@Test
	public void testSelectCount(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		GoodsMapper gm = aac.getBean("goodsMapper", GoodsMapper.class);
		System.out.println(gm.selectCount(163));
		aac.close();
	}
	@Test
	public void testSelectById(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("application-dao.xml");
		GoodsMapper gm = aac.getBean("goodsMapper", GoodsMapper.class);
		System.out.println(gm.selectById("10000010"));
	}
}
