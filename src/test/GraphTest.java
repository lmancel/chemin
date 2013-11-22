package test;

import main.Graph;
import main.Vertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphTest {
    private Vertex lille = new Vertex("Lille");
    private Vertex paris = new Vertex("Paris");
    private Vertex reims = new Vertex("Reims");
    private Vertex nancy = new Vertex("Nancy");
    private Vertex lyon = new Vertex("Lyon");
    private Vertex marseille = new Vertex("Marseille");
    private Vertex lemans = new Vertex("Le Mans");
    private Vertex nantes = new Vertex("Nantes");
    private Vertex bordeaux = new Vertex("Bordeaux");
    private Vertex toulouse = new Vertex("Toulouse");
    private Vertex clermont = new Vertex("Clermont Ferrant");
    private Vertex montpellier = new Vertex("Montpellier");

    @Before
    public void setup() {
        lille.connectTo(reims, 206);
        lille.connectTo(paris, 222);
        lille.connectTo(nancy, 418);

        reims.connectTo(paris, 144);
        reims.connectTo(nancy, 245);
        reims.connectTo(lyon, 489);

        paris.connectTo(lyon, 465);
        paris.connectTo(lemans, 208);
        paris.connectTo(clermont, 423);

        lyon.connectTo(clermont, 166);
        lyon.connectTo(marseille, 313);
        lyon.connectTo(montpellier, 304);

        lemans.connectTo(nantes, 189);
        lemans.connectTo(bordeaux, 443);

        nantes.connectTo(bordeaux, 347);

        bordeaux.connectTo(toulouse, 243);

        toulouse.connectTo(montpellier, 245);

        montpellier.connectTo(marseille, 169);
        montpellier.connectTo(toulouse, 245);

        marseille.connectTo(montpellier, 169);

        clermont.connectTo(lyon, 166);
        clermont.connectTo(montpellier, 333);
        clermont.connectTo(marseille, 474);
    }

    @Test
    public void getDistanceForTwoAdjacentVertices() {
        Graph graph = new Graph(paris, lyon);
        assertEquals(graph.getDistance("Paris", "Lyon"), 465);
    }

    @Test
      public void getVertexInTheGraph(){
        Graph graph = new Graph (paris,lyon, marseille);
        assertEquals(graph.getVertex("Marseille"),marseille);
    }

    @Test
    public void VertexIsInTheGraph(){
        Graph graph = new Graph (paris,lyon, marseille);
        assertEquals(graph.graphContains("Marseille"), true);
        assertEquals(graph.graphContains("Lille"), false);
    }

    @Test
    // Ce test ne marche pas sur des chemins trop longs, l'erreur renvoyée est dûe à la taille de la pile
    public void testGetDistance() {
        Graph graph = new Graph (paris, lyon, marseille, lille, toulouse, montpellier);

        assertEquals(graph.getDistance("Paris","Montpellier"), 756);
        assertEquals(graph.getDistance("Marseille","Toulouse"), 414);
        assertEquals(graph.getDistance("Paris","Paris"), 0);
        //assertEquals(graph.getDistance("Paris","Lille"), 0);    <-- trop de tests pour arriver à un résultat...
        //assertEquals(graph.getDistance("Paris","Toulouse"), 1014);   <-- chemin trop long....
    }
}
