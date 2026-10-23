public class Heuristic {
    public static int Manhattan(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    public static int h(Node n, Node goal){
        return Manhattan(n.getX(), n.getY(), goal.getX(), goal.getY());

    }
}