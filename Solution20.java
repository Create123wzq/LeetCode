import java.util.Stack;

/**
 * Created by apple on 2019/3/31.
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!stack.empty()){
                char top = stack.peek();
                stack.push(c);
                switch (c){
                    case'}':
                        if(top=='{'){
                            stack.pop();
                            stack.pop();
                        }
                        break;
                    case')':
                        if(top=='('){
                            stack.pop();
                            stack.pop();
                        }
                        break;
                    case']':
                        if(top=='['){
                            stack.pop();
                            stack.pop();
                        }
                        break;
                }
            }else{
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character> ();
        for(char c : s.toCharArray()){
            if(c=='{'){
                stack.push('}');
            }else if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}

