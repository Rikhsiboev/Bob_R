package com.Bob_R.review;

import java.util.List;

public class MyUtils<T extends Person> {

    // Write a method that takes a list, prints each item in it and its total item count.
    public void printInfo2(List<T> list) {

        for (T item : list) {

            System.out.println(item);

        }

        System.out.println(list.size());

    }

    // Write a method that takes a list and returns the last item of the list.
    public T getLastItem(List<T> list) {
        return list.get(list.size() - 1);
    }

}
