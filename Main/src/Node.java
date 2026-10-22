import java.util.ArrayList;

public class Node {
    private String name;
    private ArrayList<Node> edges = new ArrayList<Node>();
    private ArrayList<Integer> weights = new ArrayList<Integer>();

    public Node(String name){
        this.name = name;
    }

    public void addEdge(Node node, Integer weight){
        this.name = name;
        this.edges.add(node);
        this.weights.add(weight);
    }

    public ArrayList<Node> getEdgeList(){
        return this.edges;
    }

    public Node getEdge(int i){
        return this.edges.get(i);
    }

    public ArrayList<Integer> getEdgeWeights(){
        return this.weights;
    }

    public Integer getWeight(int i){
        return this.weights.get(i);
    }

    public String toString(){
        return this.name;
    }
}