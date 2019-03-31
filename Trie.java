/**
 * Created by apple on 2019/3/20.
 */
public class Trie {
    boolean isStr;
    Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isStr = false;
        next = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        int n = words.length;
        int i = 0;
        while (i<n){
            if(node.next[words[i]-'a']==null){
                Trie newNode = new Trie();
                node.next[words[i]-'a'] = newNode;
            }
            node = node.next[words[i]-'a'];
            i++;
        }
        node.isStr = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        int n = words.length;
        int i = 0;
        while (i<n&&node!=null){
            node = node.next[words[i]-'a'];
            i++;
        }
        return node!=null && node.isStr;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        char[] words = prefix.toCharArray();
        int n = words.length;
        int i = 0;
        while (i<n&&node!=null){
            node = node.next[words[i]-'a'];
            i++;
        }
        return node!=null;
    }

    public static void main(String[] args){
        Trie obj = new Trie();
        obj.insert("hdhd");
        boolean param_2 = obj.search("hdhd");
        boolean param_3 = obj.startsWith("h");
        System.out.println(param_2);
        System.out.println(param_3);
    }
}
