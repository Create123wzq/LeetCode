package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class LRUCache {

    Map<Integer, Integer> map;
    Stack<Integer> stack;
    int capacity;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.stack = new Stack<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.get(key) == null){
            return -1;
        }else{
            stack.remove(Integer.valueOf(key));
            stack.push(key);
            //System.out.println(stack);
            return map.get(key);
        }

    }

    public void put(int key, int value) {
        if(map.get(key)!=null){
            get(key);
            map.put(key, value);
        }else if(map.size()==capacity){
            map.remove(stack.get(0));
            stack.remove(0);
            map.put(key, value);
            stack.push(key);
        }else{
            map.put(key, value);
            stack.push(key);
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
