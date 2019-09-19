package test;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-16 21:40
 */
public class ValidIpAdderss {
    public static void main(String[] args) {
        String str = "127.0.0.1";
        System.out.println(validIpAdderss(str));
    }
    private static String validIpAdderss(String IP){
        if(IP ==null){

            return "Neither";
        }
        String regex0 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
        String regexIpv4 = regex0+"(\\."+regex0+"){3}";
        String regex1 = "([\\da-fA-F]{1,4})";
        String regexIpv6 = regex1+"(:"+regex1+"){7}";


        if(IP.matches(regexIpv4)){
            return  "IPv4";
        }

        if(IP.matches(regexIpv6)){
            return "IPv6";
        }
        return  "Neither";
    }
}
