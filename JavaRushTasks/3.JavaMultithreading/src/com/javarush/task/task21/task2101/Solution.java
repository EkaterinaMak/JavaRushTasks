package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netmask = new byte[4];
        for (int i = 0; i<4; i++) {
            netmask[i] = (byte) (ip[i]&mask[i]);
        }
        return netmask;
    }

    public static void print(byte[] bytes) {
        for (byte b : bytes) {
            String s = Integer.toBinaryString(b);
            if (s.length()>8) {
                System.out.print(s.substring(24, 32));
                System.out.print(" ");
            }
            else {
                System.out.print(String.format("%8s", s).replaceAll("\\s", "0"));
                System.out.print(" ");
            }
        }
        System.out.println("");
    }
}
