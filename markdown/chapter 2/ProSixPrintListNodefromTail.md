#从尾到头打印链表
##题目
输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
##代码
    public class ProSixPrintListNodefromTail {
        public void PrintListNodefromTailSolution(ListNode Head){
            ListNode Node = reverseNode(Head);
            while (Node.next != null){
                System.out.println(Node.val);
                Node = Node.next;
            }
            System.out.println(Node.val);
        }
        private ListNode reverseNode(ListNode Head){
            if (Head==null||Head.next==null){
                return Head;
            }
            ListNode temp = Head.next;
            ListNode NewHead = reverseNode(Head.next);
            Head.next = Head;
            Head = temp;
            return NewHead;
        }
    }