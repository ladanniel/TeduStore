package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	public List<Goods> selectByCategoryId(@Param("categoryId") Integer categoryId,
			@Param("offset") Integer offset,@Param("count") Integer count);
	public Integer selectCount(Integer categoryId);
	public Goods selectById(String id);

}
