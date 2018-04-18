package com.sh.bos.test;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author lee leeshuhua@163.com
 * @create 2018-04-16 21:01
 **/

public class POITest {

    // 使用POI解析Excel文件
    //@Test
    public void test1() throws IOException {
        String filePath = "E:\\编程学习\\北京黑马32期\\就业班\\【阶段09】物流BOS系统综合项目\\BOS-day05\\BOS-day05\\BOS-day05\\资料\\区域导入测试数据.xls";
        // 包装一个Excel文件对象
        HSSFWorkbook Workbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
        // 读取文件中第一个Sheet标签页
        HSSFSheet hssfSheet = Workbook.getSheetAt(0);
        // 遍历标签页中所有的行
        for (Row row:hssfSheet) {
            int rowNum = row.getRowNum();
            if(rowNum == 0){
                continue;
            }
            for (Cell cell:row) {
                String value = cell.getStringCellValue();
                System.out.println(value);
            }
        }
    }
}
