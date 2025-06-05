import java.util.ArrayList;
import java.util.List;

/**
 * Interface représentant un graphe orienté pondéré.
 * Permet d'obtenir la liste des nœuds et les arcs sortants d'un nœud donné.
 */
public interface Graphe {

    /**
     * Retourne tous les nœuds présents dans le graphe.
     *
     * @return liste des noms des nœuds (chaînes de caractères)
     */
    public List<String> listeNoeuds();

    /**
     * Retourne la liste des arcs sortants à partir d’un nœud donné.
     *
     * @param n le nom du nœud source
     * @return liste des arcs partant de ce nœud
     */
    public List<Arc> suivants(String n);
}
