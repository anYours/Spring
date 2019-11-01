package com.wl.service;

import com.wl.util.*;
import com.wl.webservice.base.IWsRequest;
import com.wl.webservice.base.UumWsBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

/**
 * @Author wul
 * @Description
 * @Date 2019/11/1 13:34
 */
@Component
public class YJPopulationService {

    public static final Logger logger = LoggerFactory.getLogger(YJPopulationService.class);

    @Autowired
    PopulationBean bean;

    public static PopulationBean cfg;

    @PostConstruct
    public void init(){
        cfg = bean;
    }

    /**
     * 调用
     */
    @SuppressWarnings("unchecked")
    public static void signingKey(){
        String appKey = "84eea7dadfe542596d60dddf7fa95f33";
        String json = utils.getSignJson();
        logger.info("开始调用接口获取签名数据");
        String sendPost = utils.sendPost(cfg.signingkeyInterfaceUrl, json);
        if(EmptyUtils.isEmpty(sendPost)){
            logger.info("获取签名数据失败");
        }else{
            logger.info("接口返回数据：{}", sendPost);
            Map<String, Object> mapObject = JsonUtil.toMapObject(sendPost);
            Object code = mapObject.get("code");
            Object message = mapObject.get("message");
            if(0 != Integer.valueOf(code.toString())){
                logger.info("调用接口失败，原因：{}", message);
            }else{
                Object data = mapObject.get("data");
                Map<String, Object> dataMap = (Map<String, Object>)data;
                Object appSecret = dataMap.get("secret");
                Object secretEndTime = dataMap.get("secretEndTime");
                logger.info("签名数据为：{}，有效期为：{}", appSecret, secretEndTime);

                String signingKey = SymmetricEncoder.AESDecode(appKey, appSecret.toString());
                RequesterCredentials.gjgxjhpt_sign = signingKey;
            }
        }
    }

    /**
     * 通过人口库校验姓名和身份证号
     * @param userName	姓名
     * @param userCode	身份证号
     * @return
     */
    public static boolean checkUser(String userName, String userCode) {
        String xml = utils.getXml(userName, userCode);
        IWsRequest wsBiz = new UumWsBiz(xml, "gxzxjkcs", "cLv6jMAaevpC3jFb7/84Ew==",
                cfg.checkUrl);
        try {
            String xmlStr = wsBiz.request();
            logger.info("人口库返回内容：{}", xmlStr);
            Document doc = DocumentHelper.parseText(xmlStr);
            Element rootElt = doc.getRootElement(); // 获取根节点
            Element dataElt = rootElt.element("DATA");
            Element recordElt = dataElt.element("RECORD");
            String code = recordElt.attributeValue("code");
            String message = recordElt.attributeValue("msg");
            if (EmptyUtils.isEmpty(code) && EmptyUtils.isEmpty(message)) {
                logger.info("人口库接口调用成功");
                String nameMatch = recordElt.elementText("XM_PPDDM");
                String codeMatch = recordElt.elementText("GMSFHM_PPDDM");
                if (1 == Integer.valueOf(nameMatch)
                        && 1 == Integer.valueOf(codeMatch)) {
                    return true;
                }
            }
        } catch (Exception e) {
            logger.error("", e);
        }

        return false;
    }

}
