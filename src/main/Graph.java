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
            if (ville.getName() == city) {
                town = ville;
            }
        }
        return town;
        }


    public boolean graphContains(String city) {

        Vertex ville = this.getVertex(city);

        if (ville != null)   {
            return true;
        }
        else {
            return false;
        }
    }

    public int getDistance(String from, String to) {
        Vertex departure = this.getVertex(from);
        Vertex arrival = this.getVertex(to);

        return departure.getDistanceByOther(arrival);
    }
}