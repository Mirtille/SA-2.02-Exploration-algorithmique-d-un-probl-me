
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GrapheListeTest {

        @Test
        public void testAjoutArcEtListeNoeuds() {
            GrapheListe g = new GrapheListe();

            g.ajouterArc("A", "B", 12);
            g.ajouterArc("A", "D", 87);
            g.ajouterArc("B", "E", 11);

            List<String> noeuds = g.listeNoeuds();
            assertTrue(noeuds.contains("A"));
            assertTrue(noeuds.contains("B"));
            assertTrue(noeuds.contains("D"));
            assertTrue(noeuds.contains("E"));
            assertEquals(4, noeuds.size());
        }

        @Test
        public void testSuivants() {
            GrapheListe g = new GrapheListe();

            g.ajouterArc("A", "B", 12);
            g.ajouterArc("A", "D", 87);

            List<Arc> arcsA = g.suivants("A");
            assertEquals(2, arcsA.size());
            assertEquals("B", arcsA.get(0).getDest());
            assertEquals(12, arcsA.get(0).getCout());
            assertEquals("D", arcsA.get(1).getDest());
            assertEquals(87, arcsA.get(1).getCout());
        }

        @Test
        public void testToStringGraphe() {
            GrapheListe g = new GrapheListe();
            g.ajouterArc("A", "B", 12);
            g.ajouterArc("A", "D", 87);

            String attendu = "A -> B(12.0) D(87.0) \nB -> \nD -> \n";
            assertEquals(attendu.trim(), g.toString().trim());
        }
}


