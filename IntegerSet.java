import java.lang.StringBuffer;
public class IntegerSet {

    private int size = 0;
    Node root = null;

    //constructor
    public IntegerSet()
    {}//end constructor

    //add
    public boolean add(int newItem) 
    {
        if(size == 0)
        {
            root = new Node(newItem, null, null);
            size++;
            return true;
        }
        else
        {
            Node currentNode = root;
            Node nodeToAdd = new Node(newItem, null, null);
            if(contains(newItem) == true)
            {
                return false;
            }
            while(currentNode != null)
            {
                if(newItem < currentNode.item)
                {
                    //left
                    if(currentNode.left ==  null)
                    {
                        currentNode.left = nodeToAdd;
                        size++;
                        return true;
                    }
                    else
                    {
                        currentNode = currentNode.left;
                    }
                }
                if(newItem > currentNode.item)
                {
                    //right
                    if(currentNode.right ==  null)
                    {
                        currentNode.right = nodeToAdd;
                        size++;
                        return true;
                    }
                    else
                    {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
        return false;
    }//end add

    //contains
    public boolean contains(int itemToFind) {
        Node currentNode = root;
        while((currentNode!=null))
        {
            if(currentNode.item == itemToFind)
                return true;
            else if(itemToFind<currentNode.item)
            {
                currentNode = currentNode.left;
            }
            else if(itemToFind>currentNode.item)
            {
                currentNode = currentNode.right;
            }
        }
        return false;
    }//end contains

    //union
    public IntegerSet union(IntegerSet other) {
        IntegerSet returnSet = new IntegerSet();
        //this

        //compare left subtree
        Node currentNode = root.left;
        while((currentNode!=null)&&(currentNode.left!=null||currentNode.right!=null))
        {
            if(!(other.contains(currentNode.item)))
                returnSet.add(currentNode.item);

            if(currentNode.left!=null)
            {
                if(!(other.contains(currentNode.left.item)))
                    returnSet.add(currentNode.left.item);
            }
            if(currentNode.right!=null)
            {
                if(!(other.contains(currentNode.right.item)))
                    returnSet.add(currentNode.right.item);
            }
            currentNode = currentNode.left;
        }

        //compare right subtree
        currentNode = root.right;
        while(currentNode!=null&&(currentNode.right!=null||currentNode.left!=null))
        {
            if(!(other.contains(currentNode.item)))
                returnSet.add(currentNode.item);
            if(currentNode.left!=null)
            {
                if(!(other.contains(currentNode.left.item)))
                    returnSet.add(currentNode.left.item);
            }
            if(currentNode.right!=null)
            {
                if(!(other.contains(currentNode.right.item)))
                    returnSet.add(currentNode.right.item);
            }
            currentNode = currentNode.right;
        }
        //compare root
        if(!(other.contains(root.item)))
            returnSet.add(root.item);

        //other

        //compare left subtree
        currentNode = other.root.left;
        while((currentNode!=null)&&(currentNode.left!=null||currentNode.right!=null))
        {
            if(!(this.contains(currentNode.item)))
                returnSet.add(currentNode.item);

            if(currentNode.left!=null)
            {
                if(!(this.contains(currentNode.left.item)))
                    returnSet.add(currentNode.left.item);
            }
            if(currentNode.right!=null)
            {
                if(!(this.contains(currentNode.right.item)))
                    returnSet.add(currentNode.right.item);
            }
            currentNode = currentNode.left;
        }

        //compare right subtree
        currentNode = other.root.right;
        while(currentNode!=null&&(currentNode.right!=null||currentNode.left!=null))
        {
            if(!(this.contains(currentNode.item)))
                returnSet.add(currentNode.item);
            if(currentNode.left!=null)
            {
                if(!(this.contains(currentNode.left.item)))
                    returnSet.add(currentNode.left.item);
            }
            if(currentNode.right!=null)
            {
                if(!(this.contains(currentNode.right.item)))
                    returnSet.add(currentNode.right.item);
            }
            currentNode = currentNode.right;
        }
        //compare root
        if(!(this.contains(other.root.item)))
            returnSet.add(other.root.item);
        return returnSet;
    }//end union

    //intersection
    public IntegerSet intersection(IntegerSet other) {
        Node currentNode = root.left;
        IntegerSet returnSet = new IntegerSet();

        //compare left subtree
        while((currentNode!=null)&&(currentNode.left!=null||currentNode.right!=null))
        {
            if(other.contains(currentNode.item))
                returnSet.add(currentNode.item);

            if(currentNode.left!=null)
            {
                if(other.contains(currentNode.left.item))
                    returnSet.add(currentNode.left.item);
            }
            if(currentNode.right!=null)
            {
                if(other.contains(currentNode.right.item))
                    returnSet.add(currentNode.right.item);
            }
            currentNode = currentNode.left;
        }

        //compare right subtree
        currentNode = root.right;
        while(currentNode!=null&&(currentNode.right!=null||currentNode.left!=null))
        {
            if(other.contains(currentNode.item))
                returnSet.add(currentNode.item);
            if(currentNode.left!=null)
            {
                if(other.contains(currentNode.left.item))
                    returnSet.add(currentNode.left.item);
            }
            if(currentNode.right!=null)
            {
                if(other.contains(currentNode.right.item))
                    returnSet.add(currentNode.right.item);
            }
            currentNode = currentNode.right;
        }
        //compare root
        if(other.contains(root.item))
            returnSet.add(root.item);
        return returnSet;
    }//end intersection

    public int magnitude() {
        return size;
    }

    //toString
    public String toString(Node root) {
        if (root == null)
            return "";
        StringBuffer sb = new StringBuffer();
        sb.append(toString(root.left));
        sb.append(root.toString());
        sb.append(toString(root.right));
        return ""+sb;
    }//end toString
    
    //getRoot
    public Node getRoot()
    {
        return root;
    }//end getRoot

    //class Node
    private static class Node
    {
        int item;
        Node left;
        Node right;

        public Node(int theItem, Node leftNode, Node rightNode)
        {
            item = theItem;
            left = leftNode;
            right = rightNode;
        }
    
        public String toString()
        {
            return String.format("%d ", item);
        }
    }//end class Node
}//end class IntegerSet