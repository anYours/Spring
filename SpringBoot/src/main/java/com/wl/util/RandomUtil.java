package com.wl.util;

import java.util.Random;

public class RandomUtil {

    public static String getRandomWithLength(int length){
        String str = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++){
            int index = getRandomNum();
            char c = chars[index];
            sb.append(c);
        }
        return sb.toString();
    }


    private static int getRandomNum(){
        Random random = new Random();
        int i = random.nextInt(60);
        return i;
    }

    public static void main(String[] args) {
        String randomWithLength = getRandomWithLength(6);
        System.out.println("args = [" + randomWithLength + "]");
    }
}
