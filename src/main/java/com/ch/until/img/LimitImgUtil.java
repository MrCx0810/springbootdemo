package com.ch.until.img;

/**
 *
 * @author ch
 * @TODO
 * @date 2015�?10�?3�?
 */
public class LimitImgUtil {
	/**
	 * @todo 限制图片格式
	 * @param fileName
	 * @return boolen
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

	public static boolean limitImgSize(Long size) {
		// 限制图片大小
		Long maxsize = (long) (CommonVariable.MAXIMGSIZE * 1024);
		if (size > maxsize) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		LimitImgUtil.limitImgFormat(".jpg");
	}
}
