package algorithm;

/**
 * Created by apple on 2019/8/25.
 */

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution222 {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int countNodes2(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDeth(root.left);
        int right = getDeth(root.right);
        if(left==right){
            return countNodes2(root.right) + (1 << left);
        }else{
            return countNodes2(root.left) + (1 << right);
        }
    }

    private int getDeth(TreeNode root){
        int level = 0;
        while (root != null){
            level++;
            root = root.left;
        }

        return level;
    }

}

