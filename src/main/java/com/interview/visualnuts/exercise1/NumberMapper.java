package com.interview.visualnuts.exercise1;


public class NumberMapper {
    public String toString(int number) {

        if(number % 15 == 0) {
            return "Visual Nuts";
        } else if(number % 3 == 0) {
            return "Visual";
        } else if(number % 5 == 0) {
            return "Nuts";
        }

        return String.valueOf(number);
    }
}
