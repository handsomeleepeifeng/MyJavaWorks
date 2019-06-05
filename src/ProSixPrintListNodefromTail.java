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
