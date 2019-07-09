#根据前序数列和中序数列重构二叉树
##题目
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的
结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列
{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
##代码
    public class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int val){
            this.val = val;
        }
    }
    
    public class ProSevenRebuildTree {
        public BinaryTreeNode RebuildTree(int[] preorder, int[] inorder){
            BinaryTreeNode root = ConstructTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
            return root;
        }
        /***使用递归的思想重构二叉树的核心函数***/
        private BinaryTreeNode ConstructTree(int[] preorder, int preStartIndex, int preEndIndex, int[] inorder, int inStartIndex, int inEndIndex){
            if (preStartIndex > preEndIndex || inStartIndex > inEndIndex){
                return null;
            }
            BinaryTreeNode root = new BinaryTreeNode(preorder[preStartIndex]);
            for (int i = inStartIndex;i<=inEndIndex,i++){
                if (inorder[i]==preorder[preStartIndex]){
                    root.left = ConstructTree(preorder,preStartIndex+1,preStartIndex+i-inStartIndex,inorder,inStartIndex,i-1);
                    root.right = ConstructTree(preorder,preStartIndex+i-inStartIndex+1,preEndIndex,inorder,i+1,inEndIndex);
                    break;
                }
            }
            return root;
        }
    }
