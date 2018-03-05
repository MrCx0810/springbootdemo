package com.ch.until.img;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author ch
 * @TODO
 * @date 2015年10月3日
 */
public class UploadFIleUtil {
	/**
	 * 获取单个上传的文件
	 * 
	 * @return
	 */
	public static MultipartFile getUploadFile(HttpServletRequest request) {
		 MultipartFile file = null;
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				file =  multiRequest.getFile(iter.next());
			}
		}
//		System.out.println("图片数组=="+list);
		return file;
	}

	
	/**
	 * 文件上传（单/多）
	 * @author chenhui
	 * @param request
	 * @return
	 */
	public static List<MultipartFile> getUploadFiles(HttpServletRequest request) {
		 // String uploadPath=request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
	     CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
	     List<MultipartFile> list = new ArrayList<MultipartFile>();
	     try{
		     if(multipartResolver.isMultipart(request)){
		         MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request; //必须这样用上面那种出错,文件传递过来没得
		            Iterator<String> ite = multiRequest.getFileNames();
		            while(ite.hasNext()){
		                MultipartFile file = multiRequest.getFile(ite.next());
		                if(null != file) { 
		                  list.add(file);
		                }
		            }
		     }
	     }catch(Exception e){
	        e.printStackTrace();
	     }
	     return list;
	}
	
	
	/**
	 * 文件上传服务器
	 * @author chenhui
	 * @param imgfiles
	 * @param req
	 * @param url
	 * @return
	 */
	public static List<String> UploadPicture(List<MultipartFile> imgfiles,HttpServletRequest req,String url) {
		List<String> list = new ArrayList<String>();
		String uuid = null;
		if (!imgfiles.isEmpty()) {
			for( MultipartFile img:imgfiles) {
				// 取得当前上传文件的文件名称
				String myFileName = img.getOriginalFilename();
				System.out.println("多文件"+myFileName);
				// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
				if (myFileName.trim() != "") {
					// 重命名上传后的文件名
					String tempFileName = myFileName.substring(myFileName.lastIndexOf("."), myFileName.length());
					// 限制图片格式
					boolean flag = LimitImgUtil.limitImgFormat(tempFileName);
					if (flag) {
						try {
							uuid = UploadUtil.upfile(img,req);
							list.add(uuid);
							System.out.println("图片名=="+uuid);
							String realPath = req.getSession().getServletContext().getRealPath(url);
							System.out.println("上传服务器>>>>>>"+realPath);
							//将图片存入以下地址
							File file = new File(realPath + "/" + uuid);
							if(!file.getParentFile().exists()){
								file.getParentFile().mkdirs();
							}
							img.transferTo(file);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		System.out.println(list);
		return list;
	}
	
}
