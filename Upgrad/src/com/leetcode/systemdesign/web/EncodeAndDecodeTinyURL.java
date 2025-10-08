package com.leetcode.systemdesign.web;

//TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
//Design a class to encode a URL and decode a tiny URL.

//There is no restriction on how your encode/decode algorithm should work.
// You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
/*
Implement the Solution class:
    # Solution() Initializes the object of the system.
    # String encode(String longUrl) Returns a tiny URL for the given longUrl.
    # String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
 */

import java.util.HashMap;
import java.util.Map;

/*
Input: url = "https://leetcode.com/problems/design-tinyurl"
Output: "https://leetcode.com/problems/design-tinyurl"

Explanation:
Solution obj = new Solution();
string tiny = obj.encode(url); // returns the encoded tiny url.
string ans = obj.decode(tiny); // returns the original url after decoding it.
 */
public class EncodeAndDecodeTinyURL {
    Map<Integer, String > map = new HashMap<>();
    int counter =0;
    public static void main(String[] args) {
        input1();
        input2();
    }
    // Encodes a URL to a shortened URL.
    public  String encode(String longUrl) {
        map.put(counter, longUrl);
        return "http://tinyurl.com/"+ counter++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        System.out.println("decode map " + map);
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/","")));
    }

    static void input1(){
        EncodeAndDecodeTinyURL obj = new EncodeAndDecodeTinyURL();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        System.out.println("input1 longUrl " +longUrl);
        System.out.println("input1 map " + obj.map);
        String shortUrl = obj.encode(longUrl);
        System.out.println("input1 shortUrl " + shortUrl);
        System.out.println("input1 longUrl " + obj.decode(shortUrl));
    }

    static void input2(){

    }
}
