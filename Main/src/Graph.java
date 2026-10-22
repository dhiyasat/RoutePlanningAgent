import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> graphNodes = new ArrayList<Node>();
    private Node start;
    private Node goal;
    private Node current;
    public Graph(){
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        n1.addEdge(n2,3);
        n1.addEdge(n3,1);
        n2.addEdge(n1,3);
        n2.addEdge(n5,8);
        n3.addEdge(n1,1);
        n3.addEdge(n4,2);
        n4.addEdge(n3,2);
        n4.addEdge(n5,2);
        n4.addEdge(n6,3);
        n5.addEdge(n2,8);
        n5.addEdge(n4,2);
        n5.addEdge(n6,7);
        this.graphNodes.add(n1);
        this.graphNodes.add(n2);
        this.graphNodes.add(n3);
        this.graphNodes.add(n4);
        this.graphNodes.add(n5);
        this.graphNodes.add(n6);
        this.start = n1;
        this.goal = n6;
        this.current = this.start;
    }

    public ArrayList<Node> getNodes(){
        return this.graphNodes;
    }

    public Node getStartNode(){
        return this.start;
    }

    public Node getGoalNode(){
        return this.goal;
    }

    public void setCurrentNode(Node node){
        this.current = node;
    }

    public Node getCurrentNode(){
        return this.current;
    }
}


