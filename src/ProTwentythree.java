public class ProTwentythree {
    public ListNode Entryofcircle(ListNode Head){
        if (Head == null || Head.next == null || Head.next.next ==null)
            return null;
        ListNode Node = Head;
        ListNode Tail = Node.next.next;
        while (Tail != null){
            if (Tail == Node){
                Tail = Node.next;
                int circleLength = 1;
                while (Tail != Node){
                    Tail = Tail.next;
                    circleLength++;
                }
                Node = Head;
                Tail = Head;
                for (int i=0;i<circleLength;i++){
                    Tail = Tail.next;
                }
                while (Tail != Node){
                    Node = Node.next;
                    Tail = Tail.next;
                }
                return Tail;
            }
            else {
                Node = Node.next;
                Tail = Tail.next.next;
            }
        }
        return null;
    }
}
