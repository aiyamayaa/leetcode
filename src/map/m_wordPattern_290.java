package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 单词规律：https://leetcode-cn.com/problems/word-pattern/
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * @author: jiaxin_feng
 * @create: 2019-10-03 16:04
 */
public class m_wordPattern_290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "a b b a";
        System.out.println(wordPattern(pattern,str));
    }

    /**
     * 100%
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str) {
        str+=" ";
        Map<Character,String> map = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] strings = str.split(" ");
        if(chars.length!=strings.length)
            return false;
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                if(!map.get(chars[i]).equals(strings[i])){
                    return false;
                }
            }else if(map.containsValue(strings[i])){
                return false;
            } else {
                map.put(chars[i],strings[i]);
            }
        }
        return true;
    }
}
