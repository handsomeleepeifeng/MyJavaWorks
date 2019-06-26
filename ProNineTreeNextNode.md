#二叉树的下一个节点
##题目
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包
含左右子结点，同时包含指向父结点的指针。
##分析
 中序遍历顺序为：左，中，右

情况分为以下几种情况：

1.节点为空，那么返回空；

2.如果当前节点有右子树，则返回右子树的最左子树；

3.如果当前节点没有右子树，再分两种情况：
  看看当前节点是不是它的父节点的左子树，如果是，则返回它的父节点；
  如果当前节点不是它的父节点的左子树，则把父节点赋给当前节点，再判断当前节点是不是它的父节点的
  左子树，直到当前节点是不是它的父节点的左子树，返回它的父节点。
##代码
    public class ProNineTreeNextNode {
        public Tree FindNextNode(Tree inorder){
            if (inorder == null)
                return null;
            if (inorder.right != null){
                Tree next = inorder.right;
                while (next.left != null){
                    next = next.left;
                }
                return next;
            }
            else{
                while(inorder.father != null){
                    if (inorder.father.left == inorder)
                        return inorder.father;
                    else 
                        inorder = inorder.father;
                }
                return null;
            }
        }
    }
    
    class Tree {
        private int val;
        Tree left;
        Tree right;
        Tree father;
        Tree(int val){ this.val=val; }
    }