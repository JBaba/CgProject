import java.util.*;

public class TreeVerticalOrder {

    public static void main(String[] args) {
        p13.TreeNode node = new p13.TreeNode(5);
        node.left = new p13.TreeNode(4);
        node.right = new p13.TreeNode(6);
        node.left.left = new p13.TreeNode(3);
        node.left.right = new p13.TreeNode(51);
        node.right.left = new p13.TreeNode(52);
        node.right.right = new p13.TreeNode(7);
        System.out.println(node);

        Map<Integer,List<Integer>> map = new HashMap<>();
        verticalOrderRecNotOrdered(node,map,0);
        // order the map if needed
        System.out.println(map);
        System.out.println("================");
        Map<Integer,List<Integer>> res = verticalOrderItMapNotOrdered(node);
        System.out.println(res);

        System.out.println("================");
        List<List<Integer>> res1 = verticalOrderIt(node);
        System.out.println(res1);
    }

    private static List<List<Integer>> verticalOrderIt(TreeNode node) {
        LinkedList<Integer> order = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(node);
        order.add(0);

        /**
         *  int[] mm = new int[2];
            getMinMax(root, mm, 0);
         */

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (!q.isEmpty()){
            TreeNode head = q.removeFirst();
            int level = order.removeFirst();
            min = Math.min(level,min);
            max = Math.max(level,max);
            if(head.left != null) {
                q.add(head.left);
                order.add(level-1);
            }
            if(head.right != null) {
                q.add(head.right);
                order.add(level+1);
            }
        }

        int len = max-min+1;
        System.out.println("Min:"+min);
        System.out.println("Max:"+max);
        System.out.println("Len:"+len);

        LinkedList<List<Integer>> results = new LinkedList<>();
        for(int i=0;i<len;i++){
            results.add(new ArrayList<>());
        }

        q.add(node);
        order.add(0);

        while (!q.isEmpty()){
            TreeNode head = q.removeFirst();
            int level = order.removeFirst();
            results.get(len+level+min-1).add(head.val);
            if(head.left != null) {
                q.add(head.left);
                order.add(level-1);
            }
            if(head.right != null) {
                q.add(head.right);
                order.add(level+1);
            }
        }
        return results;
    }

    private void getMinMax(TreeNode node, int[] mm, int order){
        if(node == null){
            return;
        }

        mm[0] = Math.min(mm[0], order);
        mm[1] = Math.max(mm[1], order);

        getMinMax(node.left, mm, order-1);
        getMinMax(node.right, mm, order+1);
    }

    private static Map<Integer,List<Integer>> verticalOrderItMapNotOrdered(TreeNode node) {
        LinkedList<Integer> order = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(node);
        order.add(0);
        Map<Integer,List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            TreeNode head = q.removeFirst();
            int level = order.removeFirst();
            if(map.get(level) == null)
                map.put(level,new ArrayList<>());
            map.get(level).add(head.val);
            min = Math.min(level,min);
            if(head.left != null) {
                q.add(head.left);
                order.add(level-1);
            }
            if(head.right != null) {
                q.add(head.right);
                order.add(level+1);
            }
        }
        System.out.println("Min:"+min);
        // do ordering from min value
        return map;
    }


    private static void verticalOrderRecNotOrdered(TreeNode node, Map<Integer, List<Integer>> map, int i) {
        if(node == null) return;
        if(map.get(i) == null)
            map.put(i,new ArrayList<>());
        map.get(i).add(node.val);
        // keep track of minimum for ordering
        verticalOrderRecNotOrdered(node.left,map,i-1);
        verticalOrderRecNotOrdered(node.right,map,i+1);
    }




    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        @Override
        public String toString() {
            return "{" + val +
                    ((left != null) ? ", l=" + left : "") +
                    ((right != null) ? ", r=" + right : "") +
                    '}';
        }
    }
}



