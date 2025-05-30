/**
 * Classe de test pour l’algorithme de Dijkstra.
 * Crée un graphe d’exemple, applique l’algorithme depuis le nœud A
 * et affiche les distances et les parents de chaque nœud.
 */
public class MainDijkstra {
    public static void main(String[] args) {
        // Création d’un graphe exemple
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);

        // Application de Dijkstra à partir du nœud A
        Dijkstra algo = new Dijkstra();
        Valeurs resultat = algo.resoudre(g, "A");

        // Affichage des distances et parents
        System.out.println("Résultat de Dijkstra depuis le nœud A :");
        for (String noeud : g.listeNoeuds()) {
            double distance = resultat.getValeur(noeud);
            String parent = resultat.getParent(noeud);
            System.out.println(noeud + " -> distance: " + distance + ", parent: " + parent);
        }

        // Affichage du chemin de A à C
        System.out.println("Chemin de A à C : " + resultat.calculerChemin("C"));
    }
}
