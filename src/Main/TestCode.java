package Main;

import ch_10.Queue;
import ch_10.Stack;
import ch_12.BinaryTree;
import ch_12.TreeNode;
import ch_6.PriorityQueue;
import ch_7.Quicksort;

public class TestCode {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(null, null, null, 20);
		BinaryTree tree = new BinaryTree(root);
		tree.insert(10);
		tree.insert(5);
		tree.insert(0);
		tree.insert(6);
		tree.insert(9);
		tree.insert(12);
		tree.inorder(root);
		System.out.println();
		tree.preorder(root);
		System.out.println();
		tree.postorder(root);
	}
	private static void print(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " " );
		}
	}
}
