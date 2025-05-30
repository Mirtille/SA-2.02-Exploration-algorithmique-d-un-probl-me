import java.util.HashMap;
import java.util.Map;

/**
 * Implémente l’algorithme du point fixe (Bellman-Ford) pour trouver les plus courts chemins dans un graphe.
 */
public class BellmanFord {

    /**
     * Calcule les plus courts chemins depuis un nœud de départ sans pénalité de changement de ligne.
     * Utilise l’algorithme du point fixe classique (itérations jusqu’à convergence).
     *
     * @param g      le graphe utilisé
     * @param depart le nom du nœud de départ
     * @return un objet Valeurs contenant les distances et les parents de chaque nœud
     */
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs v = new Valeurs();

        for (String noeud : g.listeNoeuds()) {
            v.setValeur(noeud, Double.MAX_VALUE);
            v.setParent(noeud, null);
        }

        v.setValeur(depart, 0);

        boolean changement = true;

        while (changement) {
            changement = false;

            for (String x : g.listeNoeuds()) {
                double lx = v.getValeur(x);

                for (Arc arc : g.suivants(x)) {
                    String y = arc.getDest();
                    double cout = arc.getCout();
                    double nouvelleValeur = lx + cout;

                    if (nouvelleValeur < v.getValeur(y)) {
                        v.setValeur(y, nouvelleValeur);
                        v.setParent(y, x);
                        changement = true;
                    }
                }
            }
        }

        return v;
    }

    /**
     * Version modifiée de Bellman-Ford avec pénalité de 10 unités lors d’un changement de ligne.
     * Utile pour les graphes représentant des réseaux de transport (ex : métro).
     *
     * @param g      le graphe avec lignes
     * @param depart le nœud de départ
     * @return un objet Valeurs contenant les distances et les parents, en tenant compte des pénalités
     */
    public Valeurs resoudre2(Graphe g, String depart) {
        Valeurs v = new Valeurs();
        Map<String, String> ligneActuelle = new HashMap<>();

        for (String noeud : g.listeNoeuds()) {
            v.setValeur(noeud, Double.MAX_VALUE);
            v.setParent(noeud, null);
            ligneActuelle.put(noeud, null);
        }

        v.setValeur(depart, 0);
        ligneActuelle.put(depart, "");

        boolean changement = true;

        while (changement) {
            changement = false;

            for (String x : g.listeNoeuds()) {
                double valX = v.getValeur(x);
                String ligneX = ligneActuelle.get(x);

                for (Arc arc : g.suivants(x)) {
                    String y = arc.getDest();
                    double cout = arc.getCout();
                    String ligneArc = arc.getLigne();

                    double penalite = (!ligneX.equals("") && !ligneX.equals(ligneArc)) ? 10 : 0;
                    double newVal = valX + cout + penalite;

                    if (newVal < v.getValeur(y)) {
                        v.setValeur(y, newVal);
                        v.setParent(y, x);
                        ligneActuelle.put(y, ligneArc);
                        changement = true;
                    }
                }
            }
        }

        return v;
    }
}
