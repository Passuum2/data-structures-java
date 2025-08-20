/* Tree.java - tree in which each node has an arbitrary number of children
 * Myles Darity-Reese
 * 7-Nov-23
 * What it does:
 * size(): Return the size of subtreee whose root is this node
 * leafCount():Returns number of leaves on Tree Array
 * Tree(): Constructor
 * Tree: Constructor with object
 * addSubTree(): Adds subtree as last child
 * size(): Returns the size of the tree
 * leafCount(): Returns number of the leaves of the tree
 * main(): Tester
 */

//NOTE: Removed java.util.List
import java.util.ArrayList;    //add()

public class Tree {
    //Tree - tree in which each node has an arbitrary number of children
    private Node root;
    
    class Node{
        //Node: Holds Data and Points to children
        public Object data;
        public ArrayList<Node> children;

        public int size(){ 
            //size(): Return the size of subtreee whose root is this node
            //Implementation: Iterates on Assignment and +
            //NOTE: Size is one for this node PLUS one for each the children
            int nRet = 0;
            for (Node child : children) {nRet += child.size();}
            return 1 + nRet; 
        }

        public int leafCount(){
            //leafCount():Returns number of leaves on Tree Array
            //Implementation: Iterates on = and +, Recursion on root
            int nRet = 0;
            if (children.size() == 0){
                return nRet = 1;
            } else {
                for (Node child: children){
                    nRet += child.leafCount();
                }
            }
            return nRet;
        }
    }

    public Tree(){
        //Tree(): Constructor
        //Implementation: Assignments to Instance Variables
        root = null;
    }

    public Tree(Object rootData){
        //Tree: Constructor with object
        //Implementation: Assigns new Node to Instance Variables
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
    }

    public void addSubTree(Tree subtree){
        //addSubTree(): Adds subtree as last child
        //Implementation: Assignments
        root.children.add(subtree.root);
    }

    public int size(){
        //size(): Returns the size of the tree
        //Implementation: Calls to Node Size()
        return (root != null ? root.size() : 0);
    }

    public int leafCount(){
        //leafCount(): Returns number of the leaves of the tree
        //Implementation: Calls to Node leafCount();
        return (root != null ? root.leafCount() : 0);
    }

    public static void main(String[] args) {
        //main(): Tester
        //Implementation: Calls to Methods
        Tree t1 = new Tree("Bill");
        Tree t2 = new Tree("Tim");
        Tree t3 = new Tree("Jeff");
        t2.addSubTree(t1);
        t3.addSubTree(t1);
        System.out.println("size(t4): " + t3.size());
        System.out.println("Expected: 2");
        System.out.println("leafCount(t4): " + t3.leafCount());
        System.out.println("Expected: 1");
    }
}
