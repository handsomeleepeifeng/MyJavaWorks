class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(int val){
        this.val = val;
    }
}

public class ProSevenRebuildTree {
    public BinaryTreeNode RebuildTree(int[] preorder, int[] inorder){
        BinaryTreeNode Root = ConstructTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return Root;
    }

    private BinaryTreeNode ConstructTree(int[] preorder, int preStartIndex, int preEndIndex, int[] inorder, int inStartIndex, int inEndIndex){
        if (preStartIndex > preEndIndex || inStartIndex > inEndIndex){
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(preorder[preStartIndex]);
        for (int i = inStartIndex;i<=inEndIndex;i++){
            if (inorder[i]==preorder[preStartIndex]){
                root.left = ConstructTree(preorder,preStartIndex+1,preStartIndex+i-inStartIndex,inorder,inStartIndex,i-1);
                root.right = ConstructTree(preorder,preStartIndex+i-inStartIndex+1,preEndIndex,inorder,i+1,inEndIndex);
                break;
            }
        }
        return root;
    }
}
