/**
 * Représente un arc orienté dans un graphe.
 * Un arc part d'un nœud (implicite) vers un autre nœud (dest), avec un coût et éventuellement une ligne (métro).
 */
public class Arc {
    private String dest;   // Nom du nœud d'arrivée
    private double cout;   // Coût de l'arc (temps, distance, etc.)
    private String ligne;  // Ligne de métro (utile pour les pénalités)

    /**
     * Constructeur principal pour créer un arc avec destination, coût et ligne.
     *
     * @param dest  nom du nœud destination
     * @param cout  coût associé à l’arc
     * @param ligne numéro ou nom de la ligne (ex : "1", "6bis")
     */
    public Arc(String dest, double cout, String ligne) {
        this.dest = dest;
        this.cout = cout;
        this.ligne = ligne;
    }

    /**
     * Constructeur simplifié sans ligne (ligne vide par défaut).
     *
     * @param dest nom du nœud destination
     * @param cout coût de l’arc
     */
    public Arc(String dest, double cout) {
        this(dest, cout, "");
    }

    /**
     * Retourne le nom du nœud destination.
     *
     * @return nom du nœud d'arrivée
     */
    public String getDest() {
        return dest;
    }

    /**
     * Retourne le coût de l’arc.
     *
     * @return coût (poids) de l’arc
     */
    public double getCout() {
        return cout;
    }

    /**
     * Retourne la ligne associée à l’arc (utile pour le métro).
     *
     * @return nom ou numéro de ligne (chaîne vide si non utilisé)
     */
    public String getLigne() {
        return ligne;
    }

    /**
     * Affiche une version lisible de l’arc (ex : B(12.0, ligne 1)).
     *
     * @return représentation texte de l’arc
     */
    @Override
    public String toString() {
        return dest + "(" + cout + (ligne.isEmpty() ? "" : ", ligne " + ligne) + ")";
    }
}
