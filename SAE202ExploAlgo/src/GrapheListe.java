public class GrapheListe implements Graphe{

    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    public int getIndice(String n){
        for(int i = 0; i < this.noeuds.size; i++){
            if(this.noeuds.get(i).equals(n)){
                return i;
            }
        }
        return -1;
    }

    void ajouterArc(String depart, String destination, double cout){
        
    }
}
