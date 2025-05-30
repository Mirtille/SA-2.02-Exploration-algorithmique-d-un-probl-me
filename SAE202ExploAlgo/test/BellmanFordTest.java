import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BellmanFordTest {

    @Test
    public void testBellmanFordDistancesEtParents() {
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);

        BellmanFord algo = new BellmanFord();
        Valeurs v = algo.resoudre(g, "A");

        assertEquals(0.0, v.getValeur("A"));
        assertEquals(12.0, v.getValeur("B"));
        assertEquals(23.0, v.getValeur("E"));
        assertEquals(66.0, v.getValeur("D"));
        assertEquals(76.0, v.getValeur("C"));

        assertEquals(null, v.getParent("A"));
        assertEquals("A", v.getParent("B"));
        assertEquals("B", v.getParent("E"));
        assertEquals("E", v.getParent("D"));
        assertEquals("D", v.getParent("C"));
    }
}
