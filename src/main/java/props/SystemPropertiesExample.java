package props;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SystemPropertiesExample {
    public static void main(String[] args) throws IOException {
        Properties properties=System.getProperties();
        Set set=properties.entrySet();
        System.out.println(set.size());
        Iterator iterator= set.iterator();

        while (iterator.hasNext()){
            Map.Entry entry=(Map.Entry) iterator.next();
            System.out.println("Key =>\t"+entry.getKey() +"\tKey Value =>\t"+entry.getValue());
            properties.setProperty(entry.getKey().toString(),entry.getValue().toString());
        }
        properties.store(new FileWriter("src/main/resources/system.properties"),"System properties");
        properties.clear();

    }
}
