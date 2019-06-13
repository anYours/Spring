package com.wl.service;

import com.wl.bean.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    void registUser(User user);

    /**
     * 查询用户名是否存在
     * @param user
     */
    boolean userNameIfExists(User user);

    /**
     * 根据手机号获取密码
     * @param phone
     * @return
     */
    String getPwdByPhone(String phone);

    /**
     * 判断是否能登录
     * @param user
     * @return
     */
    boolean loginIsSuccess(User user);
}
