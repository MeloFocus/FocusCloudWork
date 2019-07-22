package com.focus.base.vm;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BaseUserCreateVM {

    @NotBlank
    @Length(max=20)
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "用户名只能用字母和数字组成")
    private String loginName;

    @NotNull
    private Boolean sex;

    @Length(max=20)
    @NotBlank
    private String realName;

    @Length(max=20)
    private String nickName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]\\w{5,17}$",message = "密码以字母开头，长度在6~18之间，只能包含字符、数字和下划线")
    private String password;

    @Length(max=50)
    private String imageId;

    @Pattern(regexp = "^[150[0-9]+]{11}",message = "电话格式不正确")
    private String phoneNumber;

    @Length(max=50)
    private String signature;

    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",message = "邮箱格式不正确")
    private String email;

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
