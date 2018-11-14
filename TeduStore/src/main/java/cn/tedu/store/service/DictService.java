package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictService {
	//查询省
	public List<Province> getProvince();
	//根据省份代码查询市
	public List<City> getCity(String provinceCode);
	//根据市代码查询县区
	public List<Area> getArea(String cityCode);
}
