package com.sh.bos.service.impl;

import com.sh.bos.domain.Staff;
import com.sh.bos.dao.base.StaffDao;
import com.sh.bos.service.StaffService;
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
}
