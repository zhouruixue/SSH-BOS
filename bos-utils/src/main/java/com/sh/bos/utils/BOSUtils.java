package com.sh.bos.utils;

import com.sh.bos.domain.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * BOS项目工具类
 * @author lee leeshuhua@163.com
 * @create 2018-03-30 18:27
 **/

public class BOSUtils {
    // 获取session对象
    public static HttpSession getSession(){
        return ServletActionContext.getRequest().getSession();
    }

    // 获取登录用户对象
    public static User getLoginUser(){
        return (User)getSession().getAttribute("loginUser");
    }
}
