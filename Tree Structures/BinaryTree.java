/* BinaryTree.java - A binary tree in which each node has 2 children
 * Myles Darity-Reese
 * 19-Nov-23
 * What it does:
 * BinaryTree(): Constructor
 * BinaryTree: Constructs a tree with one node and no children
 * BinaryTree(): Constructs a binary with left and right children 
 * countNodesWithOneChild(): Counts the number with only one child
 * height(): Returns height of Tree
 * isEmpty(): Checks wether this tree is empty
 * data(): Returns the data at the root of tree
 * left(): Return the left subtree of tree
 * main(): Tester for BinaryTree
 */

public class BinaryTree {
    //BinaryTree - A binary tree in which each node has 2 children
    private Node root;

    public BinaryTree(){
        //BinaryTree(): Constructor
        //Implementation: Assignments to Instance Variables
        root = null;
        //System.out.println("BinaryTree(): Return");
    }

    public BinaryTree(Object rootData){
        //BinaryTree: Constructs a tree with one node and no children
        //Implementation: Assignments to Instance Variables
        root = new Node();
        root.data = rootData;
        root.left = null;
        root.right = null;
        //System.out.println("BinaryTree(Root): Return");
    }

    public BinaryTree(Object rootData, BinaryTree left, BinaryTree right){
        //BinaryTree(): Constructs a binary with left and right children 
        //Implementation: Assignments to Instance Variables
        root = new Node();
        root.data = rootData;
        root.left = (left != null ? left.root : null);
        root.right = (right != null ? right.root : null);
        //System.out.println("BinaryTree(Root, Left, Right): Return");
    }

    class Node{
        //Node: Holds Data and Children
        public Object data;

        public Node left;

        public Node right;

        public int countNodesWithOneChild(){
            //countNodesWithOneChild(): Counts the number with only one child
            //Implementation: Recures: left and or right root depending on the condition
            int nRet = 0;
            if(root.left == null && root.right == null){return 0;}
            if(root.left == null || root.right == null){
                if(root.right != null){return nRet += 1 + root.right.countNodesWithOneChild();}
                return nRet += 1 + root.left.countNodesWithOneChild();
            }
            return nRet += root.left.countNodesWithOneChild() + root.right.countNodesWithOneChild();
        }
    
        public int height(Node n){
            //height(): Returns height of Tree
            //Implementation: Recurse: Math(height)
            //System.out.printf("height(): %d \n", 
                            //n != null ? 0 : 1 + Math.max(height(n.left), height(n.right)));
            return (n == null) ? 0 : 1 + Math.max(height(n.left), height(n.right));
        }
    }

    public int countNodesWithOneChild(){
        //countNodesWithOneChild(): Counts the number with only one child
        //Implementation: Calls to Node countNodesWithOneChild()
        //System.out.printf("countNodesWithOneChild(): %d\n", 
                          //root != null ? root.countNodesWithOneChild() : 0);
        return (root != null ? root.countNodesWithOneChild() : 0);
    }

    public int height(){
        //height(): Returns height of Tree
        //Implementation: Calls to Node height()
        return root.height(root);
    }

    public boolean isEmpty(){
        //isEmpty(): Checks wether this tree is empty
        //Implementation: Conditional on Instance Variable
        return root == null;
    }

    public Object data(){
        //data(): Returns the data at the root of tree
        //Implementation: Return Instace Variable
        return root.data;
    }

    public BinaryTree left(){
        //left(): Return the left subtree of tree
        //Implemntation: Assignment to Returned new BinaryTree
        BinaryTree btRet = new BinaryTree();
        btRet.root = root.left;
        return btRet;
    }

    public BinaryTree right(){
        //left(): Return the right subtree of tree
        //Implemntation: Assignment to Returned new BinaryTree
        BinaryTree btRet = new BinaryTree();
        btRet.root = root.right;
        return btRet;
    }

    public static void main(String[] args) throws Exception {
        //main(): Tester for BinaryTree
        //Implementation: Calls to Methods
        BinaryTree t4 = new BinaryTree("Savannah");
        BinaryTree t2 = new BinaryTree("Peter", t4, null);
        BinaryTree t3 = new BinaryTree("John", t2, null);
        BinaryTree t5 = new BinaryTree("John", null, t3);
        System.out.println("countNodesWithOneChild(t5): " + t5.countNodesWithOneChild());
        System.out.println("Expected: 3");
        System.out.println("height(t5): " + t5.height());
        System.out.println("Expected: 4");
        System.out.println("isEmpty(t5): " + t5.isEmpty());
        System.out.println("Expected: false");
        System.out.println("data(t3): " + t3.data());
        System.out.println("Expected: John");
        System.out.println("left(t4): " + t4.left());
        System.out.println("right(t4): " + t4.right());
    }
}
