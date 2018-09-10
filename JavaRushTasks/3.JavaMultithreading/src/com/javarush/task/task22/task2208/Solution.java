package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
     /*   Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        map.put(null, null);
        System.out.println(getQuery(map));
*/
    }
    public static String getQuery(Map<String, String> params) {
        if (params==null || params.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getKey()!=null && pair.getValue()!=null) {
                sb.append(pair.getKey() + " = " + "'" + pair.getValue() + "'" );
                sb.append(" and ");
            }
        }
        if (sb.length()<5)
            return "";
        sb.delete(sb.length()-5, sb.length());
        return sb.toString();
    }
}
