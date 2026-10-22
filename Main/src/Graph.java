import java.util.ArrayList;
import java.util.Objects;

public class Graph {
    private ArrayList<Node> graphNodes = new ArrayList<Node>();
    private Node goal;
    private Node current;
    public Graph(){
        Node n1 = new Node("n1",0,6);
        Node n2 = new Node("n2",1,0);
        Node n3 = new Node("n3",9,1);
        Node n4 = new Node("n4",4,5);
        Node n5 = new Node("n5",2,9);
        Node n6 = new Node("n6",7,10);
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
        this.goal = n6;
        this.current = n1;
    }

    public ArrayList<Node> getNodes(){
        return this.graphNodes;
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

    public Node findNode(String name){
        for (Node graphNode : graphNodes) {
            if (Objects.equals(graphNode.getName(), name)){
                return graphNode;
            }
        }
        return null;
    }
}