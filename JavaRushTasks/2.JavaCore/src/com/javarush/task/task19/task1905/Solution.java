package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer=customer;
            this.contact=contact;
        }

        @Override
        public String getCountryCode() {
            String code="";
            for (Map.Entry<String, String> map : countries.entrySet()){
                if (map.getValue().equals(this.customer.getCountryName())) {
                    code=map.getKey();
                }
            }
            return code;
        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] fio = this.contact.getName().split(",\\s");
            return fio[1];
        }

        @Override
        public String getContactLastName() {
            String[] fio = this.contact.getName().split(",\\s");
            return fio[0];
        }

        @Override
        public String getDialString() {
            String s = this.contact.getPhoneNumber().substring(1);
            String[] number = s.split("\\(");
            String[] number2 = number[1].split("\\)");
            String[] number3=number2[1].split("-");
            return "callto://+" + number[0]+number2[0] + number3[0] + number3[1] + number3[2];
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}