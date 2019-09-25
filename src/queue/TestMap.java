package queue;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: leetcode
 * @description:
 * @author: jiaxin_feng
 * @create: 2019-09-22 11:21
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new ConcurrentHashMap<>();
        map.put(1,1);
    }
}
