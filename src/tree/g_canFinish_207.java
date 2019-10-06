package tree;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description: 课程表
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 *
 *
 *
 */
public class g_canFinish_207 {
    /**
     * 不是自己写的,48,15%
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] visited = new int[numCourses];
        for(int[] p:prerequisites){
            graph[p[1]][p[0]] = 1;
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(graph,visited,i)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] visited,int i) {
        if(visited[i]==1) return false;
        if(visited[i]==-1) return true;
        visited[i] = 1;
        for(int j=0;j<graph[i].length;j++){
            if(graph[i][j]==1&&!dfs(graph,visited,j)) return false;
        }
        visited[i] = -1;
        return true;
    }


    /**
     * 不是自己写的方法2
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[numCourses];
        for (int i = 0;i < numCourses;i++){
            G[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites){
            G[pre[0]].add(pre[1]);
        }
        int[] isVisited = new int[numCourses];//用于判断每个节点的状态：未被DFS访问:0;已被其他节点启动的DFS访问:-1;已被当前节点启动的DFS访问:1。
        for (int i = 0;i < numCourses;i++){
            if (hasCycle(G,isVisited,i))
                return false;
        }
        return true;
    }
    private boolean hasCycle(ArrayList<Integer>[] G,int[] isVisited,int index){
        if (isVisited[index] == 1)//在本轮DFS搜索中节点被第2次访问，即图有环，直接返回true
            return true;
        if (isVisited[index] == -1)//当前访问节点已被其他节点启动的DFS访问，无需再重复搜索，直接返回false
            return false;
        isVisited[index] = 1;
        for (int next : G[index]){
            if (hasCycle(G,isVisited,next))//递归访问当前节点的所有邻接节点，当发现环直接返回true
                return true;
        }
        isVisited[index] = -1;//当前节点所有邻接节点已被遍历，并没有发现环，则将当前节点置为−1并返回false
        return false;
    }
}
