package com.model;

import javax.validation.constraints.*;
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 4, message = "姓名长度必须大于 2 且小于 4 字")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄不能小于零")
    @Max(value = 200, message = "年龄不得大于200岁")
    private int age;

    @NotNull(message = "生日不能为空")
    private String birthday;

    @Email(message = "不是正确的邮箱地址")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
