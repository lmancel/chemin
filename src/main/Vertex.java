package main;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;

    private List<Edge> edges = new ArrayList<Edge>();

    public Vertex(String name) {
        this.name = name;
        this.edges = new ArrayList<Edge>();
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void connectTo(Vertex target, int distance) {
        edges.add(new Edge(target, distance));
    }

    public boolean isConnectedTo (Vertex target) {

        for (Edge lien : this.getEdges()) {
            if (lien.getTarget() == target) {
                return true;
            }
        }
        return false;
    }

    public int getDistanceForTwoAdjacentVertices(Vertex target)  {

        for (Edge lien : this.getEdges()) {
            if (lien.getTarget() == target) {
                return lien.getDistance();
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name  +
                '}';
    }
}
