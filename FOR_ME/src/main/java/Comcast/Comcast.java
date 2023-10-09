package Comcast;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Comcast {
    private String data[] = {"rejith#kumar#c++#java#csharp",
            "robert#holland#scala#python#java",
            "kevin#john#scala"};

    public List<String> myList(String[] data) {
        String word = "java";

        return Arrays.stream(data)
                .filter(skill -> skill.contains(word))
                .map(text -> {
                    String[] splitParts = text.split("#");
                    return String.join(" ", splitParts);
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Comcast example = new Comcast();
        List<String> filteredList = example.myList(example.data);
        for (String entry : filteredList) {
            System.out.println(entry);
        }
    }
}














