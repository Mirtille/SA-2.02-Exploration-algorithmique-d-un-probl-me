import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{

    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;


    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    public List<Arc> suivants(String n) {
        int i = getIndice(n);
        if (i != -1) {
            return this.adjacence.get(i).getArcs();
        } else {
            return new ArrayList<>();
        }
    }

    public int getIndice(String n){
        for(int i = 0; i < this.noeuds.size; i++){
            if(this.noeuds.get(i).equals(n)){
                return i;
            }
        }
        return -1;
    }

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
