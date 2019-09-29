package test;

import com.sun.xml.internal.xsom.impl.scd.Step;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-25 19:10
 */
public class hw_filterSensitiveWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String content = in.next();
        String senstiveWord = in.next();
        System.out.println(filterSensitiveWords("abcdefgABCDEFG()1234567","BCD"));

    }
    public static String filterSensitiveWords(String content,String senstiveWord){
        if(content==null||senstiveWord==null) return content;

        int len = senstiveWord.length();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<len;i++) sb.append('*');
        String star = sb.toString();
//        for(int i=0;i<content.length();i++){
//            if(content.substring(i,i+len).equals(senstiveWord)){
//                content = content.replace(senstiveWord,star);
//            }
//        }
        return content.replace(senstiveWord,star);
    }

}
