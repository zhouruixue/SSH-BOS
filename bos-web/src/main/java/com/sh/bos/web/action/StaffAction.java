package com.sh.bos.web.action;

import com.sh.bos.domain.Staff;
import com.sh.bos.service.StaffService;
import com.sh.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author lee leeshuhua@163.com
 * @create 2018-04-02 14:56
 *
 * 取派员管理
 **/
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff>{

    @Autowired
    private StaffService staffService;

    // 添加取派员方法
    public String add(){
        staffService.save(model);
        return LIST;
    }
}
