#链表中倒数第k个结点
##题目
输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾
结点是倒数第1个结点。例如一个链表有6个结点，从头结点开始它们的值依次是1、2、3、4、5、6。这
个链表的倒数第3个结点是值为4的结点。
 ##思路
 利用两个点，前驱节点后驱节点，后驱节点在前驱节点后k个位置，当后驱节点到了链表尾部，前驱节点就
 是倒数第k个节点了。
 ##代码
    public class ProTwentyone {
        public ListNode FindKthNode(ListNode Head,int k){
            ListNode Node = Head;
            ListNode Tail = Node;
            if (Head == null || k<1)
                return null;
            for (int i = 1; i<k; i++){
                if (Tail.next != null)
                    Tail = Tail.next;
                else
                    return null;
            }
            while (Tail.next != null){
                Node = Node.next;
                Tail = Tail.next;
            }
            return Node;
        }
    }