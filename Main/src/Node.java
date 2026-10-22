import java.util.ArrayList;

public class Node {
    private String name;
    private int x;
    private int y;
    private ArrayList<Node> edges = new ArrayList<Node>();
    private ArrayList<Integer> weights = new ArrayList<Integer>();

    public Node(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return this.name;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
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