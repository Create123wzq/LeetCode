/**
 * Created by apple on 2019/4/12.
 */
public class Solution211 {
    private class WordDictionary {
        Node root;
        private class Node{
            boolean isEnd;
            Node[] next;
            Node(){
                this.isEnd = false;
                next = new Node[26];
            }
        }
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node node = root;
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(node.next[index]==null){
                    node.next[index] = new Node();
                }
                node = node.next[index];
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return helper(word, 0, root);
        }
        public boolean helper(String word, int start, Node node){
            boolean flag = false;
            if(node==null){
                return false;
            }
            if(start==word.length()){
                return node.isEnd;
            }
            char c = word.charAt(start);
            if(c=='.'){
                for(int i=0;i<26;i++){
                    flag |= helper(word, start+1, node.next[i]);
                }
            }else{
                flag = helper(word, start+1, node.next[c-'a']);
            }
            return flag;
        }
    }

}
