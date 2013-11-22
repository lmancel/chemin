package test;

import main.Vertex;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class VertexTest {

    private Vertex paris = new Vertex("Paris");
    private Vertex reims = new Vertex("Reims");
    private Vertex lyon = new Vertex("Lyon");
    private Vertex clermont = new Vertex("Clermont Ferrant");
    private Vertex lille = new Vertex("Lille");
    private Vertex nancy = new Vertex("Nancy");
    private Vertex marseille = new Vertex("Marseille");
    private Vertex montpellier = new Vertex("Montpellier");


    @Test
    public void testGetName() throws Exception {
        assertEquals("Paris", paris.getName());
        assertEquals("Reims", reims.getName());

    }



    @Test
    public void testConnectTo() throws Exception {
        paris.connectTo(lyon, 465);
        paris.connectTo(clermont, 423);
        reims.connectTo(lyon, 489);

        // Il doit surement exister une manière plus élégante de faire ce test
        // en vérifiant directement la présence du Edge dans la liste

        assertEquals(paris.getEdges().get(1).getTarget(), clermont);
        assertEquals(paris.getEdges().get(1).getDistance(),423);

    }


    @Test
    public void testisConnectedTo() throws Exception {
        paris.connectTo(lyon, 465);
        paris.connectTo(clermont, 423);
        reims.connectTo(lyon, 489);

        assertEquals(paris.isConnectedTo(lyon),true);
        assertEquals(paris.isConnectedTo(lille),false);
    }

    @Test
    public void getDistanceForTwoAdjacentVertices() {
        paris.connectTo(lyon, 465);

        assertEquals(paris.getDistanceForTwoAdjacentVertices(lyon), 465);
        assertEquals(paris.getDistanceForTwoAdjacentVertices(lille), 0);
    }

    @Test
         public void testisConnectedByOthers() {
        paris.connectTo(lyon, 465);
        lyon.connectTo(marseille, 313);
        marseille.connectTo(montpellier, 169);

        assertEquals(paris.isConnectedByOthers(marseille),true);
        assertEquals(paris.isConnectedByOthers(montpellier),true);
        assertEquals(paris.isConnectedByOthers(lille),false);
    }

    @Test
    public void testgetDistanceByOthers() {
        paris.connectTo(lyon, 465);
        lyon.connectTo(montpellier, 304);
        montpellier.connectTo(marseille, 169);
        paris.connectTo(clermont, 423);
        clermont.connectTo(montpellier, 333);
        clermont.connectTo(marseille, 474);
        lyon.connectTo(marseille, 313);

        assertEquals(paris.getDistanceByOther(lyon), 465);
        assertEquals(paris.getDistanceByOther(marseille),778);
        assertEquals(paris.getDistanceByOther(montpellier),756);
        assertEquals(paris.getDistanceByOther(lille),0);
    }
}
