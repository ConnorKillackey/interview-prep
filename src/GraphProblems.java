import java.util.*;

class GraphVertex {
    final private StringProblems id;
    final private StringProblems name;


    public GraphVertex(StringProblems id, StringProblems name) {
        this.id = id;
        this.name = name;
    }
    public StringProblems getId() {
        return id;
    }

    public StringProblems getName() {
        return name;
    }
}

class GraphEdge {
    private final GraphVertex source;
    private final GraphVertex destination;
    private final int weight;

    public GraphEdge(int weight, GraphVertex source, GraphVertex destination) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public GraphVertex getDestination() {
        return destination;
    }

    public GraphVertex getSource() {
        return source;
    }
}

public class Graph {
    private final List<GraphVertex> vertices;
    private final List<GraphEdge> edges;

    public Graph(List<GraphVertex> vertices, List<GraphEdge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<GraphVertex> getVertices() {
        return vertices;
    }

    public List<GraphEdge> getEdges() {
        return edges;
    }
}
