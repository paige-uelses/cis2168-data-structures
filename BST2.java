import java.util.Queue;
import java.util.LinkedList;

public class BST2<Key extends Comparable<Key>> {
   private Node root;
   private class Node  {
      Key key;           // this node's data
      Node left, right;  // this node's children

      // Constructor: initializes data and makes this a leaf node
      public Node(Key key) { this(key, null, null); }

      // Constructor: initializes node data and sets its subtrees
      public Node(Key key, Node left, Node right) {
         this.key   = key;
         this.left  = left;
         this.right = right;
      }
   }
   // Constructor: initializes an empty binary search tree
   public BST2() { }

   // inserts a new node in the binary search tree (BST)
   public void add (Key key ) { root = add(root, key); }

   // recursively adds a new node preserving the BST property
   private Node add (Node node, Key key) {
      if (node == null) return new Node(key);
      int cmp = key.compareTo(node.key);
      if (cmp <= 0) node.left  = add(node.left, key);
      else          node.right = add(node.right, key);
      return node;
   }

   // begin inorder traversal
   public void inorderTraversal() {
      inorderHelper(root);
   }

   // perform inorder traversal recursively
   private void inorderHelper( Node node ) {
      // YOUR CODE BELOW
      if ( node == null )  return;   // stopping condition?
      inorderHelper(node.left);  // traverse left subtree
      System.out.printf("%s ", node.key); // output node data
      inorderHelper(node.right); // traverse left subtree
   }

   //12_9 : PREORDER
   public void preorderTraversal(){
      preorderHelper(root);
   }

   private void preorderHelper(Node node) {
      if (node != null) {
         System.out.printf("%s ", node.key); // visit node first
         preorderHelper(node.left);          // then left
         preorderHelper(node.right);         // then right
      }
   }

   //12_9 : POSTORDER
   public void postorderTraversal(){
      postorderHelper(root);
   }

   private void postorderHelper(Node node) {
      if (node != null) {
         postorderHelper(node.left);          
         postorderHelper(node.right);     
         System.out.printf("%s ", node.key);    
      }
   }

   //12_12: CONTAINS
   public Key contains(Key searchKey){
      return containsHelper(root, searchKey);
   }

   private Key containsHelper(Node node, Key searchKey){
      if (node == null){
         return null;
      }

      int cmp = searchKey.compareTo(node.key);

      if (cmp == 0){
         return node.key;
      } else if (cmp < 0){
         return containsHelper(node.left, searchKey);
      } else {
         return containsHelper(node.right, searchKey);
      }
   }

   //12_14: LEVEL ORDER / QUEUE
   public void levelOrderTraversal(){
      if (root == null) return;

      Queue <Node> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()){
         Node current = queue.remove();
         System.out.printf("%s ", current.key);

         if (current.left != null){
            queue.add(current.left);
         }

         if (current.right != null){
            queue.add(current.right);
         }
      }

      System.out.println();
   }

   // BST client: outputs a sequence of integers in sorted order:
   public static void main(String[] args) {
      BST2<Integer> bst = new BST2<>();
      Integer[] keys = {21, 68, 11, 13, 17, 97};
      System.out.println("Building a BST from the following keys:");
      for (Integer key : keys) {
         System.out.printf("%d ", key);
         bst.add(key);
      }

      System.out.printf("%n%nIn-Order Tree Traversal:%n");
      bst.inorderTraversal(); 
      //System.out.printf("%n%nKeys in sorted order:%n");

      System.out.printf("%n%nPre-Order Tree Traversal:%n");
      bst.preorderTraversal();

      System.out.printf("%n%nPost-Order Tree Traversal:%n");
      bst.postorderTraversal();

      //test contains
      System.out.printf("%n%nSearch test:%n");
      System.out.println("Contains 21? " + bst.contains(21));
      System.out.println("Contains 35? " + bst.contains(35));

      //test levelorder
      System.out.printf("%nLevel-Order Tree Traversal:%n");
      bst.levelOrderTraversal();
   }
}
