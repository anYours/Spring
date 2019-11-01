package com.wl.webservice.base;

/**
 * WebService��������ӿ�
 * 
 * @author Shisz
 *
 */
public interface IWsRequest {
	/**
	 * ��WebService����˷�������
	 * 
	 * @param opName
	 *            ������ķ���˲��������ı�ʶ
	 * @param condXml
	 *            �����Xml����
	 * @return �����ķ�����Xml
	 * @throws Exception 
	 */
	public abstract String request() throws Exception;
}
