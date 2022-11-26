public class Driver2 {
    public static Node function(Node head)
    {
        if(head == null)
        {
            return null;
        }
        if(head.next == null)
        {
            return head;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        function(head);

    }
}
class Node
{
    public Node next;
    public int data;

    Node(int data)
    {
        this.data = data;
    }
}