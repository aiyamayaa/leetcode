package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode:https://leetcode-cn.com/problems/repeated-dna-sequences/
 * @description:重复的DNA序列
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * @author: jiaxin_feng
 * @create: 2019-10-04 00:41
 */
public class m_findRepeatedDnaSequences_187 {
    /**
     * 90.87%
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()<=10){return res;}

        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<s.length()-9;i++){
            String string = s.substring(i,i+10);
            if(map.containsKey(string)){
                if(map.get(string)==2) continue;
                res.add(string);
                map.replace(string,2);
            }else {
                map.put(string, 1);
            }

        }
        return res;
    }
}
