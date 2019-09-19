package array;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-12 18:42
 */
public class KMP {

    public static void main(String[] args) {
        String s = "111123";
        String t = "123";
        System.out.println(index_BF(s,t));
    }

    /**
     * 暴力破解法
     * @param s
     * @param t
     * @return
     */
    public static int index_BF(String s,String t){
        int i=0,j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;j++;
            }else {
                i=i-j+1;
                j=0;
            }

        }
        if(j==t.length()){
            return i-j;
        }
        return 0;
    }

    /**
     * KMP
     * @param s
     * @param t
     * @return
     */
    public static int KMP(String s,String t){

        int i=0;
        int j=0;
        int[] next = new int[t.length()];
        next[0]=-1;


        while (i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)||j==-1){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if(j>=t.length()){
            return i-j;
        }


        return 0;
    }

}
