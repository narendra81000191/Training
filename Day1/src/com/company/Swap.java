package com.company;

public class Swap {
    public static void main(String[] args) {
        int a = 10;
        int b = 79;
        int c = 78;

        System.out.println("Before swapping: a=" + a + " b=" + b + " c=" + c);

        // a, b, c -> rotate left: a<-b, b<-c, c<-a(original)
        a = a + b + c; // sum
        b = a - (b + c); // b = original a
        c = a - (b + c); // c = original b
        a = a - (b + c); // a = original c

        System.out.println("After swapping:  a=" + a + " b=" + b + " c=" + c);
    }
}
