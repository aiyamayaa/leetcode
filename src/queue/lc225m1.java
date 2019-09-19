package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description:用队列实现栈
 * @author: jiaxin_feng
 * @create: 2019-09-10 13:59
 */
public class lc225m1 {
    public class stack{

        Queue<Integer> inQueue = null;
        Queue<Integer> outQueue = null;
        public stack(){
            inQueue = new LinkedList<>();
            outQueue = new LinkedList<>();
        }


        public void push(int in){
            inQueue.offer(in);
        }

        public int  pop(){
            if (outQueue == null){
                while (inQueue.peek()!= null){
                    outQueue.offer(inQueue.poll());

                }
            }
            if(outQueue!=null){
                return outQueue.poll();
            }
            return 0;
        }

        public int top(){
            if(outQueue!=null){
                return outQueue.peek();
            }else {
                while (inQueue.peek()!=null){
                    outQueue.offer(inQueue.poll());
                }
                return outQueue.peek();
            }

        }

    }



}
