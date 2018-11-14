package cn.tedu.store.service;

import java.util.List;
import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface CartService {
	public void addCart(Cart cart);
	public List<CartVo> getGoodsByUid(Integer uid);
	public void removeByIds(Integer[] ids);
	public void removeById(Integer id);
	public void changeNumById(Integer id,Integer num);
}
