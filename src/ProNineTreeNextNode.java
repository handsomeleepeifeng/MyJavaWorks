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