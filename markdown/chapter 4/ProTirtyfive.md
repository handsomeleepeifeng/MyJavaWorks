#复杂链表的复制
##题目
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
##思路
将节点一一克隆并且被源节点所指，交差穿插在原链表，之后再将其分开。
##代码
    public class ProTirtyfive {
        public ComplexListNode CloneNode(ComplexListNode head){
            if (head == null)
                return null;
            ComplexListNode newhead = head;
            //先克隆链表节点，并交差起来。
            while (newhead != null){
                ComplexListNode Node = new ComplexListNode(newhead.val);
                Node.next = newhead.next;
                newhead.next = Node;
                newhead = Node.next;
            }
            //再克隆sibling
            newhead = head;
            while(newhead != null){
                if (newhead.sibling != null){
                    newhead.next.sibling = newhead.sibling.next;
                }
                newhead = newhead.next.next;
            }
            //最后将两个链表差分
            newhead = head;
            ComplexListNode cloneHead = newhead.next;
            while(newhead != null){
                ComplexListNode cloneNode = newhead.next;
                newhead.next = cloneNode.next;
                cloneNode.next = cloneNode.next == null?null:cloneNode.next.next;
                newhead = newhead.next;
            }
            return cloneHead;
        }
    }
    
    class ComplexListNode{
        int val;
        ComplexListNode next;
        ComplexListNode sibling;
        public ComplexListNode(int val){
            this.val = val;
        }
    }