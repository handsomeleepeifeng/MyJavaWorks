#二叉树的镜像
##题目
操作给定的二叉树，将其变换为源二叉树的镜像。
#思路
递归
##代码
    public class ProTwentysiven {
        public void mirrorTree(TreeNode Root){
            if (Root == null)
                return;
            if (Root.Left == null && Root.Right == null)
                return;
            if (Root.Right == null){
                Root.Right = Root.Left;
                Root.Left = null;
                mirrorTree(Root.Right);
            }
            else if (Root.Left == null){
                Root.Left = Root.Right;
                Root.Right = null;
                mirrorTree(Root.Left);
            }
            else {
                TreeNode Temp = Root.Left;
                Root.Left = Root.Right;
                Root.Right = Temp;
                mirrorTree(Root.Left);
                mirrorTree(Root.Right);
            }
                
        }
    }