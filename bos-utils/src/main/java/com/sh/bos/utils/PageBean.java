package com.sh.bos.utils;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author lee leeshuhua@163.com
 * @create 2018-04-03 8:41
 *
 * 封装分页属性
 **/

public class PageBean {

    private int currentPage;//当前页码
    private int pageSize;//每页现实的记录数
    private DetachedCriteria detachedCriteria;//查询条件
    private int total;//总记录数
    private List rows;//当前页需要展示的数据集合

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public DetachedCriteria getDetachedCriteria() {
        return detachedCriteria;
    }

    public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
        this.detachedCriteria = detachedCriteria;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
