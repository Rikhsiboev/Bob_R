package dsa_03_CollectionsReview.Review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapReview2 {
    public static void main(String[] args) {

        Map<Integer,String> studentMap = new HashMap();
        studentMap.put(1,"Jack");
        studentMap.put(2,"Julia");
        studentMap.put(3,"Alison");

        // How to get value from a map
        List<String> list = studentMap.values().stream().collect(Collectors.toList());
        // How to get entry set

        // How to get key set

        //How to get  value and sort then




    }
}
