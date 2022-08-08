package ch_12;

public class TreeNode {
	private TreeNode leftChild;
	private TreeNode rightChild;
	private TreeNode parent;
	private int key;
	public TreeNode(TreeNode leftChild, TreeNode rightChild, TreeNode parent, int key) {
		super();
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.parent = parent;
		this.key = key;
	}
	public TreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public TreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "TreeNode [key=" + key + "]";
	}
	
	

}
