package com.wl.webservice.base;


import com.wl.webservice.IJzcxWebServicePortType;

/**
 * WebService服务端Https服务Biz
 *
 * @author Shisz
 *
 */
public class UumSslWsBiz implements IWsRequest {

    private IWsConnection wsConn = null;

    private String xml;
    private String userName;
    private String pwd;

    /**
     * https服务Biz
     * @param version
     * @param appCode
     * @param webIp
     * @param jksUrl jks文件的Url地址
     * @param jksPwd jks文件密码
     */
    public UumSslWsBiz(String xml, String userName, String pwd, String jksUrl, String jksPwd,
                       String webIp){
        this.xml = xml;
        this.userName = userName;
        this.pwd = pwd;

        if(wsConn == null){
            wsConn = new UumWsConn(webIp, jksUrl, jksPwd);
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
