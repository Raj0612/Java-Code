package com.leetcode.systemdesign.web;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL1 {
    Map<String, String > map = new HashMap<>();
    int counter =1000001000;

    private final String chars =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        input1();
        input2();
    }
    public  String getString() {
        int c = counter;
        StringBuilder sb = new StringBuilder();
        while (c>0){
             //c--;
            int index = c%62;
            char character = chars.charAt(index);
            System.out.println("c: " + c + " character: " + character  + " index: " + index);
            sb.append(character);
            c = c/62;
        }
       return sb.toString();
    }

    public String encode(String longUrl) {
        String key = getString();
        map.put(key, longUrl);
        counter++;
        return "http://tinyurl.com/"+ key;
    }
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        System.out.println("decode map " + map);
        return map.get(shortUrl.replace("http://tinyurl.com/",""));
    }

    static void input1(){
        EncodeAndDecodeTinyURL1 obj = new EncodeAndDecodeTinyURL1();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        System.out.println("input1 longUrl " + longUrl);
        System.out.println("input1 map " + obj.map);
        String shortUrl = obj.encode(longUrl);
        System.out.println("input1 shortUrl " + shortUrl);
        System.out.println("input1 longUrl " + obj.decode(shortUrl));
    }

    static void input2(){
        EncodeAndDecodeTinyURL1 obj = new EncodeAndDecodeTinyURL1();
        String longUrl = "https://leetcode.com/problems/design-tinyurl-test";
        System.out.println("input2 longUrl " + longUrl);
        System.out.println("input2 map " + obj.map);
        String shortUrl = obj.encode(longUrl);
        System.out.println("input2 shortUrl " + shortUrl);
        System.out.println("input2 longUrl " + obj.decode(shortUrl));
    }
}
