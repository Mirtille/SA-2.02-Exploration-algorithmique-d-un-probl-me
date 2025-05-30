import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implémente l'algorithme de Dijkstra pour calculer les plus courts chemins dans un graphe pondéré.
 */
public class Dijkstra {

    /**
     * Version classique de l’algorithme de Dijkstra.
     * Calcule les distances minimales depuis un nœud de départ, sans pénalité de changement de ligne.
     *
     * @param g      le graphe
     * @param depart le nom du nœud de départ
     * @return un objet Valeurs avec les distances et les parents pour chaque nœud
     */
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs v = new Valeurs();
        List<String> Q = new ArrayList<>();

        for (String noeud : g.listeNoeuds()) {
            v.setValeur(noeud, Double.MAX_VALUE);
            v.setParent(noeud, null);
            Q.add(noeud);
        }
        v.setValeur(depart, 0);

        while (!Q.isEmpty()) {
            // Trouver le nœud avec la plus petite valeur
            String uMin = Q.get(0);
            for (String noeud : Q) {
                if (v.getValeur(noeud) < v.getValeur(uMin)) {
                    uMin = noeud;
                }
            }

            Q.remove(uMin);

            for (Arc arc : g.suivants(uMin)) {
                String voisin = arc.getDest();
                double nouvelleValeur = v.getValeur(uMin) + arc.getCout();

                if (nouvelleValeur < v.getValeur(voisin)) {
                    v.setValeur(voisin, nouvelleValeur);
                    v.setParent(voisin, uMin);
                }
            }
        }

        return v;
    }

    /**
     * Version modifiée de Dijkstra avec pénalité de 10 si la ligne change entre deux arcs.
     * Pratique pour les graphes de transport comme un réseau de métro.
     *
     * @param g      le graphe (avec lignes renseignées dans les arcs)
     * @param depart le nœud de départ
     * @return un objet Valeurs avec les distances et les parents, en tenant compte des pénalités
     */
    public Valeurs resoudre2(Graphe g, String depart) {
        Valeurs v = new Valeurs();
        Map<String, String> ligneActuelle = new HashMap<>();
        List<String> Q = new ArrayList<>();

        for (String noeud : g.listeNoeuds()) {
            v.setValeur(noeud, Double.MAX_VALUE);
            v.setParent(noeud, null);
            ligneActuelle.put(noeud, null);
            Q.add(noeud);
        }

        v.setValeur(depart, 0);
        ligneActuelle.put(depart, "");

        while (!Q.isEmpty()) {
            String u = Q.get(0);
            for (String n : Q) {
                if (v.getValeur(n) < v.getValeur(u)) {
                    u = n;
                }
            }

            Q.remove(u);
            String ligneU = ligneActuelle.get(u);

            for (Arc arc : g.suivants(u)) {
                String voisin = arc.getDest();
                double cout = arc.getCout();
                String ligneArc = arc.getLigne();

                double penalite = (!ligneU.equals("") && !ligneU.equals(ligneArc)) ? 10 : 0;
                double newVal = v.getValeur(u) + cout + penalite;

                if (newVal < v.getValeur(voisin)) {
                    v.setValeur(voisin, newVal);
                    v.setParent(voisin, u);
                    ligneActuelle.put(voisin, ligneArc);
                }
            }
        }

        return v;
    }
}
