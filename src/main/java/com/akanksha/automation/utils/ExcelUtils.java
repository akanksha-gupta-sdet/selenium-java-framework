package com.akanksha.automation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;

public class ExcelUtils {

    public static Object[][] getTestData(String fileName, String sheetName) {
        try {
            InputStream inputStream = ExcelUtils.class.getClassLoader().getResourceAsStream(fileName);

            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet sheet = workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();

            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
            workbook.close();
            return data;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}