import java.util.ArrayList;

public class ProTirtyfour {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> temp = new ArrayList<>();
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
