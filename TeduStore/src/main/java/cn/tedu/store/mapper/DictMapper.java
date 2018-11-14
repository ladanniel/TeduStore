package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	//��ѯʡ��
	public List<Province> selectProvince();
	//����ʡ�ݴ����ѯ��
	public List<City> selectCity(String provinceCode);
	//�����д����ѯ����
	public List<Area> selectArea(String cityCode);
	//����ʡ�����ѯʡ������
	public String selectByProvinceCode(String provinceCode);
	//�����д����ѯ����
	public String selectByCityCode(String cityCode);
	//�������ش����ѯ������
	public String selectByAreaCode(String areaCode);
}
