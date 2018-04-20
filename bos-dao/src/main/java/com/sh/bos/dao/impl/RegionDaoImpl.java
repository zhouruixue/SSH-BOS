package com.sh.bos.dao.impl;

import com.sh.bos.dao.RegionDao;
import com.sh.bos.dao.base.impl.BaseDaoImpl;
import com.sh.bos.domain.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lee leeshuhua@163.com
 * @create 2018-04-16 22:03
 **/
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements RegionDao{

    /**
     * 根据q参数进行模糊查询
     * @param q
     * @return
     */
    public List<Region> findListByQ(String q) {
        String hql = "FROM Region r WHERE r.shortcode LIKE ? "
                + "	OR r.citycode LIKE ? OR r.province LIKE ? "
                + "OR r.city LIKE ? OR r.district LIKE ?";
        List<Region> list = (List<Region>) this.getHibernateTemplate().
                find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
        return list;
    }
}
