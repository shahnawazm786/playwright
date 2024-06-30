package org.example;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ExcelReadingDataExample {
    public static void main(String[] args) {
        File excel=new File("src/main/resources/employee.xlsx");
        FileInputStream inputStream=null;
        XSSFWorkbook workbook=null;
        XSSFSheet sheet=null;
        try {
             inputStream= new FileInputStream(excel);
        }catch (FileNotFoundException exception){
            exception.printStackTrace();
            System.out.println("File not found exception "+exception.getMessage());
        }
        try{
        workbook=new XSSFWorkbook(inputStream);}catch (IOException ioException){
            ioException.printStackTrace();
            System.out.println("Reading file is difficult"+ioException.getMessage());
        }
        sheet=workbook.getSheet("Sheet1");
        Iterator<Row> rows=sheet.rowIterator();

        while(rows.hasNext()){

            Row row= rows.next();
            if(row.getRowNum()==0 | row.getRowNum()==1){
                continue;
            }
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


    }
}
