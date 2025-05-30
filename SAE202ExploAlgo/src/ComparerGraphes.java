/**
 * Classe de test qui compare les performances des algorithmes Bellman-Ford et Dijkstra.
 * Charge 5 graphes depuis des fichiers texte et affiche les temps de calcul et distances trouvées.
 */
public class ComparerGraphes {
    public static void main(String[] args) {
        System.out.println("========== Comparaison des algorithmes ==========\n");

        for (int i = 1; i <= 5; i++) {
            String fichier = "Graphes/graphe" + i + ".txt";

            System.out.println("Graphe " + i + " : " + fichier);

            // Chargement du graphe
            GrapheListe graphe = new GrapheListe(fichier);

            // Départ : premier nœud ; arrivée : dernier nœud
            String depart = graphe.listeNoeuds().get(0);
            String arrivee = graphe.listeNoeuds().get(graphe.listeNoeuds().size() - 1);

            System.out.println("Départ  : " + depart);
            System.out.println("Arrivée : " + arrivee);

            // --- Bellman-Ford ---
            long tDebutBellman = System.nanoTime();
            Valeurs valeursBellman = new BellmanFord().resoudre(graphe, depart);
            long tFinBellman = System.nanoTime();
            double distanceBellman = valeursBellman.getValeur(arrivee);
            double tempsBellman = (tFinBellman - tDebutBellman) / 1_000_000.0;

            // --- Dijkstra ---
            long tDebutDijkstra = System.nanoTime();
            Valeurs valeursDijkstra = new Dijkstra().resoudre(graphe, depart);
            long tFinDijkstra = System.nanoTime();
            double distanceDijkstra = valeursDijkstra.getValeur(arrivee);
            double tempsDijkstra = (tFinDijkstra - tDebutDijkstra) / 1_000_000.0;

            // Affichage des résultats
            System.out.println("\nRésultats :");
            System.out.println("Bellman-Ford :");
            System.out.println("  Temps    = " + tempsBellman + " ms");
            System.out.println("  Distance = " + distanceBellman);

            System.out.println("Dijkstra :");
            System.out.println("  Temps    = " + tempsDijkstra + " ms");
            System.out.println("  Distance = " + distanceDijkstra);

            System.out.println("---------------------------------------------\n");
        }

        System.out.println("Comparaison terminée.");
    }
}
