package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode;https://leetcode-cn.com/problems/longest-palindrome/
 *
 * @description:
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * @author: jiaxin_feng
 * @create: 2019-10-03 14:20
 */
public class m_longest_Palindrome_409 {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome("adam"));   //7
    }

    public int longestPalindrome2(String s) {
        int[] cnts = new int[58];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'A']++;
        }
        int palindrome = 0;
        for (int cnt : cnts) {
            palindrome += (cnt / 2) * 2;
        }
        if (palindrome < s.length()) {
            palindrome++;
        }
        return palindrome;
    }

    public static int longestPalindrome(String s) {
        if(s=="") return 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){

            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        int res=0;
        for(Character character:map.keySet()){
            int val = map.get(character);
            res+=val/2*2;
        }
        if(res<s.length())
            return res+1;
        return res;
    }

}
