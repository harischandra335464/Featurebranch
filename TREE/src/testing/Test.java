package testing;

import Tree.BinaryTree;
import node.Node;

public class Test {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		Node root = null;
		Node root2 = null;
		Node root3 = null;
		Node root4 = null;

		root3 = bt.insert(root3,7);
		root3 = bt.insert(root3,2);
		root3 = bt.insert(root3,3);
		root3 = bt.insert(root3,4);
		root3 = bt.insert(root3,5);
		root3 = bt.insert(root3,6);

		root3 = bt.insert(root3,1);
		root3 = bt.insert(root3,8);
		root3 = bt.insert(root3,9);
		root3 = bt.insert(root3,10);
		root3 = bt.insert(root3,11);
		root3 = bt.insert(root3,12);

	
		
		
		
		root = bt.insert(root,3);
		root = bt.insert(root,1);
		root = bt.insert(root,2);
		root = bt.insert(root,5);
		root = bt.insert(root,4);
		root = bt.insert(root,6);
		root = bt.insert(root,0);
		
		root4 = bt.insert(root4,3);
		root4 = bt.insert(root4,1);
		root4 = bt.insert(root4,0);
		root4 = bt.insert(root4,5);
		root4 = bt.insert(root4,6);
		root4 = bt.insert(root4,4);		
		
		root2 = bt.insert(root2,3);
		root2 = bt.insert(root2,1);
		root2 = bt.insert(root2,7);
		root2 = bt.insert(root2,2);
		root2 = bt.insert(root2,8);
		root2 = bt.insert(root2,18);
	
		
		
		
/*---------------------------------------------------	Display	---------------------------------------------------------------- */
		bt.display(root);
		System.out.println("");
		bt.display(root2);
		System.out.println("");
	
/*---------------------------------------------------	isIdentical-----------------------------------------------------------*/	
		System.out.println("two tree are identical   " + bt.isIdentical(root, root2,true));
 
/*---------------------------------------------------	HEIGHT						*/			
		System.out.println("height of given tree root is "+ bt.findHeight(root2));
		

/*---------------------------------------------------Inorder,preorder,postorder----------------------------------------------------------*/
		
		bt.Inorder(root2);
		System.out.println("Inorder traversal is======================================\n");
		bt.Preorder(root2);
		System.out.println("preorder traversal is======================================\n");
		bt.Postorder(root2);
		System.out.println("postrder traversal is======================================\n");
		
		
/*---------------------------------------------------DeleteAll Nodes----------------------------------------------------------*/
		System.out.println("");
		root2= bt.deleteBinaryTree(root2);
		System.out.println("BinaryTree after deletion");
		bt.display(root2);
		
/*---------------------------------------------------Level Order Tree Traversal----------------------------------------------------------
 * use Queue
 * */
		System.out.println("Inorder traversal is======================================\n");
		bt.Inorder(root);
		System.out.println("");
		System.out.println("");
		System.out.println("levelOrder traversal is======================================\n");
		bt.levelOrderTraversal(root3);	
		
/*---------------------------------------------------Spiral Order Tree Traversal----------------------------------------------------------
 * Modification of Level order
 * */		
			System.out.println("");
			System.out.println("SpiralOrder traversal is======================================\n");
			bt.spiralTraversal(root3);
			
	
/*---------------------------------------------------Reverse level Order Tree Traversal----------------------------------------------------------*/		
			System.out.println("");
			System.out.println("Reverse levelorder traversal is======================================\n");			
			bt.reverseLevelOrderTraversal(root);

/*---------------------------------------------------count total number nodes in tree----------------------------------------------------------
 * Modification of inorder/preorder/postorder
 * */		
			System.out.println("");
			System.out.println("total count is======================================\n");
			System.out.println(bt.totalNodes(root));
	
	
/*---------------------------------------------------find the dippest node in tree----------------------------------------------------------
 * modification of Inorder
 * */		
	System.out.println("");
	System.out.println("dippest node is======================================\n");
	bt.dipestNode(root4,0);
	System.out.println(bt.getValue());
	
	System.out.println("");
	System.out.println("LeftView of node is======================================\n");
	bt.leftView(root4,0);

	
/*---------------------------------------------------vertical order traversal of node in tree----------------------------------------------------------
 * Hint use MAP and Queue
 */		

	System.out.println("");
	System.out.println("Vertical Order Traversal of tree is======================================\n");
	bt.findVerticalOrder(root4,0);
	
}
	
}
