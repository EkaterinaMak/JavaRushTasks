package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber==null || telNumber=="")
            return false;
        if (telNumber.toLowerCase().matches(".*[a-z].*") )
            return false;
        if (!telNumber.matches(".*[0-9]"))
            return false;

        if (telNumber.startsWith("+") && telNumber.replaceAll("\\D", "").length()!=12)
            return false;
        if ((telNumber.startsWith("(") && telNumber.replaceAll("\\D", "").length()!=10) || (telNumber.matches("[0-9].*") && telNumber.replaceAll("\\D", "").length()!=10))
            return false;

        if (telNumber.contains("-")) {
            int count=0;
            if (telNumber.charAt(0)=='-')
                count++;
            for (int i = 1; i < telNumber.length(); i++) {
                if (telNumber.charAt(i)=='-') {
                    count++;
                    if (telNumber.charAt(i-1)=='-')
                        return false;
                }
            }
            if (count>2)
                return false;
        }

        if (telNumber.contains("(") || telNumber.contains(")")) {
            int start=0;
            if (telNumber.charAt(0)==')') {
                return false;
            } else if (telNumber.charAt(0)=='(') {
                if (!telNumber.matches("\\(\\d\\d\\d\\).*")) {
                    return false;
                } else if (telNumber.substring(5).contains("(") || telNumber.substring(5).contains(")")) {
                    return false;
                } else
                    return true;
            }
            for (int i = 1; i < telNumber.length(); i++) {
                if (telNumber.charAt(i)=='-' || telNumber.charAt(i)==')')
                    return false;
                if (telNumber.charAt(i)=='(') {
                    if (!telNumber.substring(i, i+5).matches("\\(\\d\\d\\d\\)"))
                        return false;
                    else if (telNumber.substring(i+5).contains("(") || telNumber.substring(i+5).contains(")"))
                        return false;
                    else
                        return true;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
    /*    String[] s = {
                "",
                "+380501234567",
                "+38(050)1234567",
                "+38050123-45-67",
                "050123-4567",
                "+38)050(1234567",
                "+38(050)1-23-45-6-7",
                "050ххх4567",
                "0501236",
                "(0)501234567",
                "+38(050)1-23-45--6-7",
                "+3-8(050)1-23-45--6-7",
                "+38050123-4567-"
        };

        for (String t : s) System.out.printf("%25s :   %5s %n",t,checkTelNumber(t)); */
        /*
        System.out.println(checkTelNumber("050123-45679"));
        System.out.println(checkTelNumber("050XXX4567"));
        System.out.println(checkTelNumber("012345-45666-"));


        System.out.println("Good news everyone!".matches(".*news.*"));
        System.out.println("Good news everyone!".replaceAll("e.","EX"));
        */
    }
}
