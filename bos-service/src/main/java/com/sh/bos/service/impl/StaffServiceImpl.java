package com.sh.bos.service.impl;

import com.sh.bos.domain.Staff;
import com.sh.bos.dao.StaffDao;
import com.sh.bos.service.StaffService;
import com.sh.bos.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lee leeshuhua@163.com
 * @create 2018-04-02 15:53
 **/

@Service
@Transactional
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffDao staffDao;
    @Override
    public void save(Staff model) {
        staffDao.save(model);
    }

    @Override
    public void pageQuery(PageBean pageBean) {
        staffDao.pageQuery(pageBean);
    }

    // 取派员批量删除
    // 逻辑删除，将deltag改为1
    public void deleteBatch(String ids) {
        if(StringUtils.isNotBlank(ids)){
            String[] staffIds = ids.split(",");
            for (String id:staffIds) {
                staffDao.executeUpdate("staff.delete",id);
            }
        }
    }

    // 根据id查询取派员
    public Staff findById(String id) {
        return staffDao.findById(id);
    }

    // 根据id修改取派员
    public void update(Staff staff) {
        staffDao.update(staff);
    }
}
