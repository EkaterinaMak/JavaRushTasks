package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileReader in = new FileReader(file);
        String s="";
        while (in.ready()) {
            char c = (char) in.read();
            s += c;
        }
        in.close();
        String tag = args[0];
        String start = "<"+tag+"[\\s\\r\\n>]";
        String end = "/"+tag+">";
//s=s.replaceAll("\\r\\r\\n", "");
 //       matcher(s, start, end);

        //cоздаю 2 листа с индексами начала и конца строк
        ArrayList<Integer> listEnd = new ArrayList<>();
        ArrayList<Integer> listStart = new ArrayList<>();

        // ругулярка определяет или тег открытия, или тег закрытия. (<tag someText> | </tag>)
       // String regExp= "<"+args[0]+"?[[[a-zA-Z_0-9][ \\t\\n\\x0B\\f\\r]][^>]]+>|</"+args[0]+">";
        String regExp="<" + args[0] + "|</" + args[0] + ">";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(s);
        while (m.find()) { //
            if (m.group().equals("</"+args[0]+">")){ //если тег закрытия
                listEnd.add(m.end()); //заношу индекс конца сторки
            }
            else {
                listStart.add(m.start()); // если тег открытия заношу индекс начала строки
            }
            if(listStart.size()==listEnd.size()&& listStart.size()>0){ // если количество тегов открытия,закрытия равно
                while(listStart.size()!=0){ //печатаем выражения беря индексы начала и конца, снимаем обвертки удаляя начальные и конечные индексы.
                    System.out.println(s.substring(listStart.get(0),listEnd.get(listEnd.size()-1)));
                    listStart.remove(0);
                    listEnd.remove(listEnd.size()-1);//соответсвенно в конце получаем пустой список
                }
            }
        }




/*
        ArrayList<String> list = new ArrayList<>();
        String[] ar = s.split("<"+tag+"[\\s>]");
        int n;
        if (s.startsWith("<"+tag+"[\\s>]")) {
            n = 0;
        } else {
            n=1;
        }
        for (int i=n; i<ar.length; i++) {
            int count = 0;
            int countStart = 1;
            if (ar[i].contains("<"+tag+">")) {

            }
        }
*/
    }
    /*
    public static void matcher(String input, String start, String end) {
        Pattern p = Pattern.compile("(" + start + ".*?" + "(("+start+".*"+end+").*?)*?" + end + ")");
        Matcher m = p.matcher(input);
        String line;
        while (m.find()){
            line = m.group();
            System.out.println(line);
            if (m.group(2)!=null) {
                matcher(m.group(2), start, end);
            }
        }
    } */
}
