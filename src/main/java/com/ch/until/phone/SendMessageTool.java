package com.ch.until.phone;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.net.HttpURLConnection;
import java.net.URL;


public class SendMessageTool {
	public static final int DEF_CONN_TIMEOUT = 60000;
    public static final int DEF_READ_TIMEOUT = 60000;
	private static  String url ="http://sms.ejar.com.cn/JcSms/send"; //请求地址
	//private static  String KEY ="3HP45b8D80BDUbLxcEJTCL2Dvth4bIWe"; //密令
	private static String key = "bnjkKGchEBkvU8KuSBUAvXe2frTpsQ6z";
	static public String sendMsg(String phone,String msg) throws Exception{ 
		HttpURLConnection conn =null;
		String result = null;
		try {
	        HttpClient client = new HttpClient();
	        PostMethod post = new PostMethod(url);
	        URL newurl=new URL(url);
	        conn  = (HttpURLConnection) newurl.openConnection();
	        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
	        NameValuePair[] data ={
	    		new NameValuePair("key",key),
	    		new NameValuePair("mob",phone),
	    		new NameValuePair("msg",msg)
	        };
	        post.setRequestBody(data);
	        client.executeMethod(post);
	        //设置主机连接超时
	        conn.setConnectTimeout(DEF_CONN_TIMEOUT);
	        //设置主机读取数据超时
	        conn.setReadTimeout(DEF_READ_TIMEOUT);
	        conn.setInstanceFollowRedirects(false);
	        conn.connect();
	        Header[] headers = post.getResponseHeaders();
	        int statusCode = post.getStatusCode();        
	        result  = new String(post.getResponseBodyAsString().getBytes()); 
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
                conn.disconnect();
            }
		}
        return result;	
       //post.releaseConnection();  
        //ResultObj res = JSON.parseObject(result, ResultObj.class);
//        System.out.println(group2.getBatchno());
//        System.out.println(group2.getRespcode());
//        System.out.println(group2.getRespdesc());  
        //return res;
    }
}	
/*	 class ResultObj{
		 private String batchno;
		 private String respcode;
		 private String respdesc;
		 
		public String getBatchno() {
			return batchno;
		}
		public void setBatchno(String batchno) {
			this.batchno = batchno;
		}
		public String getRespcode() {
			return respcode;
		}
		public void setRespcode(String respcode) {
			this.respcode = respcode;
		}
		public String getRespdesc() {
			return respdesc;
		}
		public void setRespdesc(String respdesc) {
			this.respdesc = respdesc;
		}		 
	}*/
