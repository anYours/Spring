package com.wl.webservice.base;

/**
 * WebService服务请求接口
 *
 * @author Shisz
 *
 */
public interface IWsRequest {
	/**
	 * 向WebService服务端发送请求
	 *
	 * @param opName
	 *            所请求的服务端操作方法的标识
	 * @param condXml
	 *            请求的Xml条件
	 * @return 请求后的反馈的Xml
	 * @throws Exception
	 */
	public abstract String request() throws Exception;
}
