import java.util.ArrayList;
public class LinkedList {
    Node head;

    public void insertElement(People person)
    {
        Node node = new Node(person);
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node currentNode = head;
            while(currentNode.next != null)
            {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
    }   

    public void print()
    {
        Node currentNode = head;
        if(head != null) // Run only if head is not empty.
        {
            while(currentNode != null)
            {
                System.out.println(currentNode.person.toString());
                currentNode = currentNode.next;
            }
        }
        else
        {
            System.out.println("LinkedList is empty.");
        }
    }

    public ArrayList<LinkedList> split(LinkedList list)
    {
        ArrayList<LinkedList> arrList = new ArrayList<LinkedList>();
        LinkedList vacList = new LinkedList();
        LinkedList unvacList = new LinkedList();
        Node currentNode = head;
        if(head != null) // Run only if head is not empty.
        {
            while(currentNode != null)
            {
                if((currentNode.person.status).equalsIgnoreCase("vaccinated"))
                {
                    vacList.insertElement(currentNode.person);
                    currentNode = currentNode.next;
                }
                else
                {
                    unvacList.insertElement(currentNode.person);
                    currentNode = currentNode.next;
                }
            }
        }
        else
        {
            System.out.println("LinkedList is Empty.");
        }
        arrList.add(unvacList);
        arrList.add(vacList);
        return arrList;
    }

}   // End of LinkedList Class.

class Node 
{
    Node next;
    People person;

    Node(){} // Def Constructor

    Node(People person) // Parameterized Constructor
    {
        this.person = person;
    }
}