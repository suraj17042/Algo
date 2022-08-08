package ch_12;

public class BinarySearchTree {
	TreeNode root;

	public BinarySearchTree(TreeNode root) {
		super();
		this.root = root;
	}
	
	public void insert(int value) {
		TreeNode newNode = new TreeNode(null, null, null, value);
		TreeNode myNode = root;
		while(true) {
			if (myNode.getKey() > value) {
				if (myNode.getLeftChild() != null) {
					myNode = myNode.getLeftChild();
				}
				else {
					newNode.setParent(myNode);
					myNode.setLeftChild(newNode);
					break;
				}
			}
			else {
				if (myNode.getRightChild() != null) {
					myNode = myNode.getRightChild();
				}
				else {
					newNode.setParent(myNode);
					myNode.setRightChild(newNode);
					break;
				}
			}
		}
	}
	
	public TreeNode searchRecursively(TreeNode root, int k) {
		TreeNode myNode = root;
		if (myNode == null) {
			return null;
		}
		if (myNode.getKey() == k) {
			return myNode;
		}
		else if(myNode.getKey() > k) {
			return searchRecursively(myNode.getLeftChild(), k);
		}
		else {
			return searchRecursively(myNode.getRightChild(), k);
		}
	}
	
	public TreeNode searchIteratively(TreeNode root, int k) {
		while (root != null) {
			if (root.getKey() == k)
				return root;
			else if (root.getKey() > k)
				root = root.getLeftChild();
			else
				root = root.getRightChild();
		}
		return root;
	}
	
	public void inorder(TreeNode node) {
		if(node == null)
			return;
		inorder(node.getLeftChild());
		System.out.print(node.getKey() + " ");
		inorder(node.getRightChild());
	}
	
	public void preorder(TreeNode node) {
		if(node == null)
			return;
		System.out.print(node.getKey() + " ");
		preorder(node.getLeftChild());
		preorder(node.getRightChild());
	}
	
	public void postorder(TreeNode node) {
		if(node == null)
			return;
		postorder(node.getLeftChild());
		postorder(node.getRightChild());
		System.out.print(node.getKey() + " ");
	}
	
}
