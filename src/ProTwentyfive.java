public class ProTwentyfive {
    public ListNode conbineNode(ListNode Head1, ListNode Head2){
        if (Head1 == null)
            return  Head2;
        else if (Head2 == null)
            return Head1;
        ListNode Head;
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
