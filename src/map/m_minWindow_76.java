package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode:https://leetcode-cn.com/problems/minimum-window-substring/
 * @description: 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * @author: jiaxin_feng
 * @create: 2019-10-04 01:01
 */
public class m_minWindow_76 {
    public static void main(String[] args) {
        String s ="ADOBECODEBANC";
        String t = "ABC";
//        System.out.println(s.substring(0,1));
        System.out.println(new m_minWindow_76().minWindow(s,t));
    }

    /**
     * 63.58%
     * 思路：用一个map存放t串中的字符，value为该字符出现的次数，遍历，s中出现该字符就将其在map中的个数-1
     * 如果map中每个字符的个数都<=0的时候，说明这个区间的string包含了所有的t中的字符，更新res串
     * 用滑动窗口法解决
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        String res = "";
        int index = 0;
        int min = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for(char c:t.toCharArray()) {
            if(map.containsKey(c)){
                map.replace(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.replace(c,map.get(c)-1);
                if(isOk(map)){
                    while (index<i) {
                        //如果index指的字符不在t串中，或者在t串中但是窗口内有很多的该字符，就向前移动
                        if (!map.containsKey(s.charAt(index))) {
                            index++;
                        } else if (map.get(s.charAt(index)) < 0) {
                            map.replace(s.charAt(index), map.get(s.charAt(index)) + 1);
                            index++;
                        } else {
                            break;
                        }
                    }
                    if(i-index<min){
                        min = i-index;
                        res = s.substring(index,i+1);
                    }
                }
            }
        }
        return res;
    }

    private boolean isOk(Map<Character, Integer> map) {
        for(int i:map.values()){
            if(i>0) return false;
        }
        return true;
    }
}
