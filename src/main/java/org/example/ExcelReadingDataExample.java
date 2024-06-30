package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;

public class ExcelReadingDataExample {
    public static void main(String[] args) {
        File excel=new File("src/main/resournces/employee.xlsx");
        FileInputStream inputStream=null;
        HSSFWorkbook workbook=null;
        try {
             inputStream= new FileInputStream(excel);
        }catch (FileNotFoundException exception){
            exception.printStackTrace();
            System.out.println("File not found exception "+exception.getMessage());
        }
        try{
        workbook=new HSSFWorkbook(inputStream);}catch (IOException ioException){
            ioException.printStackTrace();
            System.out.println("Reading file is difficult"+ioException.getMessage());
        }

    }
}
