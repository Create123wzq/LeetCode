import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution22 {

    public static void main(String args[]){
        List<String> list = generateParenthesis(4);
        for(String s: list){
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrace(list, "", 0, 0, n);
        return list;
    }
    public static void backTrace(List<String> list, String s, int left, int right, int n){
        if(s.length()==n*2){
            list.add(s);
            return;
        }
        if(left<n){
            backTrace(list, s+"(", left+1, right, n);
        }
        if(right<left){
            backTrace(list, s+")", left, right+1, n);
        }
    }
}