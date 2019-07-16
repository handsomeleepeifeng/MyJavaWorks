#从上到下导游二叉树
##题目
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
##思路
利用列队，来进行入队出队。可以模拟打印树。
##代码
    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.Queue;
    
    public class ProTirtytwo {
        public ArrayList<Integer> printTree(IntTreeNode root){
            if (root == null)
                return null;
            Queue<IntTreeNode> queue = new LinkedList<>();
            ArrayList<Integer> result = new ArrayList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                root=queue.remove();
                result.add(root.val);
                if (root.Left != null)
                    queue.add(root.Left);
                if (root.Right != null)
                    queue.add(root.Right);
            }
            return result;
        }
    }
    
    class IntTreeNode{
        IntTreeNode Left;
        IntTreeNode Right;
        int val;
        public IntTreeNode(int val){
            this.val = val;
        }
    }