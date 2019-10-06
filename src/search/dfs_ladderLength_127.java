package search;

import java.util.*;

/**
 * @program: leetcode:127
 * @description:
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiaxin_feng
 * @create: 2019-10-05 17:05
 */
public class dfs_ladderLength_127 {
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        String[] wordList = {"hot","dog"};
//        System.out.println(new dfs_ladderLength_127().isOk("hit","hot"));
        List<String> list = Arrays.asList(wordList);
        System.out.println(new dfs_ladderLength_127().ladderLength(beginWord,endWord,list));

    }

    /**
     * 43.7%
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        int res = 0;
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        List<String> myWordList = new ArrayList<>(wordList);

        while (!list.isEmpty()){
            res++;
            List<String> li = new ArrayList<>(list);
            myWordList.removeAll(list);
            list.removeAll(list);
            for(String str:li){
                if(str.equals(endWord)) return res;
                for(int i=myWordList.size()-1;i>=0;i--){
                    if(isOk(str,myWordList.get(i))){
                        list.add(myWordList.get(i));
                        myWordList.remove(i);
                    }
                }

            }
        }
        return 0;
    }

    private boolean isOk(String str, String s) {
        if(str.equals(s)||str.length()!=s.length())
            return false;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(!(s.charAt(i)==str.charAt(i))){
                res++;
            }
        }
        return res==1;
    }
}
