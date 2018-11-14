package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.DictService;

@Controller
@RequestMapping("/dict")
public class DictController extends BaseController{
	@Resource
	private DictService dictService;
	//��ȡʡ����Ϣ
	@RequestMapping("/getProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> getProvince(){
		ResponseResult<List<Province>> rr = new ResponseResult<List<Province>>(1,"��ѯ�ɹ�",dictService.getProvince());
		return rr; 
	}
	//����ʡ�ݴ����ȡ������Ϣ
	@RequestMapping("/getCity.do")
	@ResponseBody
	public ResponseResult<List<City>> getCity(String provinceCode){
		ResponseResult<List<City>> rr = new ResponseResult<List<City>>(1,"��ѯ�ɹ�",dictService.getCity(provinceCode));
		return rr;
	}
	//�����д����ȡ������Ϣ
	@RequestMapping("/getArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> getArea(String cityCode){
		ResponseResult<List<Area>> rr = new ResponseResult<List<Area>>(1,"��ѯ�ɹ�",dictService.getArea(cityCode));
		return rr;
 	}
}
