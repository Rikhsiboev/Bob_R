package PrepInterview;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student_Grading {
    public static void main(String[] args) {
        List<Integer> students = Arrays.asList(73, 67, 38, 33);
        System.out.println(finalGrade(students));
    }

    public static List<Integer> finalGrade(List<Integer> students) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int each : students) {
            if (each < 38) {
                arrayList.add(each);
            } else {
                int multiplication = ((each + 4) / 5) * 5;
                if (multiplication - each < 3) {
                    arrayList.add(multiplication);
                } else {
                    arrayList.add(each);

                }
            }
        }
        return arrayList;
    }
}
