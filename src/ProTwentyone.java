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
