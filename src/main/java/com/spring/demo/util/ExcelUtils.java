package com.spring.demo.util;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);

    public static void main(String[] args) throws Exception {
		/*List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name1", "第一个——" + i);
			map.put("name2", "第er个——" + i);
			map.put("name3", "第san个——" + i);
			list.add(map);
		}*/
        // exportExcel(list);

        File file = new File("e:\\5.xls");

        String[][] ary = getData(file, 0, 1);
        System.out.println(ary.length);

        for (String[] strings : ary) {

            for (int i = 0; i < strings.length; i++) {

                //if(strings[1].length() != 3) {

                System.out.println(strings[i]);
                //}
            }
        }
    }

    public static String[][] getData(File file, int ignoreRows, int xlsFile) throws FileNotFoundException, IOException {
        return getData(new FileInputStream(file), ignoreRows, xlsFile);
    }

    /**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     *
     * @param inputStream 读取数据的源Excel
     * @param ignoreRows  读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return 读出的Excel中数据的内容
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[][] getData(InputStream inputStream, int ignoreRows, int xlsFile) throws FileNotFoundException, IOException {


        List<String[]> result = new ArrayList<String[]>();
        int rowSize = 0;
        // 打开HSSFWorkbook
        //POIFSFileSystem fs = new POIFSFileSystem(in);
        //HSSFWorkbook wb = new HSSFWorkbook(fs);
        Workbook wb = null;
        BufferedInputStream in = null;
        try {
            if (1 == xlsFile) {
                //使用POIFSFileSystem构造HSSFWorkbook
                in = new BufferedInputStream(inputStream);
                POIFSFileSystem fs = new POIFSFileSystem(in);
                wb = new HSSFWorkbook(fs);      //解析2003
            } else {
                wb = new XSSFWorkbook(inputStream);     //解析2007
            }
        } catch (Exception e) {

            LOGGER.error("error", e);
        }

        Cell cell = null;
        for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
            Sheet st = wb.getSheetAt(sheetIndex);
            // 第一行为标题，不取
            for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
                Row row = st.getRow(rowIndex);
                if (row == null) {
                    continue;
                }
                int tempRowSize = row.getLastCellNum() + 1;
                if (tempRowSize > rowSize) {
                    rowSize = tempRowSize;
                }
                String[] values = new String[rowSize];
                Arrays.fill(values, "");
                boolean hasValue = false;
                for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                    String value = "";
                    cell = row.getCell(columnIndex);
                    if (cell != null) {

                        switch (cell.getCellTypeEnum()) {
                            case STRING:
                                value = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                    Date date = cell.getDateCellValue();
                                    if (date != null) {
                                        value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                                    } else {
                                        value = "";
                                    }
                                } else {
                                    //value = new DecimalFormat("0").format(cell.getNumericCellValue());
                                    value = cell.getNumericCellValue() + "";
                                }
                                break;
                            case FORMULA:
                                // 导入时如果为公式生成的数据则无值
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (!cell.getStringCellValue().equals("")) {
                                    value = cell.getStringCellValue();
                                } else {
                                    value = cell.getNumericCellValue() + "";
                                }
                                break;
                            case BLANK:
                                value = "";
                                break;
                            case ERROR:
                                value = "";
                                break;
                            case BOOLEAN:
                                value = cell.getBooleanCellValue() + "";
                                break;
                            default:
                                value = "";
                        }
                    }

					/*
					if (columnIndex == 0 && value.trim().equals("")) {
						break;
					}
					*/
                    //values[columnIndex] = rightTrim(value);
                    values[columnIndex] = value.trim();
                    hasValue = true;
                }
                if (hasValue) {
                    boolean flag = false;
                    for (String str : values) {
                        if (StringUtils.isNotBlank(str)) {
                            flag = true;
                        }
                    }
                    if (flag) {
                        result.add(values);
                    }
                }
            }
        }
        if (in != null) {
            in.close();
        }
        String[][] returnArray = new String[result.size()][rowSize];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = (String[]) result.get(i);
        }
        return returnArray;
    }


    /**
     * 去掉字符串右边的空格
     *
     * @param str 要处理的字符串
     * @return 处理后的字符串
     */
    public static String rightTrim(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) != 0x20) {
                break;
            }
            length--;
        }
        return str.substring(0, length);
    }

    //
    public static HSSFWorkbook exportExcel(String sheetName, List<Map<String, Object>> list, String[] titles, String[] fieldNames) {
        HSSFWorkbook wb = new HSSFWorkbook();
        try {
            HSSFSheet sheet = null;
            // 对每个表生成一个新的sheet,并以表名命名
            if (sheetName == null) {
                sheetName = "sheet1";
            }
            sheet = wb.createSheet("sheet1");
            // 设置表头的说明
            HSSFRow topRow = sheet.createRow(0);

            // 设置列宽
            // sheet.setColumnWidth((short) 0, (short) 2000);
            // sheet.setColumnWidth((short) 1, (short) 5000);
            // sheet.setColumnWidth((short) 2, (short) 5000);
            // sheet.setColumnWidth((short) 3, (short) 2000);
            // sheet.setColumnWidth((short) 4, (short) 7000);
            // sheet.setColumnWidth((short) 5, (short) 7000);
            Map<String, Map<String, String>> titleMap = new HashMap<String, Map<String, String>>();
            for (int i = 0; i < titles.length; i++) {
                //状态码转对应字符串
                if (titles[i].indexOf("#") != -1) {
                    String[] title = titles[i].split("#");
                    titles[i] = title[0];
                    Map<String, String> tempMap = new HashMap<String, String>();
                    for (int j = 1; j < title.length; j++) {
                        String[] keys = title[j].split(":");
                        tempMap.put(keys[0], keys[1]);
                    }
                    titleMap.put(i + "", tempMap);
                }
            }

            for (int i = 0; i < titles.length; i++) {
                setCellGBKValue(topRow.createCell((short) i), titles[i]);
            }

            if (list != null && list.size() > 0) {
                int k = 1;
                for (Map<String, Object> map : list) {
                    HSSFRow row = sheet.createRow(k);
                    for (int i = 0; i < fieldNames.length; i++) {
                        String value = map.get(fieldNames[i]) + "";
                        if (titleMap.get(i + "") != null) {
                            Map<String, String> tempMap = titleMap.get(i + "");
                            value = tempMap.get(value);
                        }
                        setCellGBKValue(row.createCell((short) i), value);
                    }
                    k++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wb;
    }

    //
    private static void setCellGBKValue(HSSFCell cell, String value) {
        //cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        // 设置CELL的编码信息
        //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
        if (value == null || "".equals(value) || "null".equals(value)) {
            cell.setCellValue("");
        } else {
            cell.setCellValue(value);
        }
    }

    //
    public static void export(HttpServletResponse response, HSSFWorkbook wb, String fileName) throws IOException {

        // 设置response的编码方式
        response.setContentType("application/x-msdownload");

        // 设置附加文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        OutputStream output = response.getOutputStream();
        wb.write(output);

        output.flush();
        output.close();

    }

    @Test
    public void test() {
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
        String[] titles = new String[]{"姓名", "性别", "年龄"};

        //exportExcel(String sheetName, List<Map<String, Object>> list, String[] titles, String[] fieldNames)
        exportExcel(sheetName, data, titles, fieldNames);
    }
}
