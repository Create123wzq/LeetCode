import java.util.*;

/**
 * Created by apple on 2019/4/12.
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] inDegree = new int[numCourses];
        int m = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p:prerequisites){
            if(map.containsKey(p[1])){
                List<Integer> list = map.get(p[1]);
                list.add(p[0]);
                map.put(p[1], list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(p[0]);
                map.put(p[1], list);
            }
            inDegree[p[0]]++;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                stack.push(i);
                inDegree[i] = -1;
            }
        }
        while (!stack.isEmpty() && m<numCourses){
            int index = stack.pop();
            result[m++] = index;
            List<Integer> list = map.get(index);
            if(list!=null){
                for(int n:list){
                    inDegree[n]--;
                    if(inDegree[n]==0){
                        stack.push(n);
                        inDegree[n] = -1;
                    }
                }
            }
        }

        return m==numCourses ? result:new int[]{};
    }
}
