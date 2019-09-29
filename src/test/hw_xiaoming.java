package test;

import javafx.scene.SnapshotParametersBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-25 19:27
 */
public class hw_xiaoming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int areaNums = sc.nextInt();
        int times = sc.nextInt();
        int[] areas = new int[areaNums];
        for(int i=0;i<areaNums;i++){
            areas[i] = sc.nextInt();
        }

        for(int i=0;i<times;i++){

            String str = sc.next();
            if(str.equals("Q")){
                System.out.println(getAve(areas,sc.nextInt(),sc.nextInt()));
            }else if(str.equals("U")){
                int index = sc.nextInt();
                areas[index-1] += sc.nextInt();
            }
        }

    }
    public static int getAve(int[] nums,int A,int B){
        int sum=0;
        for(int i=A-1;i<B;i++){
            sum+=nums[i];
        }
        return sum/(B-A+1);
    }

}
