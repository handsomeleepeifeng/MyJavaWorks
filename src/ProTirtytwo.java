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