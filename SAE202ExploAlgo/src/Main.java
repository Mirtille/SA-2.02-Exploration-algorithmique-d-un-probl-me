/**
 * Classe de test pour vérifier la construction d’un graphe en mémoire.
 * Crée un petit graphe d’exemple et affiche les arcs sortants de chaque nœud.
 */
public class Main {
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();

        // Création manuelle d’un graphe exemple
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);

        // Affichage des arcs sortants pour chaque nœud
        for (String noeud : g.listeNoeuds()) {
            System.out.print(noeud + " -> ");
            for (Arc a : g.suivants(noeud)) {
                System.out.print(a.getDest() + "(" + a.getCout() + ") ");
            }
            System.out.println();
        }
    }
}
