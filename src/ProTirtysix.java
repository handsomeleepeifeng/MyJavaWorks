public class ProTirtysix {
    IntTreeNode head = null;
    IntTreeNode End = null;
    public IntTreeNode convert(IntTreeNode root){
        if (root == null)
            return null;
        covertCore(root);
        return head;
    }

    private void covertCore(IntTreeNode root){
        if (root == null)
            return;
        if (root.Left != null)
            covertCore(root.Left);
        if (End == null){
            head = root;
            End = root;
        }
        else{
            End.Right = root;
            root.Left = End;
            End = root;
        }
        covertCore(root.Right);
    }
}
