package com.sh.bos.web.action;

import com.sh.bos.domain.Staff;
import com.sh.bos.service.StaffService;
import com.sh.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

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

    /**
     * 分页查询
     * @return
     * @throws IOException
     */
    public String pageQuery() throws IOException {
        // 调用service分页查询
        staffService.pageQuery(pageBean);
        // 转json并响应到页面
        this.java2Json(pageBean,new String[]{"decidedzones","currentPage","detachedCriteria","pageSize"});
        return NONE;
    }

    // 属性驱动,接收页面提交的ids参数
    private String ids;
    // 批量删除
    public String deleteBatch(){
        staffService.deleteBatch(ids);
        return LIST;
    }

    // 修改取派员信息
    public String edit(){
        // 先查询数据库，根据id查询原始数据
        Staff staff = staffService.findById(model.getId());
        // 使用页面提交数据进行覆盖
        staff.setName(model.getName());
        staff.setTelephone(model.getTelephone());
        staff.setHaspda(model.getHaspda());
        staff.setStandard(model.getStandard());
        staff.setStation(model.getStation());

        staffService.update(staff);
        return LIST;
    }

    /**
     * 查询所有未删除的取派员，返回json
     * @return
     */
    public String listAjax(){
        List<Staff> list = staffService.findListNotDelete();
        this.java2Json(list,new String[]{"decidedzones"});
        return NONE;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }


}
