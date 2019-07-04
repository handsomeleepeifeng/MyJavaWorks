public class ProEighteen {
    public ListNode DeleteNode(ListNode Head, ListNode ToDelect){
        ListNode Dhead = new ListNode(-1);
        Dhead.next = Head;
        if (ToDelect.next == null)
            ToDelect = null;
        else if (ToDelect.next.next == null) {
            ToDelect.val = ToDelect.next.val;
            ToDelect.next = null;
        }
        else{
            ToDelect.val = ToDelect.next.val;
            ToDelect.next = ToDelect.next.next;
        }
        return Dhead.next;
    }

    public ListNode DelectDuplication(ListNode Head){
        if (Head.next == null)
            return Head;
        ListNode Dhead = new ListNode(-1);
        Dhead.next = Head;
        ListNode Node = Dhead;
        ListNode detectNode = Dhead.next;
        boolean flag = false;
        while (Node.next != null){
            while (detectNode.val == Node.val){
                flag = true;
                if (detectNode.next != null)
                    detectNode = detectNode.next;
            }
            if (flag){
                if (detectNode.next != null)
                    Node.next = detectNode.next;
                else {
                    Node.next = null;
                    break;
                }
            }
            flag = false;
            if (detectNode.next == null)
                break;
            Node = Node.next;
            detectNode = detectNode.next;
        }
        return Dhead.next;
    }
}
