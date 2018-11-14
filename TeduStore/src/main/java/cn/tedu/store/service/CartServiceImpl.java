package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.vo.CartVo;
@Service
public class CartServiceImpl implements CartService{
	@Resource
	private CartMapper cartMapper;
	public void addCart(Cart cart) {
		cartMapper.insertCart(cart);
	}
	public List<CartVo> getGoodsByUid(Integer uid) {
		return cartMapper.selectGoodsByUid(uid);
	}
	public void removeByIds(Integer[] ids) {
		cartMapper.deleteByIds(ids);
	}
	public void removeById(Integer id) {
		cartMapper.deleteById(id);	
	}
	public void changeNumById(Integer id, Integer num) {
		cartMapper.updateNumById(id, num);
	}
}
