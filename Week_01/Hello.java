package com.ty.demo;

public class Hello {
    public int bar(int i){
        return ((i+3)-2) * 3 /4;
    }
    public static void main(String args[]){
        Hello obj = new Hello();
        for(int j=0;;j++){
            if(j< 3){
             obj.bar(5);
            }
        }
    }
}
