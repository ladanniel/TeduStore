package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.GoodsCategoryService;
import cn.tedu.store.service.GoodsService;
@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private GoodsCategoryService goodsCategoryService;
	@Resource
	private GoodsService goodsService;
	//显示登录页面
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map){
		List<List<GoodsCategory>> list3 = new ArrayList<List<GoodsCategory>>();
		List<GoodsCategory> list2 = goodsCategoryService.getByParentId(161, 0, 3);
		for(GoodsCategory g : list2){
			list3.add(goodsCategoryService.getByParentId(g.getId(), null, null));
		}
		map.addAttribute("list2", list2);
		map.addAttribute("list3", list3);
		//获取热卖商品
		List<Goods> goodsList = goodsService.getByCategoryId(163, 0, 3);
		map.addAttribute("goodsList", goodsList);
		return "index";
	}
}
