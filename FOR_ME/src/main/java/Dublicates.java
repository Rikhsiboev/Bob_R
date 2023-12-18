import java.util.HashSet;
import java.util.Set;

public class Dublicates  {

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "orange", "apple", "grape", "banana", "pear"};
        System.out.println(array);
        dub(array);
    }

    public static void dub(String[] arr) {
        Set<String> uniq=new HashSet<>();
        Set<String> duplicated=new HashSet<>();
        Set<String> notDuplicated=new HashSet<>();

        for(String s : arr){
            if(!uniq.add(s)){
                duplicated.add(s);
            }
        }
        for(String s : arr){
            if(!duplicated.contains(s)){
                notDuplicated.add(s);
            }
        }

        System.out.println("Uniq "+uniq);
        System.out.println("duplicated "+uniq);
        System.out.println("notDuplicated "+uniq);



    }


}
