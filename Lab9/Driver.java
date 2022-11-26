// This program expects you to work with a Binary Search Tree of Students. You are expected to print 
// all the nodes of the tree along with finding minimum, maximum and average of the node
// Author: Johnny Liang
// Date: November 16th, 2022
// Course: Data Structure
// Work: Lab 9
// Professor Razi Iqbal
// TA: Shawkh Ibne Rashid

public class Driver {
    static int sum = 0;
    static int count = 0;
    static class Node
    {
        Node left;
        Node right;
        Student student;
        
        Node(Student student)
        {
            this.student = student;
        }
    }
    public static void getAverageAge(Node node)
    {
        System.out.println("Average Age of Students: " + (getAverage(node) / count));
    }
    public static int getAverage(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        sum += root.student.age;
        count++;
        getAverage(root.left);
        getAverage(root.right);
        return sum;
    }

    // Functions made to work without using global variables.
    //
    // public static void getAverage(Node node)
    // {
    //     System.out.println("Average Age of Students: " + (getTotal(node)/nodeCounter(node)));
    // }
    // public static int nodeCounter(Node node)
    // {
    //     if(node == null)
    //     {
    //         return 0;
    //     }
    //     int counter = 1 + nodeCounter(node.left) + nodeCounter(node.right);
    //     return counter;
    // }
    // public static int getTotal(Node root)
    // {
    //     if(root == null)
    //     {
    //         return 0;
    //     }
    //     int total = root.student.age;
    //     total += getTotal(root.left) + getTotal(root.right);
    //     return total;
    // }


    public static Node getMinimum(Node root)
    {
        if(root.left == null)
        {
            return root;
        }
        return getMinimum(root.left);
    }

    public static Node getMaximum(Node root)
    {
        if(root.right == null)
        {
            return root;
        }
        return getMaximum(root.right);
    }

    public static void printNodes(Node root)
    {
        if(root == null)
        {
            return;
        }
        printNodes(root.left);
        System.out.println(root.student.toString());
        printNodes(root.right);
    }
    public static void main(String[] args) 
    {
        Node root = new Node(new Student("Steve Jobs", 55));
        root.left = new Node(new Student("Elon Musk", 45)); 
        root.right = new Node (new Student("Bill Gates", 75)); 
        root.left.left = new Node (new Student("Ben Stokes", 40)); 
        root.left.right = new Node (new Student("Angelina Jolie", 48)); 
        root.right.left = new Node(new Student("Warren Buffet", 72)); 
        root.right.right = new Node(new Student("Lizzy Bank", 80));   
         
        System.out.println("\nList of Students"); 
        System.out.println("***********************"); 
        printNodes(root); 
        
        System.out.println("\nClass Statistics"); 
        System.out.println("***********************"); 
        System.out.println("Youngest Student: " + getMinimum(root).student.toString()); 
        System.out.println("Oldest Student: " + getMaximum(root).student.toString()); 
        getAverageAge(root);
    }
}
