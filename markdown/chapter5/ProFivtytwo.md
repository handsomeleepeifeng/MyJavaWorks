#两个链表的第一个公共结点
##题目
如下图，找到C1
![51_1](../../PIC/51_1.png)
##思路
用两个辅助栈，先将两个链表入栈，再出栈，出站时找到最后一个相同的对象。或者分别遍历两个
链表，当第一个链表的节点遍历完了之后，转到第二个链表的头结点，这样两个节点走的步数相同，
最终会相交到第一个相同的节点
##代码
    import java.util.Stack;
    
    public class ProFivtytwo {
        public ListNode FindFirst(ListNode Head1,ListNode Head2){
            Stack<ListNode> NodeStack1 = new Stack<>();
            Stack<ListNode> NodeStack2 = new Stack<>();
            ListNode Node1 = Head1;
            ListNode Node2 = Head2;
            ListNode res = null;
            while (Node1 != null || Node2 != null){
                if (Node1 != null){
                    NodeStack1.push(Node1);
                    Node1 = Node1.next;
                }
                if (Node2 != null){
                    NodeStack2.push(Node2);
                    Node2 = Node2.next;
                }
            }
            while(NodeStack1.peek() == NodeStack2.peek()){
                res = NodeStack1.pop();
                NodeStack2.pop();
            }
            return res;
        }
    
        public ListNode FindFirst2(ListNode Head1,ListNode Head2){
            ListNode Node1 = Head1,Node2 = Head2;
            while(Node1 != Node2){
                Node1 = (Node1 == null)?Head2:Node1.next;
                Node2 = (Node2 == null)?Head1:Node2.next;
            }
            return Node1;
        }
    }