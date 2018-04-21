package com.sh.bos.service.impl;

import com.sh.bos.dao.SubareaDao;
import com.sh.bos.domain.Subarea;
import com.sh.bos.service.SubareaService;
import com.sh.bos.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lee leeshuhua@163.com
 * @create 2018-04-18 21:46
 **/
@Service
@Transactional
public class SubareaServiceImpl implements SubareaService{
    @Autowired
    private SubareaDao subareaDao;
    @Override
    public void save(Subarea model) {
        subareaDao.save(model);
    }

    /**
     * 分页查询
     * @param pageBean
     */
    public void pageQuery(PageBean pageBean) {
        subareaDao.pageQuery(pageBean);
    }

    @Override
    public List<Subarea> findAll() {
        return subareaDao.findAll();
    }

    /**
     * 查询所有未关联到定区的分区
     * @return
     */
    public List<Subarea> findListNotAssociation() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
        // 添加过滤条件,分区对象中decidedzone属性为null
        detachedCriteria.add(Restrictions.isNull("decidedzone"));
        return subareaDao.findByCriteria(detachedCriteria);
    }
}
