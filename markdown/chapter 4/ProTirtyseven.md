#序列化二叉树
##题目
请实现两个函数，分别用来序列化和反序列化二叉树。
##思路
序列化可以用前序遍历来实现，为了避免数字重合组成一个数字，每个数字之间用‘，’来分隔，同时为
了方便反序列化，用特殊符号‘$’来代替null。（可能数字会重复，所以不用前序和中序遍历数列来重
构树。
##代码
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
            if (val.equals("$"))
                return null;
            IntTreeNode node = new IntTreeNode(Integer.parseInt(val));
            node.Left = DeserialCore(queuq);
            node.Right = DeserialCore(queuq);
            return node;
        }
    }