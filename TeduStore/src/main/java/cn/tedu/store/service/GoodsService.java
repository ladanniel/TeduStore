package cn.tedu.store.service;

import java.util.List;
import cn.tedu.store.bean.Goods;

public interface GoodsService {
	public List<Goods> getByCategoryId(Integer categoryId,Integer offset,Integer count);
	public Integer getCount(Integer categoryId);
	public Goods getGoods(String id);
}
