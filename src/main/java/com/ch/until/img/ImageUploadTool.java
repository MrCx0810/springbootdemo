package com.ch.until.img;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

/**
 * Created by：童俊旗
 * Date：2017/2/28
 * Time: 14:47
 */
public class ImageUploadTool {
    /*
        createTime 2017/2/28
        Description: 从请求里面获取多文件
        @param request
        @return MultipartFile
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
                file = multiRequest.getFile(iter.next());
            }
        }
        return file;
    }
    /*
     createTime 2017/2/28
     Description: 限制图片格式
     @param fileName 图片名称
     @return boolean
     */
    public static boolean limitImgFormat(String fileName) {
        String[] le = CommonVariable.IMGFORMAT.split("\\|");
        for (String len : le) {
            if (len.equals(fileName)) {
                return true;
            }
        }
        return false;
    }
    /*
     createTime 2017/2/28
     Description: 限制图片大小
     @param size 图片大小
     @return boolean
     */
    public static boolean limitImgSize(Long size) {

        Long maxsize = (long) (CommonVariable.MAXIMGSIZE * 1024*1024);
        if (size > maxsize) {
            return false;
        }
        return true;
    }
}
