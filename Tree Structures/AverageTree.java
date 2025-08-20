/* AverageTree.java - A binary tree in which each node has 2 children
 * Myles Darity-Reese
 * 19-Nov-23
 * AverageTree(): Constructor
 * AverageTree: Constructs a tree with one node and no children
 * AverageTree(): Constructs a binary with left and right children 
 * Total(): Returns the total of the Tree
 * Average(): Returns Average Value from Binary Tree 
 * height(): Returns Tree Height
 * isEmpty(): Checks wether this tree is empty
 * data(): Returns the data at the root of tree
 * left(): Return the left subtree of tree
 * right(): Return the right subtree of tree
 * Visit(): Visitor
 * main(): Tester for AverageTree
 */

public class AverageTree implements Visitor {
    //AverageTree - A binary tree in which each node has 2 children

    private Node root;

    private int nCounter;

    private int nTotal;

    public AverageTree(){
        //AverageTree(): Constructor
        //Implementation: Assignments to Instance Variables
        root = null;
        //System.out.println("AverageTree(): Return");
    }

    public AverageTree(Object rootData){
        //AverageTree: Constructs a tree with one node and no children
        //Implementation: Assignments to Instance Variables
        root = new Node();
        root.data = rootData;
        root.left = null;
        root.right = null;
        //System.out.println("AverageTree(Root): Return");
    }

    public AverageTree(Object rootData, AverageTree left, AverageTree right){
        //AverageTree(): Constructs a binary with left and right children 
        //Implementation: Assignments to Instance Variables
        root = new Node();
        root.data = rootData;
        root.left = (left != null ? left.root : null);
        root.right = (right != null ? right.root : null);
        //System.out.println("AverageTree(Root, Left, Right): Return");
    }

    class Node{
        //Node: Holds Data and Children
        public Object data;

        public Node left;

        public Node right;

        private int Total(Node root){
            //Total(): Returns the total of the Tree
            //Implementation: Recures: root.left/root.right
            if (root != null) {
                Total(root.left);

                Visit(root.data);

                Total(root.right);
            }
            return nTotal;
        }

        private int Average(){
            //Average(): Returns Average Value from Binary Tree
            //Implementation: Math
            Total(root);
            return nTotal / nCounter;
        }

        private int height(Node taNode){
            //height(): Returns Tree Height
            //Implementation: Recurse: Math(height)
            return (taNode == null) ? 0 : 1 + Math.max(height(taNode.left), height(taNode.right));
        }
    }

    public int Average(){
        //Average(): Returns Average Value from Binary Tree
        //Implementation: Calls to Node Average()
        return (root != null ? root.Average() : 0);
    }

    public int height(){
        //height(): Returns height of Tree
        //Implementation: Calls to Node height()
        //NOTE: Fixed height()
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

    public AverageTree left(){
        //left(): Return the left subtree of tree
        //Implemntation: Assignment to Returned new AverageTree
        AverageTree btRet = new AverageTree();
        btRet.root = root.left;
        return btRet;
    }

    public AverageTree right(){
        //right(): Return the right subtree of tree
        //Implemntation: Assignment to Returned new AverageTree
        AverageTree btRet = new AverageTree();
        btRet.root = root.right;
        return btRet;
    }

    public void Visit(Object data){
        //Visit(): Visitor
        //Implementation: Adds Total, Increments Counter
        //System.out.println("Visit() Enter");
        try {
                nTotal += Integer.parseInt(data.toString());
                nCounter += 1;
                //System.out.println("Visit(): " + Integer.parseInt(data.toString()));
            } catch (Exception exception) {System.out.println("Exception");}
        //System.out.println("Visit() Return");
    }

    public static void main(String[] args) throws Exception {
        //main(): Tester for AverageTree
        //Implementation: Calls to Methods
        AverageTree t4 = new AverageTree(5);
        AverageTree t2 = new AverageTree(2);
        AverageTree t5 = new AverageTree(4, t4, t2);
        AverageTree t6 = new AverageTree(7, t5, null);
        System.out.println("Average(t6): " + t6.Average());
        System.out.println("Expected: 4");
        System.out.println("height(t6): " + t6.height());
        System.out.println("Expected: 3");
        System.out.println("isEmpty(t6): " + t6.isEmpty());
        System.out.println("Expected: false");
        System.out.println("data(t5): " + t5.data());
        System.out.println("Expected: 4");
        System.out.println("left(t6): " + t6.left());
        System.out.println("right(t6): " + t6.right());
    }
}