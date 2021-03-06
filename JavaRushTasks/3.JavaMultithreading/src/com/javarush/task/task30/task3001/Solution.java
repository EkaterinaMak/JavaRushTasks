package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumerationSystemType._16, "6df");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumerationSystemType._2, "120");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._8);
        System.out.println(result);
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        NumerationSystem numerationSystem = number.getNumerationSystem();
        BigInteger bigInteger;
        try {
            bigInteger = new BigInteger(number.getDigit(), numerationSystem.getNumerationSystemIntValue());
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        Number expectedNumber = new Number(expectedNumerationSystem, bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue()));
        //напишите тут ваш код
        return expectedNumber;
    }
}
