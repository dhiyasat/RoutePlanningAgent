import java.util.ArrayList;
import java.util.HashMap;

// a* search (rough first draft)
// a* picks the node with the lowest f = g + h
// g = the real cost to get from the start to a node
// h = the manhattan estimate from a node to the goal (same heuristic greedy uses)
// greedy only looks at h, a* adds g so it also cares about the cost so far
public class Astar {

    public static void search(Graph graph) {
        // the goal node comes from the graph
        Node goal = graph.getGoalNode();

        // fringe: nodes we found but haven't expanded yet
        ArrayList<Node> fringe = new ArrayList<>();

        // g: the cheapest cost we've found so far to reach each node
        // (hashmap so we can look up a node's cost quickly)
        HashMap<Node, Integer> g = new HashMap<>();

        // start at the agent's current node, it costs 0 to get there
        fringe.add(graph.getCurrentNode());
        g.put(graph.getCurrentNode(), 0);

        // keep going until there are no nodes left to expand
        while (!fringe.isEmpty()) {

            // step 1: look through the fringe and pick the node with the lowest f = g + h
            Node best = fringe.get(0);
            for (Node n : fringe) {
                if (g.get(n) + Heuristic.h(n, goal) < g.get(best) + Heuristic.h(best, goal)) {
                    best = n;
                }
            }

            // take it out of the fringe and print it so we can see each step
            fringe.remove(best);
            System.out.println("Expanding " + best.getName() + " (g = " + g.get(best) + ")");

            // step 2: if this node is the goal we are done, g is the total cost of the path
            if (best == goal) {
                System.out.println("Goal reached! Total cost = " + g.get(best));
                return;
            }

            // step 3: expand the node by checking each of its neighbors
            for (int i = 0; i < best.getEdgeList().size(); i++) {
                Node neighbor = best.getEdge(i);

                // cost to reach the neighbor = cost to reach best + the edge weight
                int newCost = g.get(best) + best.getWeight(i);

                // only update if we haven't seen this neighbor or we found a cheaper way to it
                if (!g.containsKey(neighbor) || newCost < g.get(neighbor)) {
                    g.put(neighbor, newCost);

                    // add it to the fringe if it isn't already there
                    if (!fringe.contains(neighbor)) {
                        fringe.add(neighbor);
                    }
                }
            }
        }

        // the fringe ran out and we never reached the goal, so there is no path
        System.out.println("No path found");
    }
}