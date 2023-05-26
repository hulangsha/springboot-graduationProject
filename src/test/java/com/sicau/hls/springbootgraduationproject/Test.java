package com.sicau.hls.springbootgraduationproject;

import java.lang.Math;

public class Test {
    public static void main(String[] args) {
        Judge();
    }
    public static void Judge(){
        for(Long i=9L;i<=1000;i++){
            Long number=i*i;
            int count=0;
            while(number!=0){
                number=number/10;
                count++;
            }
            for(int j=1;j< count;j++){
                int left;
                int right;
                left = (int)(i*i);
                right = left % (int)(Math.pow(10,j));
                left = left / (int)(Math.pow(10,j));
                if((left+right)*(left+right)==i*i){
                    System.out.println("雷劈数为：" + (i*i));
                }
            }
        }

    }
}

