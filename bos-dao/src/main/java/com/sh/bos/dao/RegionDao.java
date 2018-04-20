package com.sh.bos.dao;

import com.sh.bos.dao.base.IBaseDao;
import com.sh.bos.domain.Region;

import java.util.List;

/**
 * @author lee leeshuhua@163.com
 * @create 2018-04-16 22:00
 **/
public interface RegionDao extends IBaseDao<Region>{

    public List<Region> findListByQ(String q);
}
