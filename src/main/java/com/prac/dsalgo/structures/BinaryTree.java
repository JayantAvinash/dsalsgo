package com.prac.dsalgo.structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	Node root;

	// Adding nodes in binary tree level wise using stack
	public boolean add(int a) {
		Node temp = new Node(a, null, null);
		if (root == null) {
			root = temp;
			return true;
		}
		Stack<Node> s = new Stack<Node>();
		Stack<Node> s1 = new Stack<Node>();
		s.push(root);
		while (!s.isEmpty()) {
			Node n = s.pop();
			if (n.lTree == null) {
				n.lTree = temp;
				return true;
			}
			if (n.rTree == null) {
				n.rTree = temp;
				return true;
			}
			if (s.isEmpty()) {
				s.push(n.rTree);
				s.push(n.lTree);
				while (!s1.isEmpty()) {
					s.push(s1.pop());
				}
			} else {
				s1.push(n.lTree);
				s1.push(n.rTree);
			}
		}
		return true;

	}

	// Adding nodes in binary tree level wise using queue
	public boolean addv2(int a) {
		Node temp = new Node(a, null, null);
		if (root == null) {
			root = temp;
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			if (n.lTree != null) {
				queue.add(n.lTree);
			} else {
				n.lTree = temp;
				return true;
			}
			if (n.rTree != null) {
				queue.add(n.rTree);
			} else {
				n.rTree = temp;
				return true;
			}

		}
		return true;
	}

	public int getLCA(int n1, int n2) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		List<Integer> path1 = new ArrayList<Integer>();
		List<Integer> path2 = new ArrayList<Integer>();
		boolean n1Path = getNodePath(n1, path1, root);
		boolean n2Path = getNodePath(n2, path2, root);
		if(!n1Path || !n2Path) {
			System.out.println(n1Path ? n1 + " present " + n2 + " absent" : n2 + " present " + n1 + " absent");
			return Integer.MIN_VALUE;
		}
		int i = 0;
		int pathSize = Math.min(path1.size(), path2.size());
		while(i < pathSize && path1.get(i) == path2.get(i)) {
			i++;
		}
		
		return path1.get(i - 1);
	}

	private boolean getNodePath(int n, List<Integer> path, Node node) {
		if(node == null) {
			return false;
		}
		path.add(node.val);
		if(node.val == n) {
			return true;
		}
		
		if(node.lTree != null && getNodePath(n, path, node.lTree)) {
			return true;
		}
		if(node.rTree != null && getNodePath(n, path, node.rTree)) {
			return true;
		}
		
		//if not found in both ltree and rtree; remove node from path
		path.remove(path.size() - 1);
		return false;
		
	}
	// will work only when both n1, n2 exist
	public int getLCAv2(int n1, int n2) {
		Node n = getLCAv2(root, n1, n2);
		if(n == null) {
			return Integer.MIN_VALUE;
		}
		return n.val;
	}
	
	private Node getLCAv2(Node n, int n1, int n2) {
		if(n == null) {
			return null;
		}
		if(n.val == n1 || n.val == n2) {
			return n;
		}
		Node leftLCA = getLCAv2(n.lTree, n1, n2);
		Node rightLCA = getLCAv2(n.rTree, n1, n2);
		if(leftLCA != null && rightLCA != null) {
			return n;
		} else {
			return leftLCA != null ? leftLCA : rightLCA;
		}
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node n) {
		if(n == null) {
			return 0;
		}
		int lHeight = height(n.lTree);
		int rHeight = height(n.rTree);
		if(lHeight > rHeight) {
			return lHeight + 1;
		}
		return rHeight + 1;
	}
	
	public void levelOrder() {
		int height = height();
		for(int i = 0; i < height; i++) {
			printLevel(root, i);
		}
	}
	
	private void printLevel(Node n, int i) {
		if(n == null) {
			return;
		}
		if(i == 0) {
			System.out.print(n.val + " ");
		} else {
			i--;
			printLevel(n.lTree, i);
			printLevel(n.rTree, i);
		}
	}
	
	public void levelOrderByQueue() {
		if(root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			System.out.print(n.val + " ");
			if(n.lTree != null) {
				queue.offer(n.lTree);
			}
			if(n.rTree != null) {
				queue.offer(n.rTree);
			}
		}
	}
	
	public void zigzagOrder() {
		if(root == null) {
			return;
		}
		Stack<Node> current = new Stack<>();
		Stack<Node> children = new Stack<>();
		current.push(root);
		boolean left = true;
		while(!current.isEmpty()) {
			Node n = current.pop();
			System.out.print(n.val + " ");
			if(left) {
				if(n.lTree != null) {
					children.push(n.lTree);
				}
				if(n.rTree != null) {
					children.push(n.rTree);
				}
			} else {
				if(n.rTree != null) {
					children.push(n.rTree);
				}
				if(n.lTree != null) {
					children.push(n.lTree);
				}
			}
			if(current.isEmpty()) {
				Stack<Node> temp = current;
				current = children;
				children = temp;
				left = !left;
			}
		}
	}
	
	//delete node and replace it with most extreme leaf node
	public boolean deleteNode(int n) {
		if(root == null) {
			return false;
		}
		if(root.val == n && height() == 1) {
				root = null;
				return true;
		}
		Queue<ParentChild> queue = new LinkedList<ParentChild>();
		queue.add(new ParentChild(null, root));
		ParentChild remove = null;
		ParentChild last = null;
		while(!queue.isEmpty()) {
			last = queue.poll();
			if(last.current.val == n) {
				remove = last;
			}
			if(last.current.lTree != null) {
				queue.offer(new ParentChild(last.current, last.current.lTree));
			}
			if(last.current.rTree != null) {
				queue.offer(new ParentChild(last.current, last.current.rTree));
			}
		}
		if(remove == null) {
			return false;
		}
		
		remove.current.val = last.current.val;
		if(last.Parent != null) {
			if(last.Parent.rTree != null && last.Parent.rTree.val == last.current.val) {
				last.Parent.rTree = null;
			} else {
				last.Parent.lTree = null;
			}
		}
		
		return true;
	}
	
	class ParentChild{
		Node Parent;
		Node current;
		public ParentChild(Node parent, Node child) {
			super();
			Parent = parent;
			this.current = child;
		}
		
	}
	
	boolean checkBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(root.val < min || root.val > max) {
            return false;
        }
        return isBSTUtil(root.lTree, min, root.val - 1) || isBSTUtil(root.rTree, root.val + 1, max);
    }

	public void Preorder(Node root1) {
		if (root1 == null) {
			return;
		}
		System.out.print(root1.val + " ");
		if (root1.lTree != null) {
			Preorder(root1.lTree);
		}
		if (root1.rTree != null) {
			Preorder(root1.rTree);
		}
	}

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		b.add(1);
		b.Preorder(b.root);
		b.add(2);
		System.out.println();
		b.Preorder(b.root);
		b.add(3);
		System.out.println();
		b.Preorder(b.root);
		b.add(4);
		System.out.println();
		b.Preorder(b.root);
		b.add(5);
		System.out.println();
		b.Preorder(b.root);
		b.add(6);
		System.out.println();
		b.Preorder(b.root);
		b.add(7);
		System.out.println();
		b.Preorder(b.root);
		System.out.println();
		b.add(8);
		System.out.println();
		b.Preorder(b.root);
		System.out.println();
		System.out.println(b.getLCAv2(3, 7));
		System.out.println(b.height());
		b.levelOrder();
		System.out.println();
		b.levelOrderByQueue();
		System.out.println();
		b.deleteNode(9);
		b.levelOrderByQueue();
		System.out.println();
		b.zigzagOrder();
	}

	class Node {
		int val;
		Node lTree;
		Node rTree;

		Node(int val, Node lTree, Node rTree) {
			super();
			this.val = val;
			this.lTree = lTree;
			this.rTree = rTree;
		}

	}
}
