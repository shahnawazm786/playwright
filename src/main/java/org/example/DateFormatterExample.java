package org.example;

import com.microsoft.playwright.Page;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;



public class DateFormatterExample {
    public static void main(String[] args) throws ParseException {
        String us_Date="10 Jul, 2024";
       DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd MMM, yyyy",Locale.UK);
       LocalDate date=LocalDate.parse(us_Date,formatter);
        System.out.println(date);

    }
}
