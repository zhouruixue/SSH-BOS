package com.sh.bos.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.sh.bos.domain.User;
import com.sh.bos.utils.BOSUtils;


/**
 * @author lee leeshuhua@163.com
 * @create 2018-03-30 18:12
 *
 * 自定义拦截器，实现用户未登录自动跳转到登录页面
 *
 **/

public class BOSLoginInterceptor extends MethodFilterInterceptor {

    // 拦截方法
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        ActionProxy proxy = actionInvocation.getProxy();
        String actionName = proxy.getActionName();
        String namespace = proxy.getNamespace();
        String url = namespace + actionName;
        System.out.println(url);
        // 从session中获取用户对象
        User user = BOSUtils.getLoginUser();
        if(user == null){
            // 没有登录，跳转到登录页面
            return "login";
        }
        // 放行
        return actionInvocation.invoke();
    }
}
