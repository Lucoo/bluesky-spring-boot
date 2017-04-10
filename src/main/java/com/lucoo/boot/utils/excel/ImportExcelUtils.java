package com.example.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @lucoo
 * @JDK1.8
 */
public class ImportExcelUtils {
    /**
     * excel导入
     *
     * @param startRow    开始读取行
     * @param startCell   开始读取列
     * @param arrLen      字段放入数组的长度
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static List<String[]> importExcel(int startRow, int startCell, int arrLen, FileInputStream inputStream) throws IOException {
        Workbook workbook = new HSSFWorkbook(inputStream);
        //目前只导入一个sheet
        List<String[]> list = new ArrayList<>();
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);

            if (sheet == null) {
                continue;
            }
            //开始读取的行列数
            int lastCellNum = sheet.getRow(startRow).getLastCellNum();

            for (int i = startRow; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String[] s = new String[arrLen];
                for (int j = startCell; j < lastCellNum; j++) {
                    s[arrLen - lastCellNum + j] = row.getCell(j).getStringCellValue();
                }
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            File file = new File("/Users/lucoo/Downloads/lucoo.xls");
            inputStream = new FileInputStream(file);
            importExcel(0, 0, 2, inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
