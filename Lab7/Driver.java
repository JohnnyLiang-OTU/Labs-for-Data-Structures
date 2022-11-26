public class Driver {
    public static Node sortDescendingRec(Node head)
    {
        if(head == null) // Base step
        {
            return null;
        }
        if(head.next == null) // Base step
        {
            return head;
        }
        Node rest = head.next; // rest becomes equal to what comes after head. Because we can reverse 12345 as reversed.(2345) = (5432) followed by the head, or 1.
        head.next = null; // Unlink the head from rest. 
        Node reverseRest = sortDescendingRec(rest); // Call all other steps recursively, giving rest as the parameter.
        rest.next = head; // Reconnect reversed rest to the head.   
        
    
        return reverseRest;
    }

    public static void displayLinkedList(Node node)
    {
        Node currentNode = node;
        while(currentNode != null)
        {
            System.out.println(currentNode.country.toString());
            currentNode = currentNode.next;
        }
    }
    public static void main(String[] args) 
    {
        Node head = new Node(new Country("Australia", 25499884)); 
        head.next = new Node(new Country("Canada", 37742154)); 
        head.next.next = new Node(new Country("United States", 338289857)); 
        head.next.next.next = new Node(new Country("India", 1417173173)); 
        head.next.next.next.next = new Node(new Country("China", 1425887337));

        System.out.println("\nOriginal Linked List:"); 
        System.out.println("*********************"); 
        displayLinkedList(head); 
 
        System.out.println("\nSorted Linked List:"); 
        System.out.println("*********************"); 
        displayLinkedList(sortDescendingRec(head));
    }
}


class Node
{
    Node next;
    Country country;

    Node(Country country)
    {
        this.country = country;
    }
}

