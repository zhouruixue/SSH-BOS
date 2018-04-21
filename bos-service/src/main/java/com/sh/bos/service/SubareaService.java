package com.sh.bos.service;

import com.sh.bos.domain.Subarea;
import com.sh.bos.utils.PageBean;

import java.util.List;

/**
 * @author lee leeshuhua@163.com
 * @create 2018-04-18 21:45
 **/
public interface SubareaService {

    public void save(Subarea model);

    public void pageQuery(PageBean pageBean);

    public List<Subarea> findAll();

    public List<Subarea> findListNotAssociation();
}
