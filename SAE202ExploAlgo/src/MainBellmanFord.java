/**
 * Classe de test pour l’algorithme de Bellman-Ford.
 * Crée un graphe d’exemple, applique l’algorithme depuis le nœud A
 * et affiche la distance minimale et le parent pour chaque nœud.
 */
public class MainBellmanFord {
    public static void main(String[] args) {
        // Création d’un petit graphe d’exemple
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);

        // Application de Bellman-Ford à partir du nœud A
        BellmanFord algo = new BellmanFord();
        Valeurs resultat = algo.resoudre(g, "A");

        // Affichage des distances et parents calculés
        System.out.println("Résultat de Bellman-Ford depuis le nœud A :");
        for (String noeud : g.listeNoeuds()) {
            double distance = resultat.getValeur(noeud);
            String parent = resultat.getParent(noeud);
            System.out.println(noeud + " -> distance: " + distance + ", parent: " + parent);
        }
    }
}
