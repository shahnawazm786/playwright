package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WritingDataIntoExcel {
    private static final Logger log= LogManager.getLogger(ExcelReadingDataExample.class);
    public static void main(String[] args) throws IOException {
        log.info("Writing data into excel..... Sheet name - LoginData");
        File file=new File("src/main/resources/testdata.xlsx");
        log.info("First create blank workbook");
        XSSFWorkbook workbook=new XSSFWorkbook();
        log.info("Next create worksheet");
        XSSFSheet sheet=workbook.createSheet("LoginData");
        log.info("Create row object ......");
        XSSFRow row;
        log.info("Creating data of login .....");
        Map<String, Object[]> loginData=new HashMap<>();
        loginData.put("1",new Object[]{"RowNum","UserName","Password"});
        loginData.put("2",new Object[]{"1","Admin","Admin@123#"});
        loginData.put("2",new Object[]{"2","Supervisor","Supervisor@123#"});
        loginData.put("2",new Object[]{"3","Sales","Sales@123#"});
        loginData.put("2",new Object[]{"4","SalesAdmin","SalesAdmin@123#"});
        loginData.put("2",new Object[]{"5","SuperAdmin","SuperAdmin@123#"});
        loginData.put("2",new Object[]{"6","DBAdmin","DBAdmin@123#"});
        loginData.put("2",new Object[]{"7","Clerk","Clerk@123#"});
        loginData.put("2",new Object[]{"8","HR","HR@123#"});
        loginData.put("2",new Object[]{"9","HRAdmin","HRAdmin@123#"});
        log.info("Iterate data and write into sheet of the workbook");
        Set<String> rowsData=loginData.keySet();
        int rowID=0;
        for(String Key:rowsData){
            row=sheet.createRow(rowID++);
            Object[] LoginDataObject=loginData.get(Key);
            int cellId=0;
            for(Object obj:LoginDataObject){
                Cell cell= row.createCell(cellId++);
                cell.setCellValue((String)obj);
            }
        }
        log.info("Write the book into file .....");
        FileOutputStream outputStream=new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        log.info("Excel file created ..........");

    }
}
