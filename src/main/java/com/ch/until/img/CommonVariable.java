package com.ch.until.img;

/**
 * Created by：童俊旗
 * Date：2017/2/28
 * Time: 15:23
 */
public class CommonVariable {

    // 激活状态
    public final static byte ACTIVATION = 1;

    // 冻结状态
    public final static byte FROZEN = 0;

    // 返回状态
    public final static String STATUS = "status";

    // 返回成功
    public final static String SUCCESS = "success";

    // 返回失败
    public final static String FAIL = "fail";

    // 默认每页返回数据条数
    public final static int SIZE = 20;

    // 返回数据提示信息
    public final static String MESSAGE = "Message";

    // 上传头像保存位置(本地环境)
    //public final static String HEADIMGPATH = "UploadFile/head_Img/";

    // 上传头像保存位置(本地环境)
    //public final static String HEADIMGPATH = "goodsAlbum/";

    // 上传保存位置(线上环境)
    public final static String IMGPARENTPATH = "/upload-static/upload/hall";
    public final static String HALLIMGPARENTPATH = "/upload-static/upload/home";
    public final static String ARTICLEIMGPARENTPATH = "/upload-static/upload/article";
    public final static String HEADIMGPATH = "/upload-static/upload/head";
    // 上传保存位置(本地环境)
    //public final static String GOODSIMGPATH = "UploadFile/goods_Img/";

    public final static String SHOPIMGPATH = "shop_img/";

    // 上传图片限制格式只能是如下 格式 可以自由添加格式限制比如添加 |.zip
    public final static String IMGFORMAT = ".jpg|.png";

    // 上传图片限制大小kb
    public final static int MAXIMGSIZE = 3;

    // 上传图片服务器ip地址
    //
    //public final static String SERVER_ADDR_IMG = "123.56.163.113:8080";

}

