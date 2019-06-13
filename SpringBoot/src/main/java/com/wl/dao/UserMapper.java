package com.wl.dao;

import com.wl.bean.User;
import com.wl.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user(phone,username,password,gender,avatarImgUrl) values(#{phone},#{username},#{password},#{gender},#{avatarImgUrl})")
    void registUser(User user);

    @Select("select count(phone) from user where phone=#{phone}")
    int ifPhoneExists(@Param("phone") String phone);

    @Select("select password from user where phone=#{phone}")
    String getPwdByPhone(@Param("phone") String phone);

    @Select("select count(username) from user where phone=#{username}")
    int userNameIfExists(@Param("username") String userName);
}
