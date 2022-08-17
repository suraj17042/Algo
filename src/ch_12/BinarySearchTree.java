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

	public void delete(TreeNode node){
		if (node.getLeftChild() == null && node.getRightChild() == null)
			deleteNodeWithNochild(node);
		else if (node.getRightChild() == null || node.getLeftChild() == null)
			deleteNodeWithOneChild(node);
		else deleteNodeWithTwoChild(node);

	}

	private void deleteNodeWithNochild(TreeNode node){
		if (node.getParent().getLeftChild() == node)
			node.getParent().setLeftChild(null);
		else node.getParent().setRightChild(null);
		node.setParent(null);
	}

	private void deleteNodeWithTwoChild(TreeNode node){
		TreeNode successorNode = successor(node);
		node.setKey(successorNode.getKey());
		delete(successorNode);
	}

	private void deleteNodeWithOneChild(TreeNode node){
		TreeNode childNode = null;
		if (node.getLeftChild() == null){
			childNode = node.getRightChild();
			node.setRightChild(null);
		}
		else{
			childNode = node.getLeftChild();
			node.setLeftChild(null);
		}
		if (node.getParent().getLeftChild() == node){
			node.getParent().setLeftChild(childNode);
			childNode.setParent(node.getParent());
		}
		else {
			node.getParent().setRightChild(childNode);
			childNode.setParent(node.getParent());
		}
	}

	public TreeNode searchRecursively(TreeNode root, int k) {
		TreeNode myNode = root;
		if (myNode == null || myNode.getKey() == k) {
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

	public TreeNode minimum(TreeNode root){
		while (root.getLeftChild() != null){
			root = root.getLeftChild();
		}
		return root;
	}

	public TreeNode maximum(TreeNode root){
		TreeNode myNode = root;
		while (myNode.getRightChild() != null)
			myNode = myNode.getRightChild();
		return myNode;
	}

	public TreeNode successor(TreeNode node){
		if (node.getRightChild() != null){
			return minimum(node.getRightChild());
		}
		TreeNode parent = node.getParent();
		while (parent != null && node == parent.getRightChild()){
			node = parent;
			parent = parent.getParent();
		}
		return parent;
	}

	public TreeNode predecessor(TreeNode node){
		if (node.getLeftChild() != null){
			return maximum(node.getLeftChild());
		}
		TreeNode parent = node.getParent();
		while (parent != null && node == parent.getLeftChild()){
			node = parent;
			parent = parent.getParent();
		}
		return parent;
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
