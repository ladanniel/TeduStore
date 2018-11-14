package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@RequestMapping("/showUpload.do")
	public String showUpload(){
		return "upload";
	}
	//实现上传的功能
	@RequestMapping("/upload.do")
	public String uploadFile(MultipartFile file) throws Exception{
		//第一个参数表示上传文件写出的位置，后一个参数表示
		file.transferTo(new File("e:/",file.getOriginalFilename()));
		return "redirect:../main/showIndex.do";
	}
}
