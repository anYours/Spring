package com.wl.service.impl;

import com.wl.service.CityService;
import com.wl.dao.CityDao;
import com.wl.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityDao cityDao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    @Override
    public City findCityById(Long id) {
        // 从缓存中获取城市信息
        String key = "city:" + id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            City city = operations.get(key);

            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> {}" , city.toString());
            return city;
        }

        // 从 DB 中获取城市信息
        City city = cityDao.findById(id);

        // 插入缓存
        operations.set(key, city);
        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> {}" , city.toString());

        return city;
    }

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    @Override
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    @Override
    public Long updateCity(City city) {
        Long ret = cityDao.updateCity(city);

        // 缓存存在，删除缓存
        String key = "city:" + city.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> {}" , city.toString());
            ValueOperations<String, City> operations = redisTemplate.opsForValue();
            operations.set(key, city);
            LOGGER.info("从缓存中更新了城市信息");
        }

        return ret;
    }

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    @Override
    public Long deleteCity(Long id) {
        Long ret = cityDao.deleteCity(id);

        // 缓存存在，删除缓存
        String key = "city:" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> {}" , id);
        }
        return ret;
    }
}
