package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TryExamples {
    public static void main(String[] args) {
        int x,y;
        x=100;
        y=0;
        try(PrintWriter printWriter=new PrintWriter(new File("src/main/resources/print.txt"))){
            printWriter.println("Hello Print Writer");
            printWriter.println("How are you?");
            printWriter.println("Where do you live?");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
