package main;

import java.util.ArrayList;
import java.util.Collections;
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

    public boolean isConnectedByOthers (Vertex target) {
        if (this.isConnectedTo(target)){
            return true;
        }
        else {
            for (Edge liens : this.getEdges()) {
                return liens.getTarget().isConnectedByOthers(target);
            }
        }
        return false;
    }

    public int getDistanceByOther(Vertex target) {

        int distance = 0;

        if (!this.getName().equals(target.getName())) {
            List<Integer> list_dist = new ArrayList<Integer>();

            if (this.isConnectedTo(target)){
                distance += this.getDistanceForTwoAdjacentVertices(target);
            }
            else {
                for (Edge liens : this.getEdges()) {

                    if (liens.getTarget().isConnectedByOthers(target)) {
                        list_dist.add(this.getDistanceForTwoAdjacentVertices(liens.getTarget()) + liens.getTarget().getDistanceByOther(target));
                    }
                }
                if (!list_dist.isEmpty()) {
                    distance += Collections.min(list_dist);
                }
                list_dist.clear();
            }
        }
        return distance;
    }
}
