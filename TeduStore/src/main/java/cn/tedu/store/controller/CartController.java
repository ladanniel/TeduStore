package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.CartService;
import cn.tedu.store.vo.CartVo;
@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Resource
	private CartService cartService;
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(HttpSession session,String goodsId,Integer num){
		Cart cart = new Cart();
		cart.setUid(this.getId(session));
		cart.setGoodsId(goodsId);
		cart.setNum(num);
		cartService.addCart(cart);
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"添加购物车成功！");
		return rr;
	}
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,ModelMap map){
		List<CartVo> list = cartService.getGoodsByUid(this.getId(session));
		map.addAttribute("list", list);
		return "cart";
	}
	//批量删除商品
	@RequestMapping("/removeGoods.do")
	public String removeGoods(Integer[] ids){
		cartService.removeByIds(ids);
		return "redirect:../cart/showCart.do";
	}
	//单条商品删除
	@RequestMapping("/removeById.do")
	public String removeById(Integer id){
		cartService.removeById(id);
		return "redirect:../cart/showCart.do";
	}
	//修改购物车商品数量
	@RequestMapping("/changeNumById.do")
	@ResponseBody
	public ResponseResult<Void> changeNumById(Integer id,Integer num){
		cartService.changeNumById(id, num);
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"修改成功！");
		return rr;
	}
}
