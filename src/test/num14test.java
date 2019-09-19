package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-16 21:04
 */
public class num14test {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str  = in.next();
        System.out.println(letter(str));
    }
    public static List<String>  letter(String digits){
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ans.add("");
        for(int i=0;i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length()==i){
                String t = ans.remove();
                for(char s:mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
