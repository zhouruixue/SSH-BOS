package com.sh.bos.web.action;

import com.sh.bos.domain.Staff;
import com.sh.bos.service.StaffService;
import com.sh.bos.utils.PageBean;
import com.sh.bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

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

    // 属性驱动，接收页面提交的分页参数
    private int page;
    private int rows;
    // 分页查询
    public String pageQuery() throws IOException {
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);
        // 创建离线查询对象
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
        pageBean.setDetachedCriteria(detachedCriteria);
        staffService.pageQuery(pageBean);

        JsonConfig jsonConfig = new JsonConfig();
        // 指定哪些属性不需要转json
        jsonConfig.setExcludes(new String[]{"currentPage","detachedCriteria","pageSize"});
        // 使用json-lib将pageBean对象转为json,通过输出流写回页面中
        // JSONObject -- 将单一对象转为json
        // JSONArray -- 将数组或者集合对象转为json
        String json = JSONObject.fromObject(pageBean,jsonConfig).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(json);
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }


}
