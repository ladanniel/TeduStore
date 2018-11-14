package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	//查询省份
	public List<Province> selectProvince();
	//根据省份代码查询市
	public List<City> selectCity(String provinceCode);
	//根据市代码查询区县
	public List<Area> selectArea(String cityCode);
	//根据省代码查询省的名称
	public String selectByProvinceCode(String provinceCode);
	//根据市代码查询市名
	public String selectByCityCode(String cityCode);
	//根据区县代码查询区县名
	public String selectByAreaCode(String areaCode);
}
