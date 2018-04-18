package com.sh.bos.test;

import com.sh.bos.utils.PinYin4jUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * @author lee leeshuhua@163.com
 * @create 2018-04-17 17:06
 **/

public class Pinyin4JTest {
    @Test
    public void test1(){
        // 河北省 石家庄市 桥西区
        String province = "河北省";
        String city = "石家庄市";
        String district = "桥西区";
        // 简码 ------ HBSJZQX

        // 将最后一个汉字截取掉
        province = province.substring(0,province.length()-1);
        city = city.substring(0,city.length()-1);
        district = district.substring(0,district.length()-1);
        String info = province+city+district;
        String[] headByString = PinYin4jUtils.getHeadByString(info);
        String shortCode = StringUtils.join(headByString);
        System.out.println(shortCode);
        // 城市编码
        String cityCode = PinYin4jUtils.hanziToPinyin(city,"");
        System.out.println(cityCode);
    }
}
