package algorithm.shortest_path;

import java.io.*;
import java.util.*;

public class BellmanFordTest {
    /**
     * - 벨만포드 알고리즘
     *   1. 한 노드에서 다른 모든 노드까지의 거리를 구하는 알고리즘
     *      - 다익스트라와 다르게 음의 가중치 간선이 있어도 사용 가능.
     *      - 또한, 음의 간선이 포함된 싸이클을 찾을 수 있다.
     *          => 최단거리를 갱신하는 루프 작업이 n(정점의 개수) 번째에도 어떤 값을 갱신시키면 음의 간선이 포함된 싸이클이 있음.
     *   2. 시간복잡: O(VE)
     *
     * example input
     * 5
     * 9
     * 1 2 10
     * 1 3 5
     * 2 3 2
     * 3 1 1
     * 3 2 13
     * 4 1 8
     * 4 5 3
     * 5 4 9
     * 5 2 31
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i=0; i<m; i++) {
            String[] input = br.readLine().split(" ");
            edges.add(new Edge(
                    Integer.parseInt(input[0]),
                    Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]))
            );
        }

        int[] dist = new int[n + 1];
        for (int i=2; i<=n; i++) dist[i] = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            for (Edge e : edges) {
                if (dist[e.start] == Integer.MAX_VALUE) continue;
                if (dist[e.end] > dist[e.start] + e.cost) {
                    dist[e.end] = dist[e.start] + e.cost;
                    if (i == n-1) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dist));


        br.close();
    }

    static class Edge {
        int start;
        int end;
        int cost;
        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
