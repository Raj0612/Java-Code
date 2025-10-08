package com.practice;

public class CheckLeapYear {

    public static void main(String[] args) {
        int year = 1900;
        boolean leap = false;
        if (year % 4 == 0) {
            // if the year is century
            if (year % 100 == 0) {
                // if year is divided by 400 then it is a leap year
                if (year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            } else   // if the year is not century
                leap = true;
        } else
            leap = false;

        if (leap)
            System.out.println(year + " is a leap year.");
        else
            System.out.println(year + " is not a leap year.");
    }
}
