package com.wl.util;


public class HttpSendSMSUtils {

	public String sendReport(String orgcode, String btype, String pwd,
			String mb, String msg, String exno, String v1, String v2) {
		String errMess = "";
		StringBuffer sendData = new StringBuffer("");
		try {
			// �û���
			sendData.append("orgcode=").append(orgcode);
			// ����
			sendData.append("&btype=").append(btype);
			// encode=GBK����encode=utf8
			sendData.append("&pwd=").append(pwd);
			// ��ͨȺ��
			errMess = utils.sendPost(
					"http://10.16.6.146:8082/sms/smsgetmsg/getmr",
					sendData.toString());

		} catch (Exception e) {
			errMess = "-601";
		}
		return errMess;
	}
}
