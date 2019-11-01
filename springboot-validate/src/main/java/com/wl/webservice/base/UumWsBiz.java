package com.wl.webservice.base;


import com.wl.webservice.IJzcxWebServicePortType;

/**
 * WebService服务端Http服务Biz
 *
 * @author Shisz
 *
 */
public class UumWsBiz implements IWsRequest {

    private IWsConnection wsConn = null;

    private String xml;
    private String userName;
    private String pwd;

    /**
     * http服务Biz
     * @param userName 账号
     * @param pwd 密码
     * @param webIp
     */
    public UumWsBiz(String xml, String userName, String pwd, String webIp){
        this.xml = xml;
        this.userName = userName;
        this.pwd = pwd;

        if(wsConn == null){
            wsConn = new UumWsConn(webIp);
        }
    }

    @Override
    public String request() throws Exception {
        IJzcxWebServicePortType port = wsConn.connection();

        String dataXml = port.gkJZCXRKJCXXCX(xml, userName, pwd);

        wsConn.closeConn();
        return dataXml;
    }
}
