package opg3;

import java.util.*;

/**
 * Adjacency list implementation of the graph interface.
 */
public class AdjacencyListGraph<V> implements Graph<V> {
    // List with all the vertices in the graph.
    private List<V> vertices;
    // Map with pairs containing (vertex, list of edges),
    // where list of edges is the incident edges to the vertex.
    // Note: Each edge is in 2 lists of incident edges.
    private Map<V, List<Edge<V>>> edges;

    //-----------------------------------------------------

    /**
     * Construct an empty AdjacencyListGraph.
     */
    public AdjacencyListGraph() {
        vertices = new ArrayList<>();
        edges = new LinkedHashMap<>();
    }

    /**
     * Return a list with the vertices in the graph.
     */
    @Override
    public List<V> vertices() {
        return new ArrayList<>(vertices);
    }

    /**
     * Return a list with the edges in the graph.
     */
    @Override
    public List<Edge<V>> edges() {
        Set<Edge<V>> edgeSet = new HashSet<>();
        for (List<Edge<V>> valueList : edges.values()) {
            for (Edge<V> edge : valueList) {
                edgeSet.add(edge);
            }
        }

        return new ArrayList<>(edgeSet);
    }

    /**
     * Return a list with the neighbors of the specified vertex.
     * Pre: The vertex is in the graph.
     */
    @Override
    public List<V> neighbors(V v) {
        assert vertices.contains(v);
        List<V> neighbors = new ArrayList<>();
        for (Edge<V> edge : incidentEdges(v)) {
            if (edge.getV().equals(v)) neighbors.add(edge.getU());
            else neighbors.add(edge.getU());
        }

        return neighbors;

    }

    /**
     * Return the degree for the specified vertex.
     * Pre: The vertex is in the graph.
     */
    @Override
    public int degree(V v) {
        return incidentEdges(v).size();
    }

    /**
     * Return the incident edges to the specified vertex.
     * Pre: The vertex is in the graph.
     */
    @Override
    public List<Edge<V>> incidentEdges(V v) {
        List<Edge<V>> edges = new ArrayList<>();
        for (Edge<V> edge : this.edges.get(v)) {
            if (edge.getV().equals(v) || edge.getU().equals(v)) edges.add(edge);
        }
        return edges;
    }

    /**
     * Return true, if the specified vertices are neighbors.
     * Pre: The vertices are vertices in the graph.
     */
    @Override
    public boolean areAdjacent(V u, V v) {
        boolean adjacent = false;
        for (Edge<V> edge : incidentEdges(u)) {
            if (edge.getU().equals(v) || edge.getV().equals(v)) adjacent = true;
        }

        return adjacent;
    }


    /**
     * Print the vertices and the edges.
     */
    @Override
    public void printGraph() {
        for (V v : vertices) {
            List<Edge<V>> incidentEdges = edges.get(v);
            System.out.print("Vertex: " + v);
            System.out.println("\tIncident edges: " + incidentEdges);
        }
    }

    /**
     * Add a vertex to the graph.
     * Pre: The vertex is not in the graph before this addition.
     */
    @Override
    public void addVertex(V v) {
        assert !vertices.contains(v);
        vertices.add(v);
    }

    /**
     * Add an edge with the specified weight between the specified vertices to the graph.
     * Pre: Before addition, the vertices are in the graph, and the edge is not in the graph.
     * Pre: The weight is not negative.
     */
    @Override
    public Edge<V> addEdge(V u, V v, int weight) {
        assert weight >= 0;
        assert vertices.contains(u) && vertices.contains(v);
        Edge<V> edge = new Edge<>(u, v, weight);
        assert !edges.containsValue(edge);
        if (edges.get(v) == null) edges.put(v, new ArrayList<>());
        if (edges.get(u) == null) edges.put(u, new ArrayList<>());
        edges.get(v).add(edge);
        edges.get(u).add(edge);
        return edge;
    }

    /**
     * Add an edge with weight 0 between the specified vertices to the graph.
     * Pre: Before addition, the vertices are in the graph, and the edge is not in the graph.
     */
    @Override
    public Edge<V> addEdge(V u, V v) {
        return addEdge(v, u, 0);
    }

    /**
     * Remove the specified vertex from the graph.
     * Pre: The vertex is in the graph, and the vertex has no incident edges.
     */
    @Override
    public void removeVertex(V v) {
        assert vertices.contains(v);
        assert incidentEdges(v).isEmpty();
        vertices.remove(v);
    }

    /**
     * Remove the edge between the specified vertices from the graph.
     * Pre: The vertices are vertices in the graph,
     * and The graph has an edge between the vertices.
     */
    @Override
    public void removeEdge(V u, V v) {
        assert vertices.contains(v) && vertices.contains(u);
        assert areAdjacent(v, u);
        Edge<V> edge = new Edge<>(u, v);
        edges.get(v).remove(edge);
        edges.get(u).remove(edge);
    }
}
