package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictService {
	//��ѯʡ
	public List<Province> getProvince();
	//����ʡ�ݴ����ѯ��
	public List<City> getCity(String provinceCode);
	//�����д����ѯ����
	public List<Area> getArea(String cityCode);
}
