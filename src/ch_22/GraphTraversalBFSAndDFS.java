package ch_22;

import java.util.*;

/*
    Our graph structure contains a V denoting the set of vertices and an array of list adj representing the Adjacency list of the graph
 */
public class GraphTraversalBFSAndDFS {
    int V;
    List<Integer> adj[];
    char [] color;

    public GraphTraversalBFSAndDFS(int v) {
        V = v;
        adj = new List[v];
        for (int i = 0; i < v; i++)
            adj[i] = new ArrayList<>();
    }

    public void addEdge(int u, int v){ // add and edge from vertex u to vertex v
        adj[u].add(v);
    }

    /*
        BFS Algorithm -> The Breadth First Search (BFS) algorithm is a way of searching a graph for a source such that the graph is searched level by level i.e
        all the vertices at the same level will be searched before searching the next level. Here level is the distance of vertex from the source.
        Algorithm :-
            We will start from the source vertex and traverse the adjacency list of that vertex, keeping the new vertex found in queue and coloring it grey
            After traversing the list completely we will print the vertex marking that the vertex u is completely stored and move to the next vertex in the queue and repeat the same process
            We will repeat the process until the queue becomes empty marking that we have exhaustively found all the vertex reachable from the source.
            Note:- there might be the case when we print the BFS and some node doesn't get printed. This simply means that the particular node is not reachable from the source we have chosen.
     */
    public void bfs(int source){
        Queue<Integer> greyQueue = new LinkedList<>(); // queue containing the vertex which are discovered but yet to be explored
        greyQueue.add(source);
        color = new char[V]; // array marking the color of the vertex. if color = 0 it means it is not yet discovered.
        color[source] = 'G';  // If 'G' then it means it is discovered but not explored. If 'B' then it means the vertex is explored completely and we will not consider it further
        while (!greyQueue.isEmpty()){
            int i = greyQueue.poll();
            for(int j : adj[i]){
                if (color[j] == 0)
                    greyQueue.add(j);
                color[j] = 'G';
            }
            System.out.print(i + " ");
            color[i] = 'B';
        }
    }


    /*
        DFS Algorithm :- Depth First Search(DFS) Algorithm as the name suggests, will search deep down in the graph until it reaches to the point where no new node is discovered.
        At that point it will then print the node and start retracting to the previous node and visiting the other children of the parent(Repeating the above process).
         At this point we will consider the current node as Black('B').
         Note :- In dfs we traverse each node. We traverse each node one by one in the main loop. Whether to further explore it or not depends on the color of the node. If its white
         we will explore, if not we will ignore.
         Algorithm :-
            For each vertex if vertex color is white call dfsVisit on that vertex
            in dfsVisit if its adjacency list contain any new vertex (i.e white color denoted by color[u] = 0) then mark the color of that vertex as 'G' and call dfsVisit on that vertex.
            finally print the vertex. Note that since the dfsVisit will return in bottom up manner it prints the dfs from child to parent and not parent to child.
            If we want it in parent to child then we will have to print before recurse i.e print statement will become the first line of dfsVisit instead of last.
     */
    public void dfs(){
        color = new char[V]; // Colour of the vertex
        for(int i = 0; i < V; i++){ // traverse each vertex
            if (color[i] == 0) // checking if its a white node
                dfsVisit(i); // If color[i] == 0 means i is a white node so called dfsVisit on i otherwise ignore
        }
    }

    private void dfsVisit(int s){
        for(int i : adj[s]){ // checking the adjacency list of the vertex s
            if (color[i] == 0){ // found new node
                color[i] = 'G'; // mark the new node discovered as grey
                dfsVisit(i); // called dfsVisit on the new vertex found
            }
        }
        color[s] = 'B'; // All the adjacency list of the vertex s is exhausted so marking as black
        System.out.print(s + " "); // printing s
    }
}
