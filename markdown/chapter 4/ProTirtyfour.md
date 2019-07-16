#二叉树中和为某一值的路径
##题目
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树
的根结点开始往下一直到叶结点所经过的结点形成一条路径。
##思路
从题中得到，路径是从根节点开始往下，可以用先序遍历
##代码
    import java.util.ArrayList;
    
    public class ProTirtyfour {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        public ArrayList<ArrayList<Integer>> findpath(BinaryTreeNode root, int length){
            if (root == null)
                return result;
            length -= root.val;
            temp.add(root.val);
            if (length == 0 && root.left == null && root.right ==null){
                result.add(temp);
                return result;
            }
            else {
                findpath(root.left,length);
                findpath(root.right,length);
            }
            temp.remove(temp.size()-1);
            return result;
    
        }
    }