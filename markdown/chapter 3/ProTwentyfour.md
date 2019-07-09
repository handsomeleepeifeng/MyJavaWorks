#翻转链表
##题目
 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 ##代码
    public class ProTwentyfour {
        public ListNode printEndNode(ListNode Head){
            if (Head == null)
                return null;
            if (Head.next == null)
                return Head;
            ListNode Node = Head;
            ListNode Tail = Node.next;
            while (Node.next != null){
                ListNode temp = Tail.next;
                Tail.next = Node;
                Node = Tail;
                Tail = temp;
            }
            Head.next = null;
            return Node;
        }
    }