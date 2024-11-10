package opg3;

public class App {
    public static void main(String[] args) {
        AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph();
        adjacencyListGraph.addVertex(15);
        adjacencyListGraph.addVertex(6);
        adjacencyListGraph.addVertex(38);
        adjacencyListGraph.addVertex(123);
        adjacencyListGraph.addVertex(66);
        adjacencyListGraph.addEdge(15, 38, 10);
        adjacencyListGraph.addEdge(15, 6, 23);
        adjacencyListGraph.addEdge(15, 66, 90);
        adjacencyListGraph.addEdge(38, 66, 2);
        adjacencyListGraph.addEdge(38, 123, 55);
        adjacencyListGraph.addEdge(6, 123, 7);
        adjacencyListGraph.addEdge(6, 66, 8);
        adjacencyListGraph.addEdge(66, 123, 76);
        System.out.println("15 and 38 are adjacent: " + adjacencyListGraph.areAdjacent(15, 38));
        System.out.println("15 and 123 are adjacent: " + adjacencyListGraph.areAdjacent(15, 123));
        System.out.println("addind edge between 15 and 123");
        adjacencyListGraph.addEdge(15, 123);
        System.out.println("15 and 123 are adjacent: " + adjacencyListGraph.areAdjacent(15, 123));
        System.out.println("removing edge between 15 and 123");
        adjacencyListGraph.removeEdge(15, 123);
        System.out.println("15 and 123 are adjacent: " + adjacencyListGraph.areAdjacent(15, 123));

        System.out.println("removing vertex 15 before removing edges");
        adjacencyListGraph.removeVertex(15);
        System.out.println(adjacencyListGraph.incidentEdges(15));
        adjacencyListGraph.removeEdge(15, 38);
        adjacencyListGraph.removeEdge(15, 66);
        adjacencyListGraph.removeEdge(15, 6);
        adjacencyListGraph.removeVertex(15);
        adjacencyListGraph.printGraph();

        System.out.println("adding vertex 15 back in");
        adjacencyListGraph.addVertex(15);
        adjacencyListGraph.printGraph();

    }
}
