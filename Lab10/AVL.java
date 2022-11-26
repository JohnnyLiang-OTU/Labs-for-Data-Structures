public class AVL {
    Node root;
    
    void insertion(Logs log)
    {
        root = insertNode(root, log);
    }

    Node insertNode(Node node, Logs log)
    {   
        if(node == null)
        {
            return new Node(log);
        }
        if(log.year < node.log.year)
        {
            node.left = insertNode(node.left, log);
        }
        else if(log.year > node.log.year)
        {
            node.right = insertNode(node.right, log);
        }
        else
        {
            return node;
        }
        node.height = getMax(getHeight(node.left), getHeight(node.right)) + 1;
        int BF = getBF(node);
        
        if(BF > 1)
        {
            if(log.year < node.left.log.year)
            {
                return rightRotate(node);
            }
            else
            {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(BF < -1)
        {
            if(log.year > node.right.log.year)
            {
                return leftRotate(node);
            }
            else
            {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    Node leftRotate(Node node)
    {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.height = getMax(getHeight(node.left), getHeight(node.right))+1;
        newRoot.height = getMax(getHeight(newRoot.left), getHeight(newRoot.right))+1;
        return newRoot;
    }

    Node rightRotate(Node node)
    {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = getMax(getHeight(node.left), getHeight(node.right))+1;
        newRoot.height = getMax(getHeight(newRoot.left), getHeight(newRoot.right))+1;
        return newRoot;
    }

    int getMax(int a, int b)
    {
        return (a > b) ? a : b;
    }

    int getHeight(Node node)
    {
        if(node == null)
        {
            return 0;
        }
        return node.height;
    }

    int getBF(Node node)
    {
        if(node == null)
        {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    void preOrder(Node node)
    {
        if(node == null)
        {
            return;
        }
        System.out.println(node.log.toString());
        preOrder(node.left);
        preOrder(node.right);
    }

    void deletion(int year)
    {
        root = AVLDeleteNode(root, year);
    }

    Node deleteNode(Node node, int target) // OBSOLETE, DELETE FUNCTION FOR BINARY TREE, NOT AVL TREES.
    {
        Node pointer = node;
        Node pointerParent = node;
        boolean isLeft = false;

        while(pointer.log.year != target) // Searching algorithm
        {
            pointerParent = pointer;
            if(target < pointer.log.year) // Search left side of tree if target < pointer's year.
            {
                isLeft = true;
                pointer = pointer.left;
            }
            else // otherwise, search the right side.
            {
                isLeft = false;
                pointer = pointer.right;
            }
            if(pointer == null) // If target not found
            {
                System.out.println("Target not found.");
                return node;
            }
        }

        // No child scenario
        if(getHeight(pointer) == 1) // If the height of pointer == 1, it has no children.
        {
            if(pointer == node)
            {
                node = null;
            }
            else
            {
                if(isLeft)
                {
                    pointerParent.left = null;
                }
                else
                {
                    pointerParent.right = null;
                }
            }
        }

        // Child scenarios
        else if(getHeight(pointer) > 1) // If height of pointer > 2, it has atleast 1 child.
        {
            if(isLeft) // Pointer is left of parent
            {
                if(getBF(pointer) == 1) // If there is one child and child is in the left of pointer. (1 CHILD, LEFT scenario)
                {
                    Node temp = pointer.left; // Store node of pointer left child.
                    pointer.left = null;
                    pointerParent.left = temp;
                }
                else if(getBF(pointer) == -1) // Else if there is one child and it is in the right of pointer. (1 CHILD, RIGHT scenario)
                {
                    Node temp = pointer.right; 
                    pointer.right = null;
                    pointerParent.left = temp;
                }
                else if(getBF(pointer) == 0) // When child's BF == 0, it has two childs. (2 CHILD SCENARIO)
                {
                    Node tempL = pointer.left;
                    Node tempR = pointer.right;
                    pointer.left = null;
                    pointer.right = null;
                    tempR.right = tempL;
                    pointerParent.left = tempR;
                }
            }
            else // Pointer is right of its parent
            {
                if(getBF(pointer) == 1)
                {
                    Node temp = pointer.left; 
                    pointer.left = null;
                    pointerParent.right = temp;
                }
                else if(getBF(pointer) == -1)
                {
                    Node temp = pointer.right;
                    pointer.right = null;
                    pointerParent.right = temp;
                }
                else if(getBF(pointer) == 0)
                {
                    Node tempL = pointer.left;
                    Node tempR = pointer.right;
                    pointer.left = null;
                    pointer.right = null;
                    tempL.right = tempR;
                    pointerParent.right = tempL;
                }
            }
        }
        return node;
    }

    Node AVLDeleteNode(Node node, int target)
    {
        if(node == null)
        {
            return node;
        }
        if(target < node.log.year)
        {
            node.left = AVLDeleteNode(node.left, target);
        }
        else if(target > node.log.year)
        {
            node.right = AVLDeleteNode(node.right, target);
        }
        else
        {
            if(node.left == null || node.right == null) // Checks if the node to eliminate has 1 child or none.
            {
                Node temp = null; 
                if(temp == node.left) // if left is null, temp will store right node.
                {
                    temp = node.right;
                }
                else // otherwise, temp will store left node.
                {
                    temp = node.left;
                }

                if (temp == null) // If there was no child (node.left and node.right == null, then temp == null)
                {
                    node = null; // then just remove node.
                }
                else
                {
                    node = temp; // If there was atleast one child, make node = temp (node.left or node.right whichever is not empty, will replace the target node)
                }
            }
            else // If node.left and node.right != null. Therefore there are two childs. 
            {
                Node temp = minNode(node.right); // Make temp = min(node.right) or temp = max(node.left). [I used min(node.right).]
                node.log = temp.log; // copy contents of temp into node to simulate deletion.
                node.right = AVLDeleteNode(node.right, temp.log.year); // then look for the node who temp copied and eliminate it so there's no duplicates.
            }
        }
        if(node == null)
        {
            return node;
        }
        // Now do the according rotations.
        node.height = getMax(getHeight(node.left), getHeight(node.right))+1;
        int BF = getBF(node);
        if(BF > 1)
        {
            if(target < node.left.log.year)
            {
                return rightRotate(node);
            }
            else
            {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(BF < -1)
        {
            if(target > node.right.log.year)
            {
                return leftRotate(node);
            }
            else
            {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    Node minNode(Node node) // Finds minimum of the node. Just traversing to the leftmost node.
    {
        Node currentNode = node;
        while(currentNode.left != null)
        {
            currentNode = currentNode.left;
        }
        return currentNode;
    }
}
 
class Node
{
    Node left;
    Node right;
    Logs log;
    int height;

    Node(Logs log)
    {
        this.log = log;
        height = 1;
    }
}
