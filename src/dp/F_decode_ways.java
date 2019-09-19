package dp;

/**
 * @program: leetcode
 * https://www.lintcode.com/problem/decode-ways/description
 * @description: 对一串数字进行编码，其中1代表A，2代表B，26代表26。给一个数字组成的字符串，求有多少种解码方式？
 * @author: jiaxin_feng
 * @create: 2019-09-13 19:06
 */
public class F_decode_ways {
    public static void main(String[] args) {
        String s = "12";
        String s1 = "192611";
        System.out.println(numDecodings2(s1));
    }


    /**
     * 思路：ways[i] += ways[i-1]；（i 位置为可解码的数字，不为0）
     *      ways[i] += ways[i-2];（i-1,i-2位置为可解码的数字 0<s[i-2]<3,0<=s[i-1]<6]）
     * @param s：编码以后的由数组组成的字符串
     * @return：编码的方式
     */
    public static int numDecodings(String s) {
        if(s.equals(null)||s.length()==0||s.charAt(0)=='0') return 0;

        int len = s.length();
        int[] ways= new int[len+1];
        ways[0] = 1; ways[1] = 1;
        for(int i=1;i<len;i++){
            ways[i+1] = 0;
            int now = s.charAt(i)-'0';
            int pre = s.charAt(i-1)-'0';
            if(now>=1&&now<=9){
                ways[i+1]+=ways[i];
            }
            int t = pre*10+now;
            if(t>=10&&t<=26){
                ways[i+1]+=ways[i-1];
            }
        }
        return ways[len];
    }



    public static int numDecodings2(String s) {
        if(s.equals(null)||s.length()==0||s.charAt(0)=='0') return 0;

        char[] ss = s.toCharArray();
        int len = ss.length;
        int[] ways= new int[len+1];
        ways[0] = 1; ways[1] = 1;
        for(int i=1;i<len;i++){
            ways[i+1] = 0;
            int now = ss[i]-'0';
            int pre = ss[i-1]-'0';
            if(now>=1&&now<=9){
                ways[i+1]+=ways[i];
            }
            int t = pre*10+now;
            if(t>=10&&t<=26){
                ways[i+1]+=ways[i-1];
            }
        }
        return ways[len];
    }
}
