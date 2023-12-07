package solutions.bfs;

import java.io.*;
import java.util.*;

public class Sol_9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i=0; i<tc; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            ArrayList<Node> nodes = new ArrayList<>();

            for (int j=0; j<n+2; j++) {
                st = new StringTokenizer(br.readLine());
                nodes.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            System.out.println(bfs(nodes));

        }
        br.close();
    }

    static String bfs(ArrayList<Node> nodes) {
        String result = "sad";
        HashSet<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(nodes.get(0).x, nodes.get(0).y));
        visited.add(nodes.get(0).x + ", " + nodes.get(0).y);

        while (!queue.isEmpty()) {
            Node p = queue.poll();
            if (nodes.get(nodes.size() - 1).x == p.x && nodes.get(nodes.size() - 1).y == p.y) {
                result = "happy";
                break;
            }
            for (Node n : nodes) {
                if (visited.contains(n.x + ", " + n.y)) continue;
                if (Math.abs(p.x - n.x) + Math.abs(p.y - n.y) > 1000) continue;
                queue.offer(n);
                visited.add(n.x + ", " + n.y);
            }
        }

        return result;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
