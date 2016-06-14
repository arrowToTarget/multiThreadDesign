package com.lewis.jvm.lecture01;

/**
 * Created by zhangminghua on 2016/5/16.
 */
public class PrintNumber {

    public static void main(String[] args) {
        printNumberAsBinaryForm(0);
        printNumberAsBinaryForm(-1);
        printNumberAsBinaryForm(-6);
        printNumberAsBinaryForm(-99);
        printNumberAsBinaryForm(-105);
        printNumberAsBinaryForm(205);
    }

    public static void printNumberAsBinaryForm(int number){
        System.out.println();
        //0x80000000 二进制表示 10000000 00000000 00000000 00000000
        //-6         二进制表示 11111111 11111111 11111111 11111010
        for (int i = 0; i < 32; i++) {
            int bit = (number & 0x80000000 >>> i)>>>(31-i);
            System.out.print(bit);
        }
    }
}
