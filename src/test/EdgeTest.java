package test;

import main.Edge;
import main.Vertex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class EdgeTest {

    private Vertex paris = new Vertex("Paris");

    private Edge edge_paris = new Edge(paris, 300);


    @Test
    public void testGetTarget() throws Exception {
        assertEquals(paris, edge_paris.getTarget());

    }

    @Test
    public void testGetDistance() throws Exception {
        assertEquals(300, edge_paris.getDistance());
    }
}
