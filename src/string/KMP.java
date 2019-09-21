package string;

/**
 * @program: 字符串的匹配
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-17 15:32
 */
public class KMP {
    public static void main(String[] args) {

        String s = "mississippi";
        String p = "issip";
//        System.out.println(getFirstMatch(s,p));
        IOTools.print(kmpNext2(p));
//        IOTools.print(KMP(s,p));

        System.out.println(strStr2(s,p));
    }

    public static int strStr2(String s,String p){
        if(p.length()==0) return 0;
        for(int i=0;i<s.length()-p.length()+1;i++){
            if(s.substring(i,i+p.length()).equals(p)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 求next数组
     * @param p
     * @return
     */
    public static int[] kmpNext2(String p){
        char[] pp = p.toCharArray();
        int[] next = new int[pp.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < p.length() - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * 求next数组:自己的写法
     * @param p
     * @return
     */
    public static int[] kmpNext(String p){
        char[] pp = p.toCharArray();
        int[] next = new int[pp.length];

        next[0] = -1;
        for(int j=1;j<pp.length;j++){
            int max = 0;
            for(int m=j-1;m>0;m--){
                int i=0,curr=-1,k=m;
                while (k<j && pp[i]==pp[k]){
                    i++;
                    k++;
                    curr++;
                }
                if(k==j){
                    max = curr;
                }
            }
            next[j] = max;
        }
        return next;
    }

    /**
     * KMP
     * @param s
     * @param p
     * @return
     */
    public static int KMP(String s,String p){
        int[] next = kmpNext(p);
        char[] pp = p.toCharArray();
        char[] ss = s.toCharArray();
        int i=0,j=0;
        while(i<ss.length && j<pp.length){
            if(j==-1){
                i++;j++;
            }
            while(i<ss.length && j<pp.length && ss[i]==pp[j]){
                i++;
                j++;
            }
            if(j==pp.length){
                return i-j;
            }else {
                j=next[j];
            }
        }
        return -1;

    }


    /**
     * 暴力解法
     * @param s 长的字符串
     * @param p 短的字符串
     * @return 找出p在s中第一次出现的位置，如果没有返回-1
     */
    public static int getFirstMatch(String s,String p){


        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int i=0;
        int j=0;
        while (i<ss.length && j<pp.length) {
            while (j < pp.length && i < ss.length && pp[j] == ss[i]) {
                j++;
                i++;
            }
            if (j >= pp.length) {
                return i - j;
            } else {
                i = i - j + 1;
                j = 0;

            }
        }
        return -1;

    }


}
