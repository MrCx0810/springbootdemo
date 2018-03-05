package com.ch.until.often;


import com.ch.until.time.DateTimeTool;

public class Test {
	public static void main(String[] args) {
		try {
			String str = DateTimeTool.getBeijingTime("yyyy-MM-dd HH:mm:ss");
			System.out.println("str = " + str);
			System.out.println(str.substring(0, str.length()-3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
