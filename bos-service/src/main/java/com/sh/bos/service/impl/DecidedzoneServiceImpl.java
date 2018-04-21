package com.sh.bos.service.impl;

import com.sh.bos.dao.DecidedzoneDao;
import com.sh.bos.dao.SubareaDao;
import com.sh.bos.domain.Decidedzone;
import com.sh.bos.domain.Subarea;
import com.sh.bos.service.DecidedzoneService;
import com.sh.bos.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lee leeshuhua@163.com
 * @create 2018-04-21 15:25
 **/
@Service
@Transactional
public class DecidedzoneServiceImpl implements DecidedzoneService{
    @Autowired
    private DecidedzoneDao decidedzoneDao;
    @Autowired
    private SubareaDao subareaDao;

    /**
     * 添加一个定区，同时关联分区
     * @param model
     * @param subareaid
     */
    public void save(Decidedzone model, String[] subareaid) {
        decidedzoneDao.save(model);
        for(String id : subareaid){
            Subarea subarea = subareaDao.findById(id);
            subarea.setDecidedzone(model);
        }
    }

    @Override
    public void pageQuery(PageBean pageBean) {
        decidedzoneDao.pageQuery(pageBean);
    }
}
