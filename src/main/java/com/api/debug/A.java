package com.api.debug;

public class A {

    public static void main(String[] args) {
        A a1= new A();
       int val= a1.test1();
        C c1=new C();
        c1.test3();
        System.out.println(val);
    }


    public int test1(){
        B b1=new B();
        b1.test2();
        return 100;
    }



}
