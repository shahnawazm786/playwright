package collections;

import java.util.List;

public class ListLambdaExample {
    public static void main(String[] args) {
        List<String> item=List.of("a","b","c","1","d","4","f","7");
        item.forEach(x->{
            if(x.equals("a")){
                System.out.println("This is A");
            }else {
                System.out.println("This is not A");
            }
        });
    }
}
