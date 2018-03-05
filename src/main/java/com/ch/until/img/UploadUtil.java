package com.ch.until.img;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

public class UploadUtil {
	public static final String upfile(MultipartFile Img,HttpServletRequest request) throws IllegalStateException, IOException{
		
			String originalName = Img.getOriginalFilename();
//			System.out.println(originalName);
			//取到上传图片的后缀名
			String suffix= originalName.substring(originalName.lastIndexOf("."));
			//随机生成图片名字
			String uuid = UUID.randomUUID()+suffix;
			//获取图片存入地址
//			String realPath = request.getSession().getServletContext().getRealPath(SaveUrl);
//			System.out.println("tupain ::::"+realPath);
//			//将图片存入以上地址
//	        Img.transferTo(new File(realPath+"/"+uuid));
	        
	        return uuid;
	 }
}
