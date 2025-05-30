import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d’un graphe orienté pondéré basé sur des listes d’adjacence.
 * Chaque nœud est représenté par une chaîne (String), et chaque liste contient ses arcs sortants.
 */
public class GrapheListe implements Graphe {

    private ArrayList<String> noeuds;       // Liste des nœuds (noms)
    private ArrayList<Arcs> adjacence;      // Liste des arcs pour chaque nœud

    /**
     * Constructeur vide : crée un graphe vide.
     */
    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    /**
     * Constructeur à partir d’un fichier texte.
     * Chaque ligne du fichier doit contenir un arc au format : depart <tab> destination <tab> cout
     *
     * @param nomFichier nom du fichier contenant les arcs du graphe
     */
    public GrapheListe(String nomFichier) {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (ligne.trim().isEmpty()) continue;

                String[] parts = ligne.split("\t");
                if (parts.length != 3) continue;

                String depart = parts[0];
                String destination = parts[1];
                double cout = Double.parseDouble(parts[2]);

                this.ajouterArc(depart, destination, cout);
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier : " + e.getMessage());
        }
    }

    /**
     * Retourne la liste des nœuds du graphe.
     *
     * @return liste des noms des nœuds
     */
    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    /**
     * Retourne la liste des arcs sortants d’un nœud.
     *
     * @param n nom du nœud source
     * @return liste des arcs partant de ce nœud
     */
    public List<Arc> suivants(String n) {
        int i = getIndice(n);
        if (i != -1) {
            return this.adjacence.get(i).getArcs();
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Retourne l’indice d’un nœud dans la liste (utile pour accéder à sa liste d’arcs).
     *
     * @param n nom du nœud
     * @return indice dans la liste, ou -1 si non trouvé
     */
    public int getIndice(String n) {
        for (int i = 0; i < this.noeuds.size(); i++) {
            if (this.noeuds.get(i).equals(n)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Ajoute un arc au graphe. Si le nœud de départ ou d’arrivée n’existe pas, il est ajouté.
     *
     * @param depart      nom du nœud de départ
     * @param destination nom du nœud d’arrivée
     * @param cout        coût de l’arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        int i = getIndice(depart);
        if (i == -1) {
            this.noeuds.add(depart);
            this.adjacence.add(new Arcs());
            i = this.noeuds.size() - 1;
        }

        if (getIndice(destination) == -1) {
            this.noeuds.add(destination);
            this.adjacence.add(new Arcs());
        }

        this.adjacence.get(i).ajouterArc(new Arc(destination, cout));
    }

    /**
     * Affiche le graphe de manière lisible.
     * Exemple : A -> B(12.0) D(87.0)
     *
     * @return chaîne représentant le graphe
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < noeuds.size(); i++) {
            String nomNoeud = noeuds.get(i);
            sb.append(nomNoeud).append(" -> ");
            List<Arc> listeArcs = adjacence.get(i).getArcs();
            for (Arc a : listeArcs) {
                sb.append(a.getDest()).append("(").append(a.getCout()).append(") ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
