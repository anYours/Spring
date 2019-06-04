package com.wl.bean;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "user")
@DynamicUpdate
@DynamicInsert
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String gender;

    /**
     * 真实姓名
     */
    private String trueName;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 个人简介
     */
    private String personalBrief;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 最后登录时间
     */
    private String recentlyLanded;

    /**
     * 头像地址
     */
    private String avatarImgUrl;

    public User(){}

    public User(String phone, String username, String password, String gender) {
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public User(String phone, String username, String password, String gender, String trueName, String birthday, String personalBrief, String email, String recentlyLanded, String avatarImgUrl) {
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.trueName = trueName;
        this.birthday = birthday;
        this.personalBrief = personalBrief;
        this.email = email;
        this.recentlyLanded = recentlyLanded;
        this.avatarImgUrl = avatarImgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPersonalBrief() {
        return personalBrief;
    }

    public void setPersonalBrief(String personalBrief) {
        this.personalBrief = personalBrief;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecentlyLanded() {
        return recentlyLanded;
    }

    public void setRecentlyLanded(String recentlyLanded) {
        this.recentlyLanded = recentlyLanded;
    }

    public String getAvatarImgUrl() {
        return avatarImgUrl;
    }

    public void setAvatarImgUrl(String avatarImgUrl) {
        this.avatarImgUrl = avatarImgUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", trueName='" + trueName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", personalBrief='" + personalBrief + '\'' +
                ", email='" + email + '\'' +
                ", recentlyLanded='" + recentlyLanded + '\'' +
                ", avatarImgUrl='" + avatarImgUrl + '\'' +
                '}';
    }
}
