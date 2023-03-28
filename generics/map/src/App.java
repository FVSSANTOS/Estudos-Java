import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        
        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Maria");
        cookies.put("email","maria@gmail.com");
        cookies.put("phone","99718654");

        cookies.remove("email");
        cookies.put("phone","99718877");

        System.out.println("ALL COOKIES:");
        for(String key : cookies.keySet()){
            System.out.println(key + ": "+cookies.get(key));
        }
    }
}
