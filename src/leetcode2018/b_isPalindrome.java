package leetcode2018;

/**
 * @program: leetcode125
 * 执行用时 ：7 ms, 在所有 Java 提交中击败了90.98%的用户
 * @description: 验证回文串
 * @author: jiaxin_feng
 * @create: 2019-09-24 20:46
 */
public class b_isPalindrome {
    public static void main(String[] args) {
        String string = "0P";
        System.out.println(string.toLowerCase());

        System.out.println(isPalindrome(string));
    }

    public static boolean isPalindrome(String s) {
        String sss = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<sss.length();i++){
            char a = sss.charAt(i);
            if((a>='a'&&a<='z')||(a>='0'&&a<='9')){
                sb.append(a);
            }
        }
        char[] ss = sb.toString().toCharArray();
        int i = 0;
        int j = ss.length-1;
        while (i<=j){
            if(ss[i]!=ss[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
