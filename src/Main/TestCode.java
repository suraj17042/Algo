package Main;

import ch_22.GraphTraversalBFSAndDFS;

public class TestCode {
	public static void main(String[] args) {
		GraphTraversalBFSAndDFS g = new GraphTraversalBFSAndDFS(6);
//		g.addEdge(0,1);
//		g.addEdge(0, 4);
////		g.addEdge(1, 0);
//		g.addEdge(1, 2);
//		g.addEdge(1, 3);
//		g.addEdge(1, 4);
//		g.addEdge(2, 1);
//		g.addEdge(2, 3);
//		g.addEdge(3, 4);
//		g.addEdge(3, 1);
//		g.addEdge(3, 2);
//		g.addEdge(4, 0);
//		g.addEdge(4, 1);
//		g.addEdge(4, 3);
		g.addEdge(0, 1);
		g.addEdge(0,3);
		g.addEdge(1, 4);
		g.addEdge(4, 3);
		g.addEdge(3, 1);
		g.addEdge(1, 5);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(5, 5);

		g.dfs();
	}
	private static void print(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " " );
		}
	}

	private static void print(String s){
		System.out.println(s);
	}
}
