import java.util.LinkedList;
import java.util.Queue;

//Implement Breadth First Search using queue
//In BFS,a node visits all of its neighbor first
//level order traversal 

class GraphBFS {
    int noVertices;
    LinkedList<Integer> adjacentNodes[];

    GraphBFS(int vertices) {
        noVertices = vertices;
        adjacentNodes = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i) {
            adjacentNodes[i] = new LinkedList();
        }
    }

    void addEdge(int v, int e) {
        adjacentNodes[v].add(e);
    }

    void BFS(int root) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visitedNodes[] = new boolean[noVertices];

        visitedNodes[root] = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.remove();
            if (!visitedNodes[n]) {
                visitedNodes[n] = true;
                queue.add(n);
            }
        }
    }

    public static void main(String args[]) {
        GraphBFS g = new GraphBFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(3, 3);

        g.BFS(2);
    }
}