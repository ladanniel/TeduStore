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
	//获取省份信息
	@RequestMapping("/getProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> getProvince(){
		ResponseResult<List<Province>> rr = new ResponseResult<List<Province>>(1,"查询成功",dictService.getProvince());
		return rr; 
	}
	//根据省份代码获取城市信息
	@RequestMapping("/getCity.do")
	@ResponseBody
	public ResponseResult<List<City>> getCity(String provinceCode){
		ResponseResult<List<City>> rr = new ResponseResult<List<City>>(1,"查询成功",dictService.getCity(provinceCode));
		return rr;
	}
	//根据市代码获取县区信息
	@RequestMapping("/getArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> getArea(String cityCode){
		ResponseResult<List<Area>> rr = new ResponseResult<List<Area>>(1,"查询成功",dictService.getArea(cityCode));
		return rr;
 	}
}
