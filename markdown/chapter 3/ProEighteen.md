#删除链表中的节点
##题目1，在 O(1) 时间内删除链表节点
给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 时间内删除该节点。链表节点与函数定义如下：
        
        typedef struct ListNode
        {
            int m_nValue;
            struct ListNode* m_pNext;
        }ListNode;
##题目二，删除链表中重复的节点
在一个排序的链表中，如何删除重复的结点？例如，在链表1中重复结点被删除之后，链表如链表2所示。 

1->2->2->3->3->4->5 

1->4->5
##思路
对于问题一，要求在O（1）时间复杂，我们用覆盖的方法，把他的下一节点将要删除的节点覆盖掉，达到删除的
效果。对于问题二，我们采用一个坐标节点和一个探测节点，来完成。
##代码
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
    