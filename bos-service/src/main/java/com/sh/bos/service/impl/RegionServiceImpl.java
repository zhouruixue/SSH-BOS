package com.sh.bos.service.impl;

import com.sh.bos.dao.RegionDao;
import com.sh.bos.domain.Region;
import com.sh.bos.service.RegionService;
import com.sh.bos.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lee leeshuhua@163.com
 * @create 2018-04-16 21:57
 **/
@Service
@Transactional
public class RegionServiceImpl implements RegionService{
    @Autowired
    private RegionDao regionDao;
    /**
     * 区域数据批量保存
     * @param regionList
     */
    public void saveBatch(List<Region> regionList) {
        for (Region region:regionList) {
            regionDao.saveOrUpdate(region);
        }
    }

    /**
     * 区域分页方法
     * @param pageBean
     */
    public void pageQuery(PageBean pageBean) {
        regionDao.pageQuery(pageBean);
    }

    /**
     * 查询所有
     * @return
     */
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    /**
     * 根据输入条件进行模糊查询
     * @param q
     * @return
     */
    public List<Region> findListByQ(String q) {
        return regionDao.findListByQ(q);
    }
}
