public class ProTwentyeight {
    public boolean isSymmertical(TreeNode root) {
        return isSymmerticalCore(root.Left,root.Right);
    }

    private boolean isSymmerticalCore(TreeNode root1,TreeNode root2){
        if (root1 == null && root2 ==null)
            return true;
        else if (root1 == null)
            return false;
        else if (root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSymmerticalCore(root1.Left,root2.Right) && isSymmerticalCore(root1.Right,root2.Left);
    }
}
