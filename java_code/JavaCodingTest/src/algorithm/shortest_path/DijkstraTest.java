package algorithm.shortest_path;

import java.io.*;
import java.util.*;

public class DijkstraTest {
    /**
     * 다익스트라 알고리즘은 음의 간선이 없을때 노드 하나로부터 각각 다른 노드들까지의 거리를 모두 구하는 알고리즘
     * 초기 모델은 O(V^2) 이었지만, 방문하기 위한 가장 짧은 거리를 가진 노드를 찾는 로직을 우선순위큐(힙)를
     * 사용하는 방식을 사용하면 O(E*logV) 로 단축할 수 있다.
     *
     *
     * sample input
     * 5 6
     * 1
     * 5 1 1
     * 1 2 2
     * 1 3 3
     * 2 3 4
     * 2 4 5
     * 3 4 6
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        int startNum = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<ToD>> edges = new ArrayList<>();
        for (int i=0; i<=nodeNum; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i=0; i<edgeNum; i++) {
            String[] edge = br.readLine().split(" ");
            edges.get(Integer.parseInt(edge[0]))
                    .add(new ToD(Integer.parseInt(edge[1]), Integer.parseInt(edge[2])));
            edges.get(Integer.parseInt(edge[1]))
                    .add(new ToD(Integer.parseInt(edge[0]), Integer.parseInt(edge[2])));
        }

        int[] costs = new int[nodeNum + 1];
        for (int i=2; i<nodeNum + 1; i++) {
            costs[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.offer(new Node(startNum, 0));

        while(!heap.isEmpty()) {
            Node t = heap.poll();
            if (t.d > costs[t.n]) continue;

            for (ToD tod : edges.get(t.n)) {
                if (costs[tod.dest] > t.d + tod.cost) {
                    costs[tod.dest] = t.d + tod.cost;
                    heap.offer(new Node(tod.dest, t.d + tod.cost));
                }
            }

        }
        System.out.println(Arrays.toString(costs));
        br.close();
    }

    static class Node implements Comparable<Node> {
        int n;
        int d;

        Node(int n, int d) {
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(Node node) {
            return this.d - node.d;
        }
    }

    static class ToD {
        int dest;
        int cost;

        ToD(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
