import java.util.LinkedList;
import java.util.Queue;

public class ProTirtyseven {
    public String serialize(IntTreeNode root){
        if (root == null)
            return "$,";
        StringBuffer result = new StringBuffer(root.val+",");
        result.append(serialize(root.Left));
        result.append(serialize(root.Right));
        return result.toString();
    }
    public IntTreeNode Deserilize(String str){
        String[] val = str.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String e : val){
            queue.offer(e);
        }
        return DeserialCore(queue);
    }

    private IntTreeNode DeserialCore(Queue<String> queuq){
        String val = queuq.poll();
        if ("$".equals(val))
            return null;
        IntTreeNode node = new IntTreeNode(Integer.parseInt(val));
        node.Left = DeserialCore(queuq);
        node.Right = DeserialCore(queuq);
        return node;
    }
}
