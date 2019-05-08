package com.spring.demo.controller;

import com.spring.demo.util.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExcelDemo {

    @GetMapping("toExcelDemo")
    public String toExcelDemo() {
        return "excelDemo";
    }

    @GetMapping("excelExportDemo")
    @ResponseBody
    public void excelExportDemo(HttpServletResponse responsea) throws IOException {
        String sheetName = "sheet1";
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map = null;
        for (int i = 1; i < 3; i++) {
            map = new HashMap<>();
            map.put("name", "test" + i);
            map.put("sex", i % 2 == 0 ? "男" : "女");
            map.put("age", 20 + i);
            data.add(map);
        }

        //对应map的keys
        String[] fieldNames = new String[]{"name", "sex", "age"};

        //表头
        String[] titles = new String[]{"姓名", "性别", "年龄"};

        //exportExcel(String sheetName, List<Map<String, Object>> list, String[] titles, String[] fieldNames)
        HSSFWorkbook wb = ExcelUtils.exportExcel(sheetName, data, titles, fieldNames);
        ExcelUtils.export(responsea, wb, "test.xls");
    }

    @GetMapping("excelExportDemo2")
    @ResponseBody
    public void excelExportDemo2(HttpServletResponse responsea) throws IOException {
        String sheetName = "sheet1";
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map = null;
        for (int i = 1; i < 3; i++) {
            map = new HashMap<>();
            map.put("name", "test" + i);
            map.put("sex", i % 2 == 0 ? "男" : "女");
            map.put("age", 20 + i);
            data.add(map);
        }

        String[] fieldNames = new String[]{"name", "sex", "age"};
        String[] titles = new String[]{"姓名", "性别#男:1#女:0", "年龄"};

        //exportExcel(String sheetName, List<Map<String, Object>> list, String[] titles, String[] fieldNames)
        HSSFWorkbook wb = ExcelUtils.exportExcel(sheetName, data, titles, fieldNames);
        ExcelUtils.export(responsea, wb, "test.xls");
    }
}
