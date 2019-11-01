package com.wl.webservice.base;


import com.wl.webservice.IJzcxWebServicePortType;

/**
 * webService���ӽӿ�
 * 
 * @author Shisz
 *
 */
public interface IWsConnection {
	/**
	 * ��������WebService������������
	 * @return IFace
	 * @throws Exception 
	 */
	public abstract IJzcxWebServicePortType connection() throws Exception;
	
	/**
	 * �ر�����
	 */
	public abstract void closeConn();
}
