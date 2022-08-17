package Main;

import ch_10.Queue;
import ch_10.Stack;
import ch_12.BinarySearchTree;
import ch_12.TreeNode;
import ch_6.PriorityQueue;
import ch_7.Quicksort;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCode {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(null, null, null, 20);
		BinarySearchTree tree = new BinarySearchTree(root);
		tree.insert(10);
		tree.insert(5);
		tree.insert(0);
		tree.insert(6);
		tree.insert(30);
		tree.insert(9);
//		tree.insert(12);
		TreeNode node = tree.searchRecursively(root, 9);

		tree.delete(node);
		tree.inorder(root);
		System.out.println();
		tree.preorder(root);


	}
	private static void print(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " " );
		}
	}
}
