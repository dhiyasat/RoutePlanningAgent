 import java.util.ArrayList;

    // Greedy Best-First Search (rough first version)
// Greedy uses the evaluation function f(n) = h(n), so it always expands
// the node that LOOKS closest to the goal, based on the Manhattan heuristic.
public class GreedySearch {

        public static void search(Graph graph) {
            // Get the goal node from the graph (set in Graph's constructor)
            Node goal = graph.getGoalNode();

            // fringe: nodes we've found but haven't expanded yet
            ArrayList<Node> fringe = new ArrayList<>();

            // visited: nodes we've already added to the fringe,
            // so we never add the same node twice (stops infinite loops)
            ArrayList<Node> visited = new ArrayList<>();

            // Start from the agent's current node
            fringe.add(graph.getCurrentNode());
            visited.add(graph.getCurrentNode());

            // Keep going while there are still nodes left to expand
            while (!fringe.isEmpty()) {

                // Step 1: find the node in the fringe with the lowest h(n)
                Node best = fringe.get(0);                 // assume the first one is best
                for (Node n : fringe) {
                    if (Heuristic.h(n, goal) < Heuristic.h(best, goal)) {
                        best = n;                          // found a lower h, so this is the new best
                    }
                }

                // Take the chosen node out of the fringe and print it (shows each step)
                fringe.remove(best);
                System.out.println("Expanding " + best.getName() + " (h = " + Heuristic.h(best, goal) + ")");

                // Step 2: goal test. If this is the goal, we're done
                if (best == goal) {
                    System.out.println("Goal reached!");
                    return;
                }

                // Step 3: expand the node. Add every connected node we haven't seen yet
                for (Node neighbor : best.getEdgeList()) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        fringe.add(neighbor);
                    }
                }
            }

            // The fringe ran out before reaching the goal, so there is no path
            System.out.println("No path found");
        }
}
