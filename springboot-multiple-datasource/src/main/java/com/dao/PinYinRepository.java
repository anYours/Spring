package com.dao;


import com.bean.PinYin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PinYinRepository {

    @Select("select * from pinyin")
    List<PinYin> findAll();

    @Delete("delete from pinyin where id = ${id}")
    void deleteById(@Param("id") Integer id);

    @Insert("insert into pinyin(py) values(#{py})")
    void save(PinYin pinyin);

    @Update("update set pinyin=#{pinyin} where id = #{id}")
    void update(PinYin pinYin);
}

