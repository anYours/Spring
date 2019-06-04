package com.wl.dao;

import com.wl.base.BaseMapper;
import com.wl.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user(phone,username,password,gender,avatarImgUrl) values(#{phone},#{username},#{password},#{gender},#{avatarImgUrl})")
    void loginUser(User user);

    @Select("select count(phone) from user where phone=#{phone}")
    int ifPhoneExists(@Param("phone") String phone);

    @Select("select password from user where phone=#{phone}")
    User getPwdByPhone(@Param("phone") String phone);
}
