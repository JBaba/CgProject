import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeOrderPreInPostRecursiveAndIterative {

    /// compare recursive and iterative and derive terative from recursive

    private void preorderTraversalRec (TreeNode root, List orderedList) {
        if (root == null)
            return;
        orderedList.add(root.val);
        preorderTraversalRec(root.left, orderedList);
        preorderTraversalRec(root.right, orderedList);
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        if(root == null) return returnList;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode n = stack.pop();
            returnList.add(n.val);
            if(n.right != null){ stack.push(n.right); }
            if(n.left != null){ stack.push(n.left); }
        }
        return returnList;
    }

    ////////////////////////////////////////////////////////////////////////
    
    List<Integer> result = new ArrayList<Integer>();

    public void inorderTraversalRec(TreeNode p){
        if(p.left!=null)
            inorderTraversalRec(p.left);
        result.add(p.val);
        if(p.right!=null)
            inorderTraversalRec(p.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode top = stack.peek();
            if(top.left!=null){
                stack.push(top.left);
                top.left=null;
            }else{
                result.add(top.val);
                stack.pop();
                if(top.right!=null){
                    stack.push(top.right);
                }
            }
        }
        return result;
    }

    ////////////////////////////////////////////////////////////////////////

    public void postorderTraversalRec(TreeNode p){
        if(p.left!=null)
            postorderTraversalRec(p.left);
        if(p.right!=null)
            postorderTraversalRec(p.right);
        result.add(p.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if(root==null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if(temp.left==null && temp.right==null) {
                TreeNode pop = stack.pop();
                res.add(pop.val);
            }
            else {
                if(temp.right!=null) {
                    stack.push(temp.right);
                    temp.right = null;
                }

                if(temp.left!=null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }

        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
