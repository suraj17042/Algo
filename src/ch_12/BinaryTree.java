package ch_12;

public class BinaryTree {
	TreeNode root;

	public BinaryTree(TreeNode root) {
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
