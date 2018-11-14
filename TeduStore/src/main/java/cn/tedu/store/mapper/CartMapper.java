package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;
public interface CartMapper {
	//加入购物车
	public void insertCart(Cart cart);
	//查询用户的购物车商品
	public List<CartVo> selectGoodsByUid(Integer uid);
	//批量删除购物车里的商品
	public void deleteByIds(Integer[] ids);
	//删除购物车里的商品
	public void deleteById(Integer id);
	//修改购物车商品数量
	public void updateNumById(@Param("id")Integer id,@Param("num")Integer num);
}
