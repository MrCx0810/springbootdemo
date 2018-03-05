package com.ch.until.http;


import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * Created by：童俊旗
 * Date：2017/9/18
 * Time: 15:50
 */
public class HttpUtil {

    public static String encoding;
    private static final HttpConnectionManager connectionManager;

    private static final HttpClient client;

    static {

        HttpConnectionManagerParams params = loadHttpConfFromFile();

        connectionManager = new MultiThreadedHttpConnectionManager();

        connectionManager.setParams(params);

        client = new HttpClient(connectionManager);
    }
    public static String get(String url, HashMap<String,Object> param){
        try {
            if(param != null && param.size() > 0){
                StringBuilder urlSb = new StringBuilder(url);
                if(url.indexOf("?") == -1){
                    urlSb.append("?");
                }
                Iterator<Entry<String, Object>> iter = param.entrySet().iterator();
                while(iter.hasNext()){
                    Entry<String, Object> next = iter.next();
                    String key = next.getKey();
                    Object value = next.getValue();
                    urlSb.append(key);
                    urlSb.append("=");
                    urlSb.append(value);
                    urlSb.append("&");
                }
                url = urlSb.toString();
            }
            byte[] resp = get(url);
            if (null == resp)
                return null;
            return new String(resp, encoding);
        } catch (Exception e) {
            return null;
        }
    }
    public static byte[] get(String url){
        GetMethod method = new GetMethod(url);
        method.addRequestHeader("Connection", "Keep-Alive");
        method.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
        method.addRequestHeader("Content-Type","application/x-www-form-urlencoded");
        try {
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            return method.getResponseBody();

        } catch (SocketTimeoutException e) {
            return null;
        } catch (Exception e) {
            return null;
        } finally {
            method.releaseConnection();
        }
    }
    private static HttpConnectionManagerParams loadHttpConfFromFile(){
        Properties p  = new Properties();
        try {
            p.load(HttpUtil.class.getResourceAsStream(HttpUtil.class.getSimpleName().toLowerCase() + ".properties"));
        } catch (IOException e) {
        }

        encoding = p.getProperty("http.content.encoding");

        HttpConnectionManagerParams params = new HttpConnectionManagerParams();
        params.setConnectionTimeout(Integer.parseInt(p.getProperty("http.connection.timeout")));
        params.setSoTimeout(Integer.parseInt(p.getProperty("http.so.timeout")));
        params.setStaleCheckingEnabled(Boolean.parseBoolean(p.getProperty("http.stale.check.enabled")));
        params.setTcpNoDelay(Boolean.parseBoolean(p.getProperty("http.tcp.no.delay")));
        params.setDefaultMaxConnectionsPerHost(Integer.parseInt(p.getProperty("http.default.max.connections.per.host")));
        params.setMaxTotalConnections(Integer.parseInt(p.getProperty("http.max.total.connections")));
        params.setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
        return params;
    }
}
