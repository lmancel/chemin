package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Graph {
    private List<Vertex> vertices = new ArrayList<Vertex>();

    public Graph(Vertex... vertices) {
        this.vertices.addAll(Arrays.asList(vertices));
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public Vertex getVertex(String city){

        Vertex town = null;
        for (Vertex ville : this.getVertices()) {
            if (ville.getName().equals(city)) {
                town = ville;
            }
        }
        return town;
    }


    public boolean graphContains(String city) {

        Vertex ville = this.getVertex(city);

        return ville != null;
    }

    public int getDistance(String from, String to) {
        if (this.graphContains(from) && this.graphContains(to)) {
            Vertex departure = this.getVertex(from);
            Vertex arrival = this.getVertex(to);
            return departure.getDistanceByOther(arrival);
        }
        else {
            return 0;
        }
    }
}