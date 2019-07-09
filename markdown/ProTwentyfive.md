#合并两个排序链表
##题目
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
##思路
递归
##代码
    public class ProTwentyfive {
        public ListNode conbineNode(ListNode Head1, ListNode Head2){
            if (Head1 == null)
                return  Head2;
            else if (Head2 == null)
                return Head1;
            ListNode Head = null;
            if (Head1.val <= Head2.val){
                Head = Head1;
                Head.next = conbineNode(Head1.next,Head2);
            }
            else {
                Head = Head2;
                Head.next = conbineNode(Head1, Head2.next);
            }
            return Head;
        }
    }