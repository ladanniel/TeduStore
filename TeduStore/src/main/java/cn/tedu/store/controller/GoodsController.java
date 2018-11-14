package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.GoodsService;
@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private GoodsService goodsService;
	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId,Integer page,ModelMap map){
		if(page==null){
			page=1;
		}
		Integer offset = (page-1)*12;
		List<Goods> list = goodsService.getByCategoryId(categoryId,offset,12);
		map.addAttribute("list", list);
		Integer count = goodsService.getCount(categoryId);
		Integer pageSize = count%12 ==0 ? count/12:count/12+1;
		//把商品数量绑定到map中
		map.addAttribute("count", count);
		//把商品页数绑定到map中
		map.addAttribute("pageSize", pageSize);
		//把categoryId添加到map中
		map.addAttribute("categoryId", categoryId);
		//把当前页添加到map
		map.addAttribute("curpage", page);
		return "search";
	}
	//显示商品详情页面
	@RequestMapping("/showProductDetails.do")
	public String showGoods(String id,ModelMap map){
		Goods goods = goodsService.getGoods(id);
		map.addAttribute("goods", goods);
		return "product_details";	
	}
}
