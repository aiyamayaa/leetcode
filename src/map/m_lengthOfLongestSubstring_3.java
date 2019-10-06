package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode:https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @description:无重复字符的最长子串
 * @author: jiaxin_feng
 * @create: 2019-10-04 00:24
 */
public class m_lengthOfLongestSubstring_3 {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s=="") return 0;
        Map<Character,Integer> map = new HashMap<>();
        int index = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))>=index){
                index =map.get(s.charAt(i))+1;
                map.replace(s.charAt(i),i);
            }
//            if(map.containsKey(s.charAt(i))){
//                index = Math.max(s.charAt(i),index);
//                map.replace(s.charAt(i),i+1);
//            }
            int curr = i-index+1;
            res = Math.max(res,curr);
            map.put(s.charAt(i),i);
        }
        return res;
    }
}
