package p05;

public class BSTree {
	
	private BSTNode root;
	
	class BSTNode {
		private String data;
		private BSTNode left;
		private BSTNode right;	
		
		public BSTNode (String value) {
			data = value;
			left = null;
			right = null;
		}
	}	
	
	
	public boolean find(String value, BSTNode node) {
		if (node == null) {
			return false;
		}
		if (value.equals(node.data)) {
			return true;
		} else if (value.compareTo(node.data) < 0) {
			return find(value, node.left);
		} else {
			return find(value, node.right);
		}
	}
	
	public void print(BSTNode node) {
		if (node == null) {
			return;
		}
		print(node.left);
		System.out.println(node.data);
		print(node.right);
	}
	
	public BSTNode insert(String value, BSTNode node) {
		if (node == null) {
			return new BSTNode(value);
		}
		if (value.compareTo(node.data) < 0) {
			node.left = insert(value, node.left);
			return node;
		} else {
			node.right = insert(value, node.right);
			return node;
		}
	}

	private BSTNode delete(String value, BSTNode node) {
		if (node == null) {
			return null;
		}
		
		if (node.data.compareTo(value) == 0) {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.right;
			} else {
				if (node.right.left == null) {
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				} else {
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		} else if (node.data.compareTo(node.data) < 0) {
			node.left = delete(value, node.left);
			return node;
		} else {
			node.right = delete(value, node.right);
		}
				
		return node;
	}
	
	public boolean find(String data) {
		return find(data, root);
	}
	
	public void insert(String data) {
		//Overload
		root = insert(data, root);
	}
	
	public void delete(String data) {
		//Overload
		root = delete(data, root);
	}
	
	String removeSmallest(BSTNode node) {
		if (node.left.left == null) {
			BSTNode smallest = node.left.right;
			node.left = node.left.right;
			return smallest.data;
		}
		return removeSmallest(node.left);
	}

	public String toStringInOrder(BSTNode node) {
		if (node == null) {
			return "";
		}
//		System.out.print(toStringInOrder(node.left) + "" + node.data + " " + toStringInOrder(node.right));
		return toStringInOrder(node.left) + " " + node.data + " " + toStringInOrder(node.right);
	}
	
	public String toStringInOrder() {
		return toStringInOrder(root);
	}

	public String toStringPreOrder(BSTNode node) {
		if (node == null) {
			return " ";
		}
//		System.out.println(node.data + " " + toStringPreOrder(node.left) + " " + toStringPreOrder(node.right));
		return (node.data + " "  + toStringPreOrder(node.left) + " " + toStringPreOrder(node.right));
	}
	
	public String toStringPreOrder() {
		return toStringPreOrder(root);
	}
	
//	int countNodes(BSTNode BSTNode node) {
//		if (node == null) {
//			return 0;
//		}
//		return 1 + countNodes(node.left) + countNodes(node.right);
//	}
	
//	int height(BSTNode node) {
//		if (node == null) {
//			return 0;
//		}
//		return 1 + (java.lang.math.max(height(node.left), height(node.right))));
//	}
}

