package test;

import main.Vertex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class VertexTest {

    private Vertex paris = new Vertex("Paris");
    private Vertex reims = new Vertex("Reims");
    private Vertex lyon = new Vertex("Lyon");
    private Vertex clermont = new Vertex("Clermont Ferrant");

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
        assertEquals(paris.getEdges().get(1).getTarget(),clermont);
        assertEquals(paris.getEdges().get(1).getDistance(),423);

    }
}
