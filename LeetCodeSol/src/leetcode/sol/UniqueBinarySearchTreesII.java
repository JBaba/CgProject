package test;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {

        List<TreeNode> nodes = allCombo(1,3);
        for(TreeNode node:nodes){
            System.out.println(node);
        }
    }

    private static List<TreeNode> allCombo(int m,int n) {
        List<TreeNode> nodes = new ArrayList<>();
        if(m>n){
            nodes.add(null);
            return nodes;
        }
        for(int i=m;i<=n;i++){
            List<TreeNode> ls = allCombo(m,i-1);
            List<TreeNode> rs = allCombo(i+1,n);
            for(TreeNode lnode:ls){
                for(TreeNode rnode:rs){
                    TreeNode node = new TreeNode();
                    node.val = i;
                    node.left = lnode;
                    node.right = rnode;
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    @Override
    public String toString() {
        return "{" + val +
                ((left != null) ? ", l=" + left : "") +
                ((right != null) ? ", r=" + right : "") +
                '}';
    }
}
