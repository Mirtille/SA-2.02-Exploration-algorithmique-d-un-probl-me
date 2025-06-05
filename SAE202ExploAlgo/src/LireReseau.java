import java.io.*;

/**
 * Classe utilitaire pour lire un fichier de type plan-reseau.txt
 * et construire un graphe représentant le réseau du métro parisien.
 */
public class LireReseau {

    /**
     * Lit un fichier texte contenant la structure d’un réseau de transport
     * et crée un objet GrapheListe correspondant.
     * Ne traite que la section %connexions et ignore les lignes de métro.
     *
     * @param nomFichier nom du fichier à lire
     * @return le graphe construit avec les arcs bidirectionnels
     */
    public static GrapheListe lire(String nomFichier) {
        GrapheListe graphe = new GrapheListe();
        boolean lectureConnexions = false;

        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;

            while ((ligne = br.readLine()) != null) {
                // Ignorer les lignes de commentaire
                if (ligne.startsWith("%")) {
                    if (ligne.contains("connexions")) {
                        lectureConnexions = true;
                    }
                    continue;
                }

                // Traitement des connexions (arcs entre stations)
                if (lectureConnexions && !ligne.trim().isEmpty()) {
                    String[] parts = ligne.split(":");

                    if (parts.length >= 4) {
                        String depart = parts[0];
                        String arrivee = parts[1];
                        double cout = Double.parseDouble(parts[2]);

                        // On ajoute un arc dans les deux sens car les connexions sont bidirectionnelles
                        graphe.ajouterArc(depart, arrivee, cout);
                        graphe.ajouterArc(arrivee, depart, cout);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur lecture réseau métro : " + e.getMessage());
        }

        return graphe;
    }
}
