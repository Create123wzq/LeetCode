import java.util.Stack;

public class Solution402 {

    public static String removeKdigits(String num, int k) {
        if(k==num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int length = num.length() - k;
        for(int i=0;i<num.length();i++){
            char c = num.charAt(i);
            while (!stack.isEmpty() && stack.peek()>c && k>0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<stack.size();i++){
            sb.append(stack.get(i));
        }
        String res = sb.toString();
        int count = 0;
        for(int i=0;i<res.length();i++){
            if(res.charAt(i)=='0'){
                count++;
            }else{
                break;
            }
        }
        return count == res.length() ? "0":res.substring(count, length);
    }
    public static void main(String[] args){
        System.out.println(removeKdigits("9", 1));
    }

}

