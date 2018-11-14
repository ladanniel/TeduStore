package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {
	//传参查询时,最多不能超过两个参数,超过两个参数则需要用@Param做映射
	public List<GoodsCategory> selectByParentId(@Param("parentId") Integer parentId,
			@Param("offset") Integer offset,@Param("count") Integer count);
}
