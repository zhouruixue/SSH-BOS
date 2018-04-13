package com.sh.bos.service;

import com.sh.bos.domain.Staff;
import com.sh.bos.utils.PageBean; /**
 * @author lee leeshuhua@163.com
 * @create 2018-04-02 15:43
 **/

public interface StaffService {

    public void save(Staff model);

    public void pageQuery(PageBean pageBean);

    public void deleteBatch(String ids);

    public Staff findById(String id);

    public void update(Staff staff);
}
