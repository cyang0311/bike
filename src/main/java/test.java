import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","cy");
        map.put("id","111");
        map.put("pwd","123");

        for (String name:map.keySet()) {
            System.out.println(name+"  "+map.get(name));
        }
        System.out.println();
        System.out.println();
        for (Map.Entry<String, String> e:map.entrySet()) {
            System.out.println(e.getKey()+"  "+e.getValue());
        }

    }

}
