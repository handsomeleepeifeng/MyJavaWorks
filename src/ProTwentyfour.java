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
