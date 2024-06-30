package org.example;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.zip.DataFormatException;


public class DateFormatterExample {
    private static final Logger log= LogManager.getLogger(DateFormatterExample.class);
    public static void main(String[] args) throws ParseException {
        log.info("Date format for US region");
        String us_Date="10 Jul, 2024";
        log.info("String created for date of us region");
       DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd MMM, yyyy",Locale.UK);
       log.info("date format");
       LocalDate date=LocalDate.parse(us_Date,formatter);
       log.info("date parsed");
        System.out.println(date);
        log.info("date printed");

    }
}
