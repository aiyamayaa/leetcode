package map;

import java.util.*;

/**
 * @program: leetcode:https://leetcode-cn.com/problems/group-anagrams/
 * @description:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author: jiaxin_feng
 * @create: 2019-10-03 16:18
 */
public class m_groupAnagrams_49 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new m_groupAnagrams_49().groupAnagrams(strs));
    }

    /**
     * 89%---重要！String.valueOf(char[])
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        if(strs==null||strs.length==0) return null;
        for(String string:strs){
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if(!map.containsKey(str))
                map.put(str,new ArrayList<>());
            map.get(str).add(string);

        }
        return new ArrayList<>(map.values());

    }
}
