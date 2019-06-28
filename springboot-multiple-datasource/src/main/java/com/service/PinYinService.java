package com.service;

import com.bean.PinYin;

import java.util.List;

/**
 * 拼音业务
 */
public interface PinYinService {

    /**
     * 获取所有拼音
     * @return
     */
    List<PinYin> getPinYins();

    /**
     * 删除拼音
     * @param id
     */
    void deletePinYinById(Integer id);

    /**
     * 保存拼音
     * @param pinYin
     */
    void savePinYin(PinYin pinYin);

    /**
     * 更新拼音
     * @param pinYin
     */
    void updatePinYin(PinYin pinYin);
}
