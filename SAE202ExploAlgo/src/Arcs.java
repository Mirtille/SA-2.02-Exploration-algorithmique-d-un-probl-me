import java.util.ArrayList;
import java.util.List;

/**
 * Représente un ensemble d’arcs partant d’un même nœud.
 * Utile pour stocker la liste des arcs dans un graphe.
 */
public class Arcs {

    private List<Arc> arcs; // Liste des arcs sortants

    /**
     * Constructeur : initialise une liste vide d’arcs.
     */
    public Arcs() {
        this.arcs = new ArrayList<>();
    }

    /**
     * Ajoute un arc à la liste.
     *
     * @param a l’arc à ajouter
     */
    public void ajouterArc(Arc a) {
        this.arcs.add(a);
    }

    /**
     * Retourne la liste des arcs.
     *
     * @return liste des arcs associés au nœud
     */
    public List<Arc> getArcs() {
        return this.arcs;
    }
}
