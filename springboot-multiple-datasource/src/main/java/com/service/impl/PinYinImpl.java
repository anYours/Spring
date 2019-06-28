package com.service.impl;

import com.aop.Master;
import com.bean.PinYin;
import com.dao.PinYinRepository;
import com.service.PinYinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PinYinImpl implements PinYinService {

    @Resource
    private PinYinRepository pinYinRepository;

    /**
     * 获取所有拼音
     *
     * @return
     */
    @Override
    public List<PinYin> getPinYins() {
        return pinYinRepository.findAll();
    }

    /**
     * 删除拼音
     *
     * @param id
     */
    @Override
    public void deletePinYinById(Integer id) {
        pinYinRepository.deleteById(id);
    }

    /**
     * 保存拼音
     *
     * @param pinYin
     */
    @Master
    @Override
    public void savePinYin(PinYin pinYin) {
        pinYinRepository.save(pinYin);
    }

    /**
     * 更新拼音
     *
     * @param pinYin
     */
    @Override
    public void updatePinYin(PinYin pinYin) {
        pinYinRepository.update(pinYin);
    }
}
