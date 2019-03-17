import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯
 */
public class Solution17 {
    public static List<String> letterCombinations(String digits) {
        String[] str = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder("");
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        traceBack(digits, 0, sb, result, str);
        return result;
    }

    public static void traceBack(String digits, int n, StringBuilder sb, List<String> result, String[] str){
        if(n==digits.length()){
            result.add(sb.toString());
            return;
        }
        for(int i=0;i<str[digits.charAt(n)-'0'].length();i++){
            sb.append(str[digits.charAt(n)-'0'].charAt(i));
            traceBack(digits, n+1, sb, result, str);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(letterCombinations("34589").toArray()));
    }
}
