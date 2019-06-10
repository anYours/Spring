package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.model.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CityDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    /**
     * 保存
     * @param city
     * @return
     */
    Long saveCity(City city);

    /**
     * 更新
     * @param city
     * @return
     */
    Long updateCity(City city);

    /**
     * 删除
     * @param id
     * @return
     */
    Long deleteCity(Long id);
}
