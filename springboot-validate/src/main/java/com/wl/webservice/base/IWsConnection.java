package com.wl.webservice.base;


import com.wl.webservice.IJzcxWebServicePortType;

/**
 * webService连接接口
 *
 * @author Shisz
 *
 */
public interface IWsConnection {
	/**
	 * 创建连接WebService服务器的连接
	 * @return IFace
	 * @throws Exception
	 */
	public abstract IJzcxWebServicePortType connection() throws Exception;

	/**
	 * 关闭连接
	 */
	public abstract void closeConn();
}
