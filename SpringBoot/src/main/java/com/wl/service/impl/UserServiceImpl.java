package com.wl.service.impl;

import com.wl.bean.User;
import com.wl.dao.UserMapper;
import com.wl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 注册用户
     *
     * @param user
     */
    @Override
    public void registUser(User user) {
        userMapper.registUser(user);
    }

    /**
     * 查询用户名是否存在
     *
     * @param user
     */
    @Override
    public boolean userNameIfExists(User user) {
        String username = user.getUsername();
        int i = userMapper.userNameIfExists(username);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public String getPwdByPhone(String phone) {
        String pwdByPhone = userMapper.getPwdByPhone(phone);
        return pwdByPhone;
    }

    /**
     * 判断是否能登录
     *
     * @param user
     * @return
     */
    @Override
    public boolean loginIsSuccess(User user) {
        String phone = user.getPhone();
        String password = user.getPassword();
        String pwdByPhone = getPwdByPhone(phone);
        if(pwdByPhone == null){
            return false;
        }else if(!pwdByPhone.equals(password)){
            return false;
        }else{
            return true;
        }
    }


}
