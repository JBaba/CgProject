import java.util.*;

public class Skyline {

    public static void main(String[] args) {
        List<Element> input = new ArrayList<>();
        input.add(new Element(1, 11, 5));
//        input.add(new Element(1, 12, 5));
        input.add(new Element(2, 6, 7));
        input.add(new Element(3, 13, 9));
        input.add(new Element(12, 7, 16));
        input.add(new Element(14, 3, 25));
        input.add(new Element(19, 18, 22));
        input.add(new Element(23, 13, 29));
        input.add(new Element(24, 4, 28));
//        Output: Skyline (an array of rectangular strips)
//        A strip has x coordinate of left side and height
//        (1, 11), (3, 13), (9, 0), (12, 7), (16, 3), (19, 18),
//        (22, 3), (23,13), (29, 0)
        skyline(input);
    }

    private static List<int[]> skyline(List<Element> input) {
        List<int[]> results = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        for (Element e : input) {
            Edge start = new Edge(e.left, e.height, true);
            Edge end = new Edge(e.right, e.height, false);
            edges.add(start);
            edges.add(end);
        }

        System.out.println(edges);

        Collections.sort(edges, (o1, o2) -> {
            // first order by x
            if (o1.x != o2.x) {
                return Integer.compare(o1.x, o2.x);
            }
            // duplicate start then order maximum height first
            if (o1.isStart && o2.isStart) {
                return Integer.compare(o2.height,o1.height);
            }
            // duplicate false then order maximum height first
            // because it should at the end
            if (!o1.isStart && !o2.isStart) {
                return Integer.compare(o1.height, o2.height);
            }

            return o1.isStart ? -1 : 1;
        });

        System.out.println(edges);

        PriorityQueue<Integer> heap = new PriorityQueue<>(10, Collections.reverseOrder());

        for (Edge edge : edges) {
            if (edge.isStart) {
                if (heap.isEmpty() || edge.height > heap.peek()) {
                    results.add(new int[]{edge.x, edge.height});
                }
                heap.add(edge.height);
            } else {
                heap.remove(edge.height);
                if (heap.isEmpty()) {
                    results.add(new int[]{edge.x, 0});
                } else if (edge.height > heap.peek()) {
                    results.add(new int[]{edge.x, heap.peek()});
                }
            }
        }

        for (int[] e : results) {
            System.out.println(e[0] + "," + e[1]);
        }

        return results;
    }

}

class Element {
    int left, right, height;

    public Element(int left, int height, int right) {
        this.left = left;
        this.right = right;
        this.height = height;
    }

    @Override
    public String toString() {
        return "l=" + left +
                ", r=" + right +
                ", h=" + height;
    }
}

class Edge {
    int x;
    int height;
    boolean isStart;

    public Edge(int x, int height, boolean isStart) {
        this.x = x;
        this.height = height;
        this.isStart = isStart;
    }

    @Override
    public String toString() {
        return "{" + x +
                ", h=" + height +
                "," + isStart +
                '}';
    }
}
