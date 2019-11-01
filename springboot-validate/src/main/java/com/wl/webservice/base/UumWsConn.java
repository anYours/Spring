package com.wl.webservice.base;

import com.wl.util.HeaderHandlerResolver;
import com.wl.util.RequesterCredentials;
import com.wl.webservice.IJzcxWebService;
import com.wl.webservice.IJzcxWebServicePortType;

import java.net.URL;

import javax.xml.ws.WebServiceException;

public class UumWsConn implements IWsConnection {

	private String webIp; // ��������ַ

	/**
	 * @param webIp
	 *            ��������ַ����:http://127.0.0.1:9000/
	 */
	public UumWsConn(String webIp) {
		if (!(webIp.toLowerCase().startsWith("http://"))) {
			webIp = "http://" + webIp;
		}
		if (!webIp.endsWith("/")) {
			webIp = webIp + "/";
		}

		this.webIp = webIp;
	}
	/**
	 * Https����
	 * @param webIp ��������ַ����:https://127.0.0.1:9443/
	 * @param jksUrl
	 * @param jksPwd
	 * @throws Exception 
	 */
	public UumWsConn(String webIp, String jksUrl, String jksPwd){
		if(!(webIp.toLowerCase().startsWith("https://"))){
			webIp = "https://" + webIp;
		}
		if (!webIp.endsWith("/")) {
			webIp = webIp + "/";
		}
		this.webIp = webIp;
		// https��֤��ʽ
		if (jksUrl != null && jksPwd != null && !jksUrl.trim().equals("")) {
			
			System.clearProperty("javax.net.ssl.trustStore");
            System.clearProperty("javax.net.ssl.keyStoreType");
            System.clearProperty("javax.net.ssl.keyStorePassword");
			
			System.setProperty("javax.net.ssl.trustStore", jksUrl);
		    System.setProperty("javax.net.ssl.trustStorePassword",jksPwd);
		    

		    System.setProperty("javax.net.ssl.keyStoreType","JKS");
		    System.setProperty("javax.net.ssl.keyStore",jksUrl);
		    System.setProperty("javax.net.ssl.keyStorePassword",jksPwd);
		}
	}

	@Override
	public IJzcxWebServicePortType connection() throws Exception {
		IJzcxWebService service = null;
		try {
			service = new IJzcxWebService(new URL(webIp ));
			RequesterCredentials r = new RequesterCredentials();
			HeaderHandlerResolver headerHandlerResolver=new HeaderHandlerResolver (r);
			service .setHandlerResolver(headerHandlerResolver);
		} catch (WebServiceException e) {
			String err = "与服务器连接失败";
			throw new Exception(err + "：" + e.getMessage(), e);
		}

		IJzcxWebServicePortType port = service.getIJzcxWebServiceHttpPort();

		return port;
	}

	@Override
	public void closeConn() {

	}
}
