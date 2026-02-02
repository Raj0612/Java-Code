package com.leetcode.zothers;

public class ToLowerCase {

    public static void main(String[] args) {
        String str = "HellA";
        String result = toLowerCase(str);
        System.out.println("result " + result);
    }

    static String toLowerCase(String str){
        final int diff = 'A' - 'a';
        System.out.println("A " + (int)'A' + " a " + (int)'a');
        System.out.println("H " + (int)'H' + " h " + (int)'h');
        System.out.println("diff " + diff);
        System.out.println("H - " + (char)('H' + 32));
        System.out.println("A - " + (char)('A'- 32));


        char[] ans = str.toCharArray();

        for (int i = 0; i < ans.length; ++i)
            if (ans[i] >= 'A' && ans[i] <= 'Z'){
                System.out.println("ans[i] " + ans[i]);
                char cha = (char) ans[i];
              //  ans[i] = (char) ((int)ans[i] + diff);
                ans[i] = (char)(ans[i] - diff);
                //  ans[i] -= diff;
            }
        return new String(ans);
    }
}
