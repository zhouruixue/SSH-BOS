package com.sh.bos.web.action;

import com.sh.bos.domain.Region;
import com.sh.bos.service.RegionService;
import com.sh.bos.utils.PinYin4jUtils;
import com.sh.bos.web.action.base.BaseAction;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 区域管理
 * @author lee leeshuhua@163.com
 * @create 2018-04-15 20:56
 **/
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {

    @Autowired
    private RegionService regionService;
    // 属性驱动后，接收上传文件
    private File regionFile;

    public void setRegionFile(File regionFile) {
        this.regionFile = regionFile;
    }

    /**
     * 区域导入
     */
    public String importXls() throws IOException {
        List<Region> regionList = new ArrayList<Region>();
        // 使用POI解析Excel文件
        HSSFWorkbook Workbook = new HSSFWorkbook(new FileInputStream(regionFile));
        // 根据名称获得指定Sheet对象
        HSSFSheet hssfSheet = Workbook.getSheetAt(0);
        for (Row row:hssfSheet) {
            int rowNum = row.getRowNum(); // 行号
            if(rowNum == 0){
                continue;
            }
            String id = row.getCell(0).getStringCellValue();
            String province = row.getCell(1).getStringCellValue();
            String city = row.getCell(2).getStringCellValue();
            String district = row.getCell(3).getStringCellValue();
            String postcode = row.getCell(4).getStringCellValue();
            // 包装一个区域对象
            Region region = new Region(id, province, city, district, postcode, null, null, null);

            province = province.substring(0,province.length()-1);
            city = city.substring(0,city.length()-1);
            district = district.substring(0,district.length()-1);
            String info = province+city+district;
            String[] headByString = PinYin4jUtils.getHeadByString(info);
            String shortCode = StringUtils.join(headByString);
            // 城市编码
            String cityCode = PinYin4jUtils.hanziToPinyin(city,"");
            region.setShortcode(shortCode);
            region.setCitycode(cityCode);
            // 放入集合
            regionList.add(region);
        }
        regionService.saveBatch(regionList);
        return NONE;
    }

    /**
     * 分页查询
     */
    public String pageQuery() throws IOException {
        regionService.pageQuery(pageBean);
        this.java2Json(pageBean,new String[]{"currentPage","detachedCriteria","pageSize","subareas"});
        return NONE;
    }

    // 输入框的值
    private String q;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    /**
     * 查询所有区域，返回json数据
     * @return
     */
    public String listAjax(){
        List<Region> list = null;
        // 如果输入条件为空查询所有，不为空按条件查询
        if(StringUtils.isNotBlank(q)){
            list = regionService.findListByQ(q);
        }else{
            list = regionService.findAll();
        }
        this.java2Json(list,new String[]{"currentPage","detachedCriteria","pageSize","subareas"});
        return NONE;
    }

}
