package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	@Resource
	private AddressService addressService;
	//显示地址管理页面
	@RequestMapping("/showAddress.do")
	public String showAddress(){
		return "addressAdmin";
	}
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void> addAddress(HttpSession session,@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,@RequestParam("addressName") String recvTag){
		Integer uid = this.getId(session);
		Address address = new Address();
		address.setUid(uid);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvAddress(recvAddress);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.addAddress(address);
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"添加成功");
		return rr;
	}
	@RequestMapping("/getAddress.do")
	@ResponseBody
	public ResponseResult<List<Address>> getAddress(HttpSession session){
		List<Address> list = addressService.getAddress(this.getId(session));
		ResponseResult<List<Address>> rr = new ResponseResult<List<Address>>(1,"获取收货地址成功",list);
		return rr;
	}
	@RequestMapping("/setDefault.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(HttpSession session,Integer id){
		ResponseResult<Void> rr = null;
		try{
			addressService.setDefault(this.getId(session), id);
			rr = new ResponseResult<Void>(1,"默认地址设置成功");
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	@RequestMapping("/goUpdate.do")
	@ResponseBody
	public ResponseResult<Address> getById(Integer id){
		Address address = addressService.getById(id);
		ResponseResult<Address> rr = new ResponseResult<Address>(1,"获取成功",address);
		return rr;
	}
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	public ResponseResult<Void> updateAddress(Integer id,@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,@RequestParam("addressName") String recvTag){
		Address address = new Address();
		address.setId(id);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvAddress(recvAddress);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.updateAddress(address);
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"修改成功");
		return rr;
	}
	@RequestMapping("/removeAddress.do")
	@ResponseBody
	public ResponseResult<Void> removeAddress(Integer id){
		addressService.removeAddress(id);
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"删除成功");
		return rr;
	}
}
