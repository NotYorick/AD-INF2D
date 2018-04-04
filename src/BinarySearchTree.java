/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gert Jan
 * @version 1.0
 * @date april 2018
 * 
 * This class is used to create a binary search tree, this is done by inserting nodes. 
 * It's also possible to search and delete nodes and to print out all nodes in order.
 * There's also an option to convert a sorted array to a binary search tree.
 * 
 */
public class BinarySearchTree
{
    private Node root;
    private int[] sortedArray;
    
    //Node class needed for filling the binary search tree.
    protected class Node
    {
        public int key;
        public Node left = null;
        public Node right = null;

        public Node(int data)
        {
            this.key = data;
        }
    }
    
    //create an empty binary search tree
    public BinarySearchTree()
    {
        root = null;
    }
    
    //create and fill a a binary search tree by using a sorted array.
    public BinarySearchTree(int array[])
    {
        this.sortedArray = array;
        int lastIndex = array.length - 1; //last index of the array
        root = sortedArrayToBST(array, 0, lastIndex);
    }
    
    //use an array to create a binary search tree and return the root node
    public Node sortedArrayToBST(int array[], int start, int end)
    {
        if(start > end)
        {
            return null;
        }
        
        int mid = (start + end) /2;
        Node node = new Node(array[mid]);
        
        node.left = sortedArrayToBST(array, start, mid - 1);
        node.right =sortedArrayToBST(array, mid + 1, end);
        
        return node;
    }
    
    //Search for a node
    public Node search(Node root, int key)
    {
        if(root == null || root.key == key)
        {
            return root;
        }
        
        if(root.key > key)
        {
            return search(root.left, key);
        }
        return search(root.right, key);
    }
    
    //Insert a new node
    public void insert(int key)
    {
        root = insertHelper(root, key);
    }
    
    //Recurse part of the insert node method
    private Node insertHelper(Node root, int key)
    {
        if(root == null)
        {
            root = new Node(key);
            return root;
        }
        
        if(key < root.key)
        {
            root.left = insertHelper(root.left, key);
        }
        else if(key > root.key)
        {
            root.right = insertHelper(root.right, key);
        }
        return root;
    }
    
    //Delete a node
    public void deleteNode(int key)
    {
        root = deleteHelper(root, key);
    }
    
    //Recurse part of the delete node method
    private Node deleteHelper(Node root, int key)
    {
        if(root == null)
        {
            return root;
        }
        if(key < root.key)
        {
            root.left = deleteHelper(root.left, key);
        }
        else if(key > root.key)
        {
            root.right = deleteHelper(root.right, key);
        }
        else
        {
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }
            
            root.key = minValue(root.right);
            
            root.right = deleteHelper(root.right, root.key);
        }
        return root;
    }
    
    //Find the smallest root key value (used for delete node)
    public int minValue(Node root)
    {
        int min = root.key;
        while(root.left != null)
        {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }
    
    //Print the binary search tree
    public void printBST()
    {
        printBSTHelper(root);
    }
    
    //Recurse part of the printBST method
    public void printBSTHelper(Node root)
    {
        if(root != null)
        {
            printBSTHelper(root.left);
            System.out.print(root.key +", ");
            printBSTHelper(root.right);
        }
    }
}
