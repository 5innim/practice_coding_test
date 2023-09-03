package solutions.shortestpath.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol_1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
        for (int i=0; i<10000; i++) {
            edges.add(new ArrayList<>());
            edges.get(i).add(new Edge(i +1, 1));
        }

        int[] initValues = new int[10001];
        for (int i=1; i<10001; i++) initValues[i] = 10001;

        boolean[] completed = new boolean[10001];

        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.offer(new Node(0, 0));

        for (int i=0; i<n; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stn.nextToken());
            int dest = Integer.parseInt(stn.nextToken());
            int distance = Integer.parseInt(stn.nextToken());

            edges.get(start).add(new Edge(dest, distance));
        }

        while (heap.peek() != null) {
            Node node = heap.poll();
            completed[node.index] = true;
            if (node.index == 10000) break;

            for (Edge e : edges.get(node.index)) {
                if (completed[e.dest]) continue;
                if (initValues[e.dest] > node.distance + e.distance) {
                    initValues[e.dest] = node.distance + e.distance;
                    heap.offer(new Node(e.dest, initValues[e.dest]));
                }
            }
        }

        System.out.println(initValues[d]);


        br.close();
    }

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            } else if (this.distance == o.distance) {
                if (this.index < o.index) {
                    return -1;
                } else if (this.index == o.index) {
                    return 0;
                } else if (this.index > o.index) {
                    return 1;
                }
            } else if (this.distance > o.distance) {
                return 1;
            }

            return 0;
        }
    }

    static class Edge {
        int dest;
        int distance;

        Edge(int dest, int distance) {
            this.dest = dest;
            this.distance = distance;
        }
    }

}
