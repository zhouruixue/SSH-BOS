package com.sh.bos.service.impl;

import com.sh.bos.dao.StaffDao;
import com.sh.bos.domain.Staff;
import com.sh.bos.service.StaffService;
import com.sh.bos.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * 取派员批量删除
     * 逻辑删除，将deltag改为1
     * @param ids
     */
    public void deleteBatch(String ids) {
        if(StringUtils.isNotBlank(ids)){
            String[] staffIds = ids.split(",");
            for (String id:staffIds) {
                staffDao.executeUpdate("staff.delete",id);
            }
        }
    }

    /**
     * 根据id查询取派员
     * @param id
     * @return
     */
    public Staff findById(String id) {
        return staffDao.findById(id);
    }

    /**
     * 根据id修改取派员
     * @param staff
     */
    public void update(Staff staff) {
        staffDao.update(staff);
    }

    /**
     * 查询所有未删除的取派员
     * @return
     */
    public List<Staff> findListNotDelete() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
        // 添加过滤条件
        detachedCriteria.add(Restrictions.eq("deltag","0"));
        //detachedCriteria.add(Restrictions.ne("dettag","1")); // 同上面等价
        return staffDao.findByCriteria(detachedCriteria);
    }
}
