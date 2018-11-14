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
	//ʵ���ϴ��Ĺ���
	@RequestMapping("/upload.do")
	public String uploadFile(MultipartFile file) throws Exception{
		//��һ��������ʾ�ϴ��ļ�д����λ�ã���һ��������ʾ
		file.transferTo(new File("e:/",file.getOriginalFilename()));
		return "redirect:../main/showIndex.do";
	}
}
