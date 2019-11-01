package com.wl.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author wul
 * @Description
 * @Date 2019/11/1 13:19
 */

@Component
public class PopulationBean {

    @Value("${PopulationBean.FWQQBH}")
    public String FWQQBH;
    /**
     * 请求部委代码，统一为“GJXXZX”
     */
    @Value("${PopulationBean.QQBWDM}")
    public String QQBWDM;
    /**
     * 请求部委名称，统一为“国家信息中心”
     */
    @Value("${PopulationBean.QQBWMC}")
    public String QQBWMC;
    /**
     * 省级政务系统所属机构代码，所属上级机构代码
     */
    @Value("${PopulationBean.SJLYXTDM}")
    public String SJLYXTDM;
    /**
     * 省级政务系统所属机构名称，所属上级机构代码
     */
    @Value("${PopulationBean.SJLYXTMC}")
    public String SJLYXTMC;
    /**
     * 发送时间，YYYYMMDDhhmmss
     */
    @Value("${PopulationBean.FSSJ}")
    public String FSSJ;
    /**
     * 请求人公民身份号码，使用服务的请求人的公民身份号码
     */
    @Value("${PopulationBean.QQRGMSFHM}")
    public String QQRGMSFHM;
    /**
     * 请求人姓名，使用服务的请求人的姓名
     */
    @Value("${PopulationBean.QQRXM}")
    public String QQRXM;
    /**
     * 请求单位代码，使用服务的单位代码
     */
    @Value("${PopulationBean.QQRDWDM}")
    public String QQRDWDM;
    /**
     * 请求单位名称，使用服务的单位名称
     */
    @Value("${PopulationBean.QQRDWMC}")
    public String QQRDWMC;
    /**
     * 请求业务类型代码，使用服务的业务类型代码。必填。如果有业务类型代码字典，需要按照代码规范填写，并将业务类型代码字典报给国家人口库。
     */
    @Value("${PopulationBean.QQYWLXDM}")
    public String QQYWLXDM;
    /**
     * 请求业务类型名称，使用服务的业务类型名称
     */
    @Value("${PopulationBean.QQYWLXMC}")
    public String QQYWLXMC;
    /**
     * 请求业务系统代码，请求来源的业务系统代码。
     */
    @Value("${PopulationBean.QQYWXTDM}")
    public String QQYWXTDM;
    /**
     * 请求业务系统名称，请求来源的业务系统名称
     */
    @Value("${PopulationBean.QQYWXTMC}")
    public String QQYWXTMC;

    @Value("${PopulationBean.signingkeyInterfaceUrl}")
    public String signingkeyInterfaceUrl;

    @Value("${PopulationBean.checkUrl}")
    public String checkUrl;
}
