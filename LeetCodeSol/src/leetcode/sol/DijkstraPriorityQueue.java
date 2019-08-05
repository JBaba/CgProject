public class DijkstraPriorityQueue {

    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private int V; // Number of vertices
    List<List<Node> > adj;

    public DijkstraPriorityQueue(int V)
    {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<>();
        pq = new PriorityQueue<>(V, new Node());
    }

    // Driver code
    public static void main(String arg[])
    {
        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges
        List<List<Node> > adj = new ArrayList<>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        // Calculate the single source shortest path
        DijkstraPriorityQueue dpq = new DijkstraPriorityQueue(V);
        dpq.dijkstra(adj, source);

        // Print the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.dist[i]);
    }

    private void dijkstra(List<List<Node>> adj, int source) {
        this.adj = adj;

        for(int i=0;i<V;i++)
            dist[i] = Integer.MAX_VALUE;

        Node node = new Node(source,0);
        pq.add(node);

        dist[source] = 0;

        while (!pq.isEmpty()){

            int u = pq.remove().node;

            settled.add(u);

            neighbors(u);

        }

    }

    private void neighbors(int u) {

        for(int i=0;i<adj.get(u).size();i++){

            Node neighbor = adj.get(u).get(i);

            if(!settled.contains(neighbor.node)){

                int dis = dist[u] + neighbor.cost;

                if(dist[neighbor.node] > dis){
                    dist[neighbor.node] = dis;
                }

                pq.add(new Node(neighbor.node,dist[neighbor.node]));

            }

        }

    }
}

// Class to represent a node in the graph
class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node()
    {
    }

    public Node(int node, int cost)
    {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2)
    {
        return Integer.compare(node1.cost,node2.cost);
    }
}
