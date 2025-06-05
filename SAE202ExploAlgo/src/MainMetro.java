import java.util.List;

/**
 * Classe principale pour tester les plus courts chemins dans le métro parisien.
 * Applique Bellman-Ford et Dijkstra avec pénalité de changement de ligne sur 5 trajets.
 * Affiche le chemin trouvé et le temps de calcul pour chaque algorithme.
 */
public class MainMetro {
    public static void main(String[] args) {
        // Chargement du graphe à partir du fichier plan-reseau.txt
        GrapheListe metro = LireReseau.lire("plan-reseau.txt");

        // Liste de 5 trajets à tester (ID de stations)
        String[][] trajets = {
                {"1", "10"},
                {"3", "20"},
                {"5", "15"},
                {"8", "25"},
                {"2", "18"}
        };

        System.out.println("=== Plus courts chemins dans le métro (avec pénalité changement de ligne) ===\n");

        for (String[] trajet : trajets) {
            String depart = trajet[0];
            String arrivee = trajet[1];

            System.out.println("Trajet : " + depart + " → " + arrivee);

            // Bellman-Ford avec pénalité
            long t1 = System.nanoTime();
            Valeurs vBellman = new BellmanFord().resoudre2(metro, depart);
            long t2 = System.nanoTime();
            List<String> cheminBellman = vBellman.calculerChemin(arrivee);
            double tempsBellman = (t2 - t1) / 1_000_000.0;

            // Dijkstra avec pénalité
            long t3 = System.nanoTime();
            Valeurs vDijkstra = new Dijkstra().resoudre2(metro, depart);
            long t4 = System.nanoTime();
            List<String> cheminDijkstra = vDijkstra.calculerChemin(arrivee);
            double tempsDijkstra = (t4 - t3) / 1_000_000.0;

            // Affichage des résultats
            System.out.println("Bellman-Ford :");
            System.out.println("  Chemin : " + cheminBellman);
            System.out.println("  Temps  : " + tempsBellman + " ms");

            System.out.println("Dijkstra :");
            System.out.println("  Chemin : " + cheminDijkstra);
            System.out.println("  Temps  : " + tempsDijkstra + " ms");

            System.out.println("---------------------------------------------\n");
        }
    }
}
