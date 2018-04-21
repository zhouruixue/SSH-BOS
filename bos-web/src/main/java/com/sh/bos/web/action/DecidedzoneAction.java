package com.sh.bos.web.action;

import com.sh.bos.domain.Decidedzone;
import com.sh.bos.service.DecidedzoneService;
import com.sh.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * 定区管理
 * @author lee leeshuhua@163.com
 * @create 2018-04-21 15:12
 **/
@Controller
@Scope
public class DecidedzoneAction extends BaseAction<Decidedzone>{

    @Autowired
    private DecidedzoneService decidedzoneService;
    // 属性驱动，接收多个分区id
    private String[] subareaid;

    public String[] getSubareaid() {
        return subareaid;
    }

    public void setSubareaid(String[] subareaid) {
        this.subareaid = subareaid;
    }

    /**
     * 添加定区
     * @return
     */
    public String add(){
        decidedzoneService.save(model,subareaid);
        return LIST;
    }

    /**
     * 分页查询定区
     * @return
     * @throws IOException
     */
    public String pageQuery() throws IOException {
        // 调用service分页查询
        decidedzoneService.pageQuery(pageBean);
        // 转json并响应到页面
        this.java2Json(pageBean,new String[]{"currentPage","detachedCriteria","pageSize","subareas","decidedzones"});
        return NONE;
    }
}
