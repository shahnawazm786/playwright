package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ExcelReadingDataExample {
    private static final Logger log= LogManager.getLogger(ExcelReadingDataExample.class);
    public static void main(String[] args) {
        log.info("File object and employee.xlsx");
        File excel=new File("src/main/resources/employee.xlsx");
        log.info("Input stream...");
        FileInputStream inputStream=null;
        log.info("XSSFWorkbook .......");
        XSSFWorkbook workbook=null;
        log.info("XSSFSheet...");
        XSSFSheet sheet=null;
        try {
            log.info("file open input stream..");
             inputStream= new FileInputStream(excel);
             log.info("file opened input stream...");
        }catch (FileNotFoundException exception){
            log.info("file not found");
            exception.printStackTrace();
            System.out.println("File not found exception "+exception.getMessage());
            log.info("exception raised..");
        }
        try{
            log.info("workbook creation started .....");
        workbook=new XSSFWorkbook(inputStream);}catch (IOException ioException){
            log.info("problem in reading workbook...");
            ioException.printStackTrace();
            System.out.println("Reading file is difficult"+ioException.getMessage());
            log.info("exception raised and catched ......");
        }
        log.info("Reading data from sheet1");
        sheet=workbook.getSheet("Sheet1");
        log.info("Number of rows read from the sheet....");
        Iterator<Row> rows=sheet.rowIterator();
        log.info("Row iteration strated ...");
        while(rows.hasNext()){
            Row row= rows.next();
            if(row.getRowNum()==0 | row.getRowNum()==1){
                log.info("Heading skipped...");
                continue;
            }
            log.info("Reading data from cell ...");
            Iterator<Cell> cells=row.cellIterator();
            while(cells.hasNext()){
                Cell cell=cells.next();
                switch (cell.getCellType()){
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue());
                        break;
                    case STRING:
                        System.out.println(cell.getStringCellValue());
                        break;
                    case FORMULA:
                        System.out.println(cell.getCellFormula());
                        System.out.println(cell.getNumericCellValue());
                        break;
                    case _NONE:
                        System.out.println("Blank Cell");
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());
                        break;
                    case BLANK:
                        System.out.println("Blank cell");
                        break;
                    case ERROR:
                        System.out.println("Error value");
                        break;
                    default:
                        System.out.println(cell.getStringCellValue());
                }
            }
        }



        try {
            log.info("workbook closing...");
            workbook.close();
            log.info("stream closing...");
            inputStream.close();
            log.info("Input stream closed...");
            log.info("files closing...");
            excel=null;
        }catch (IOException ioException){
            log.info("Input stream exception raised while closing...");
            ioException.printStackTrace();
        }

    }
}
