public class App {
    public static void main(String[] args) {
        EdgeListGraph<Integer> edgeListGraph = new EdgeListGraph<>();
        edgeListGraph.addVertex(15);
        edgeListGraph.addVertex(6);
        edgeListGraph.addVertex(38);
        edgeListGraph.addVertex(123);
        edgeListGraph.addVertex(66);
        edgeListGraph.addEdge(15, 6, 23);
        edgeListGraph.addEdge(15, 66, 90);
        edgeListGraph.addEdge(15, 38, 10);
        edgeListGraph.addEdge(38, 123, 55);
        edgeListGraph.addEdge(38, 66, 2);
        edgeListGraph.addEdge(6, 66, 8);
        edgeListGraph.addEdge(6, 123, 7);
        edgeListGraph.addEdge(66, 123, 76);
        edgeListGraph.printGraph();
        System.out.println("degree for 6: " + edgeListGraph.degree(6));
        System.out.println("edges for 6: " + edgeListGraph.incidentEdges(6));
        System.out.println("neighbours for 6: " + edgeListGraph.neighbors(6));
        System.out.println("6 and 66 are neighbours: " + edgeListGraph.areAdjacent(6, 66));
        System.out.println("6 and 38 are neighbours: " + edgeListGraph.areAdjacent(6, 38));
        System.out.println("largest: "+ findLargest(edgeListGraph));
        edgeListGraph.removeEdge(15,38);
        System.out.println("neighroursghigf: " + edgeListGraph.incidentEdges(15));
    }

    private static int findLargest(EdgeListGraph<Integer> graph) {
        int largest = 0;
        for (Integer vertex : graph.vertices()) {
            if (vertex > largest) largest = vertex;
        }

        return largest;
    }
}