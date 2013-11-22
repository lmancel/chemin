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
                 if (liens.getTarget().isConnectedByOthers(target)) {
                     return true;
                 }
                else {
                     return false;
                 }
            }
        }
        return false;
    }

    public int getDistanceByOther(Vertex target) {

        int distance = 0;
        List list_dist = new ArrayList();
        List passedby = new ArrayList();
        List way = new ArrayList();

        way.add(this);

        if (this.isConnectedTo(target)){
            distance +=this.getDistanceForTwoAdjacentVertices(target);
            return distance;
        }
        else {
            for (Edge liens : this.getEdges()) {
                if (liens.getTarget().isConnectedByOthers(target)) {
                    list_dist.add(liens.getDistance());

                }
                /*if (liens.getTarget().isConnectedTo(target)) {

                    distance += this.getDistanceForTwoAdjacentVertices(liens.getTarget()) + liens.getTarget().getDistanceForTwoAdjacentVertices(target);
                    list_dist.add(distance);
                    return (Integer) Collections.min(list_dist);
                } */

                /*else */if (liens.getTarget().isConnectedByOthers(target)) {
                    if (passedby.contains(this) == false) {
                        passedby.add(this);
                        distance += this.getDistanceForTwoAdjacentVertices(liens.getTarget()) + liens.getTarget().getDistanceByOther(target);
                        return distance;
                    }
                }
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
