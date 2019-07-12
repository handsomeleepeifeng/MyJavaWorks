#对称的二叉树
##题目
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，
定义其为对称的。如图所示：

![tree](../../PIC/28_1.png)
##代码
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