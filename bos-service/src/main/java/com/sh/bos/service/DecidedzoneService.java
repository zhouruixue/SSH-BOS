package com.sh.bos.service;

import com.sh.bos.domain.Decidedzone;
import com.sh.bos.utils.PageBean; /**
 * @author lee leeshuhua@163.com
 * @create 2018-04-21 15:23
 **/
public interface DecidedzoneService {

    public void save(Decidedzone model, String[] subareaid);

    public void pageQuery(PageBean pageBean);
}
