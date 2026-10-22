import java.util.*;

public class UniformCostSearch {
    public static void search(Node start, Node goal){
        ArrayList<Node> toExplore = new ArrayList<>();//storing all nodes to be explored
        HashMap<Node, Integer> cost = new HashMap<>();
        HashMap<Node, Node> cameFrom = new HashMap<>();

        toExplore.add(start);//start location
        cost.put(start, 0); // getting to the start costs 0

        //Picks the cheapest place to explore and takes it off list
        while (!toExplore.isEmpty()) { //Runs until all Nodes are explored
            Node current = toExplore.getFirst();//initializes  first node as cheapest just as a placeholder
            for (Node n : toExplore) {//checks every node if it's cheaper than previous node replaces node(finding minimum)
                if (cost.get(n) < cost.get(current)) {
                    current = n;
                }
            }
            toExplore.remove(current);// removes nodes that have been explored
            if (current == goal) {// checks if the node were checking is the goal
                System.out.println("Total cost: " + cost.get(current));//prints cost to reach this goal
                return;//stops once we found goal
            }
            for (int i = 0; i < current.getEdgeList().size(); i++) {
                Node neighbor = current.getEdge(i);// who I can go to
                int newCost = cost.get(current) + current.getWeight(i); // cost to get there through current

                // if I've never seen it, or this route is cheaper than the old one:
                if (!cost.containsKey(neighbor) || newCost < cost.get(neighbor)) {
                    cost.put(neighbor, newCost);// update best cost
                    cameFrom.put(neighbor, current);// remember I came from current
                    if (!toExplore.contains(neighbor)) {
                        toExplore.add(neighbor);// add to the to-explore list
                    }
                }
            }
        } // end of while loop
        System.out.println("No path found");
        ArrayList<Node> path = new ArrayList<>();
        Node step = goal;
        while (step != null) {// the start has no came from, so this ends there
            path.addFirst(step);// add at the front so it reads start to goal
            step = cameFrom.get(step);
        }
        System.out.println("Path: " + path);
    }
}