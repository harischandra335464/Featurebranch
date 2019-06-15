package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import node.Node;

public class BinaryTree {
	int value, dippest = 0; // to find dippest node in tree
	int visitedlevel = -1;
	TreeMap<Integer, List<Integer>> map = new TreeMap();

	public int getValue() {
		return value;
	}

	public Node createNode(int val) {
		Node node1 = new Node();

		node1.setData(val);
		node1.setLeft(null);
		node1.setRight(null);
		return node1;
	}

	public boolean isIdentical(Node node1, Node node2, boolean flag) {

		if ((node1 == null) && (node2 != null) || (node2 == null) && (node1 != null)) {
			return flag = false;
		}

		else if ((node1 == null) && (node2 == null)) {
			return flag;
		}

		else if ((node1.getData() != node2.getData())) {
			return flag = false;
		}

		flag = isIdentical(node1.getLeft(), node2.getLeft(), flag);
		flag = isIdentical(node1.getRight(), node2.getRight(), flag);

		return flag;
	}

	public Node insert(Node current, int val) {

		if (current == null) {
			return createNode(val);
		}

		else if (val < current.getData())
			current.setLeft(insert(current.getLeft(), val));
		else if (val > current.getData())
			current.setRight(insert(current.getRight(), val));

		else
			return current;
		return current;

	}

	public void display(Node node) {

		if (node == null) {
			return;
		}
		System.out.print(node.getData() + "      ");
		display(node.getLeft());
		display(node.getRight());

	}

	public int findHeight(Node node) {

		if (node == null) {
			return 0;
		}

		int h1 = findHeight(node.getLeft());
		int h2 = findHeight(node.getRight());

		return (h1 >= h2 ? h1 : h2) + 1;

	}

	public void Inorder(Node node) {

		if (node == null) {
			return;
		}
		Inorder(node.getLeft()); // (Left,syso(Root),Right)
		System.out.print(node.getData() + "      ");
		Inorder(node.getRight());

	}

	public void Preorder(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		System.out.print(node.getData() + "      "); // (syso(Root),Left,Right)
		Preorder(node.getLeft());
		Preorder(node.getRight());
	}

	public void Postorder(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		// (Left,Right,syso(Root))
		Postorder(node.getLeft());
		Postorder(node.getRight());
		System.out.print(node.getData() + "      ");
	}

	public Node deleteBinaryTree(Node node) {

		if (node == null) {
			return null;
		}
		// (Left,Right,syso(Root))
		deleteBinaryTree(node.getLeft());
		deleteBinaryTree(node.getRight());
		node = null;

		return node;

	}

	public void levelOrderTraversal(Node root) {

		if (root != null) {
			Node node;
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				if (queue.peek().getLeft() != null) {
					queue.add(queue.peek().getLeft());
				}
				if (queue.peek().getRight() != null) {
					queue.add(queue.peek().getRight());
				}

				System.out.print(queue.remove().getData() + "    ");
			}
		}

	}

	public void spiralTraversal(Node root) {

		Stack<Node> s1 = new Stack(); // odd
		Stack<Node> s2 = new Stack(); // even
		// Node node;
		s1.push(root);

		/*
		 * while ((!s1.empty()) || (!s2.empty())) {
		 * 
		 * while (!s1.empty()) { node = s1.peek(); s1.pop();
		 * System.out.print(node.getData()+"  ");
		 * 
		 * if (node.getRight() != null) s2.push(node.getRight()); if (node.getLeft() !=
		 * null) s2.push(node.getLeft());
		 * 
		 * } while (!s2.empty()) { node = s2.peek(); s2.pop();
		 * System.out.print(node.getData()+"  ");
		 * 
		 * if (node.getLeft() != null) s1.push(node.getLeft()); if (node.getRight() !=
		 * null) s1.push(node.getRight());
		 * 
		 * }
		 */

		/*
		 * int oddeven = 1; if (root != null) { Node node; Deque<Node> queue = new
		 * LinkedList<>(); queue.add(root); boolean flag = true;
		 * 
		 * while (!queue.isEmpty()) { int nodecount = queue.size(); while (nodecount !=
		 * 0 && flag) { node = queue.removeFirst(); if (node.getLeft() != null)
		 * queue.addLast(node.getLeft()); if (node.getRight() != null)
		 * queue.addLast(node.getRight()); System.out.print(node.getData() + "    ");
		 * nodecount--; } while (nodecount != 0 && flag == false) { node =
		 * queue.removeLast(); if (node.getRight() != null)
		 * queue.addFirst(node.getRight()); if (node.getLeft() != null)
		 * queue.addFirst(node.getLeft()); System.out.print(node.getData() + "    ");
		 * nodecount--; } flag = !flag;
		 * 
		 * } }
		 */

		int oddeven = 1;
		if (root != null) {
			Node node1 = null;
			Node node2 = null;
			Deque<Node> queue = new LinkedList<>();
			queue.add(root.getLeft());
			queue.add(root.getRight());
			System.out.println(root.getData());
			boolean flag = true;

			while (!queue.isEmpty()) {
				int nodecount = queue.size();
				while (nodecount != 0) {

					if (!queue.isEmpty()) {
						node1 = queue.removeFirst();
						if (!queue.isEmpty())
							node2 = queue.removeFirst();

						if (node1.getLeft() != null)
							queue.addLast(node1.getLeft());
						if (node2.getRight() != null)
							queue.addLast(node2.getRight());
						if (node1.getRight() != null)
							queue.addLast(node1.getRight());
						if (node2.getLeft() != null)
							queue.addLast(node2.getLeft());

						System.out.print("  " + node1.getData() + "  " + node2.getData());
						nodecount--;
					}

				}
			}
		}

	}

	public void reverseLevelOrderTraversal(Node root) {

		if (root != null) {
			Node node;
			Queue<Node> queue = new LinkedList<>();
			Stack<Integer> s = new Stack<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				if (queue.peek().getLeft() != null) {
					queue.add(queue.peek().getLeft());
				}
				if (queue.peek().getRight() != null) {
					queue.add(queue.peek().getRight());
				}
				s.push(queue.remove().getData());
			}
			while (!s.empty())
				System.out.print(s.pop() + "   ");

		}

	}

	public int totalNodes(Node node) {
		if (node == null) {
			return 0;
		}
		// return totalNodes(node.getLeft()) + totalNodes(node.getRight()) + 1;
		int h1 = totalNodes(node.getLeft());
		int h2 = totalNodes(node.getRight());

		return (h1 + h2 + 1);

	}

	public void dipestNode(Node node, int level) {

		if (node == null)
			return;

		dipestNode(node.getLeft(), ++level);
		if (level > dippest) {
			value = node.getData();
			dippest = level;
		}
		dipestNode(node.getRight(), level);
	}

	public void leftView(Node node, int level) {
		// TODO Auto-generated method stub
		if (node == null) {
			visitedlevel--;
			return;

		}
		if (level != visitedlevel) {
			System.out.print(node.getData() + "      ");
			visitedlevel = level;
		}
		leftView(node.getLeft(), ++level);
		leftView(node.getRight(), level);
	}

	
	public void findVerticalOrder(Node node, int level) {
		verticalOrder(node,level);
		map.forEach((k,v)->System.out.println("(distance,node)" + k+","+v));
		
	}
	
	public void verticalOrder(Node node, int level) {

		if (node == null) {
			return;
		}
		List<Integer> nodelist = null;
		if (map.containsKey(level))
			nodelist = map.get(level);
		else
			nodelist = new ArrayList<>();

		nodelist.add(node.getData());
		map.put(level, nodelist);
		verticalOrder(node.getLeft(),level-1);
		verticalOrder(node.getRight(),level+1);
	}

}
