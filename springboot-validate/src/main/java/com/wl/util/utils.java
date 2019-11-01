package com.wl.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class utils {
	
	public static final Logger logger = LoggerFactory.getLogger(utils.class);

	@Autowired
	PopulationBean bean;

	public static PopulationBean cfg;

	@PostConstruct
	public void init(){
		cfg = bean;
	}


	public static String getMD5(String sourceStr) {
		String resultStr = "";
		try {
			byte[] temp = sourceStr.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(temp);
			byte[] b = md5.digest();
			for (int i = 0; i < b.length; i++) {
				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
						'9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] ob = new char[2];
				ob[0] = digit[(b[i] >>> 4) & 0X0F];
				ob[1] = digit[b[i] & 0X0F];
				resultStr += new String(ob);
			}
			return resultStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	/**
	 * �����Žӿ� 
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			logger.info("失败", e);
		}
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				logger.error("", ex);
			}
		}
		return result;
	}
	
	/**
	 * ��ȡǩ��json
	 * @return
	 */
	public static String getSignJson(){
		String rid = "f9e001b4-592d-4745-858b-6ae599d4e1cd@2399";
		String sid = "s_1200000900000_2108";
		String appKey = "84eea7dadfe542596d60dddf7fa95f33";
		String rTime = ""+System.currentTimeMillis();
		String sign = HmacSHA256Util.sign(sid, rid, appKey, rTime);
		StringBuilder sb = new StringBuilder();
		sb.append("{")
		.append("\"gjgxjhpt_rid\":\"").append(rid).append("\",")
		.append("\"gjgxjhpt_sid\":\"").append(sid).append("\",")
		.append("\"gjgxjhpt_rtime\":\"").append(rTime).append("\",")
		.append("\"gjgxjhpt_sign\":\"").append(sign).append("\"")
		.append("}");
		return sb.toString();
	}
	
	/**
	 * @param userName
	 * @param userCode
	 * @return
	 */
	public static String getXml(String userName, String userCode){
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml  version='1.0' encoding='UTF-8'?>")
		.append("<PACKAGE>")
		.append("<PACKAGEHEAD>")
		.append("<FWQQBH>").append(cfg.FWQQBH).append("</FWQQBH>")
		.append("<QQBWDM>").append(cfg.QQBWDM).append("</QQBWDM>")
		.append("<QQBWMC>").append(cfg.QQBWMC).append("</QQBWMC>")
		.append("<SJLYXTDM>").append(cfg.SJLYXTDM).append("</SJLYXTDM>")
		.append("<SJLYXTMC>").append(cfg.SJLYXTMC).append("</SJLYXTMC>")
		.append("<JLS>").append(1).append("</JLS>")
		.append("<FSSJ>").append(cfg.FSSJ).append("</FSSJ>")
		.append("<QQRGMSFHM>").append(cfg.QQRGMSFHM).append("</QQRGMSFHM>")
		.append("<QQRXM>").append(cfg.QQRXM).append("</QQRXM>")
		.append("<QQRDWDM>").append(cfg.QQRDWDM).append("</QQRDWDM>")
		.append("<QQRDWMC>").append(cfg.QQRDWMC).append("</QQRDWMC>")
		.append("<QQYWLXDM>").append(cfg.QQYWLXDM).append("</QQYWLXDM>")
		.append("<QQYWLXMC>").append(cfg.QQYWLXMC).append("</QQYWLXMC>")
		.append("<QQYWXTDM>").append(cfg.QQYWXTDM).append("</QQYWXTDM>")
		.append("<QQYWXTMC>").append(cfg.QQYWXTMC).append("</QQYWXTMC>")
		.append("</PACKAGEHEAD>")
		.append("<DATA>")
		.append("<RECORD no='1'>")
		.append("<GMSFHM>").append(userCode).append("</GMSFHM>")
		.append("<XM>").append(userName).append("</XM>")
		.append("</RECORD>")
		.append("/<DATA>")
		.append("</PACKAGE>");
		return sb.toString();
	}
}
