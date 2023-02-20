package com.Bob_R.review;

import lombok.*;

@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor        // We use to assign final fields.
//@Getter
//@Setter
//@ToString
@Data
public class Student extends Person {

    private String name;
    private final int id;

//    public Student(int age, String name, int id) {
//        super(age);
//        this.name = name;
//        this.id = id;
//    }

}
