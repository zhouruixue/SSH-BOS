package com.sh.bos.service;

import com.sh.bos.domain.Region;
import com.sh.bos.utils.PageBean;

import java.util.List; /**
 * @author lee leeshuhua@163.com
 * @create 2018-04-16 21:55
 **/

public interface RegionService {

    public void saveBatch(List<Region> regionList);

    public void pageQuery(PageBean pageBean);

    public List<Region> findAll();

    public List<Region> findListByQ(String q);
}
