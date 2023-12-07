package solutions.shortestpath.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Arrays;

public class Sol_1162 {
    /**
     * 준영이는 매일 서울에서 포천까지 출퇴근을 한다. 하지만 잠이 많은 준영이는 늦잠을 자 포천에 늦게 도착하기 일쑤다.
     * 돈이 많은 준영이는 고민 끝에 K개의 도로를 포장하여 서울에서 포천까지 가는 시간을 단축하려 한다.
     *
     * 문제는 N개의 도시가 주어지고 그 사이 도로와 이 도로를 통과할 때 걸리는 시간이 주어졌을 때 최소 시간이 걸리도록 하는 K개의 이하의 도로를 포장하는 것이다.
     * 도로는 이미 있는 도로만 포장할 수 있고, 포장하게 되면 도로를 지나는데 걸리는 시간이 0이 된다. 또한 편의상 서울은 1번 도시, 포천은 N번 도시라 하고 1번에서 N번까지 항상 갈 수 있는 데이터만 주어진다.
     *
     * 첫 줄에는 도시의 수 N(1 ≤ N ≤ 10,000)과 도로의 수 M(1 ≤ M ≤ 50,000)과 포장할 도로의 수 K(1 ≤ K ≤ 20)가 공백으로 구분되어 주어진다.
     * M개의 줄에 대해 도로가 연결하는 두 도시와 도로를 통과하는데 걸리는 시간이 주어진다. 도로들은 양방향 도로이며, 걸리는 시간은 1,000,000보다 작거나 같은 자연수이다.
     *
     * 첫 줄에 K개 이하의 도로를 포장하여 얻을 수 있는 최소 시간을 출력한다.
     *
     *
     * 4 4 1
     * 1 2 10
     * 2 4 10
     * 1 3 1
     * 3 4 100
     */

    static int n;
    static int m;
    static int k;

    public static void main(String[] args) throws IOException { // long 타입 사용 및 heap 추출 값이 더 큰 경우 과정 생략!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<List<Integer>>> edges = new ArrayList<>();
        long[][] costs = new long[n + 1][k + 1];
        for (long[] cost : costs) {
            Arrays.fill(cost, Long.MAX_VALUE);
        }


        for (int i=0; i<n+1; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            edges.get(Integer.parseInt(line[0])).add(Arrays.asList(Integer.parseInt(line[1]), Integer.parseInt(line[2])));
            edges.get(Integer.parseInt(line[1])).add(Arrays.asList(Integer.parseInt(line[0]), Integer.parseInt(line[2])));
        }

        bfs(edges, costs, 1);

        long min = Long.MAX_VALUE;
        for (long c : costs[n]) {
            min = Math.min(min, c);
        }
        System.out.println(min);

        br.close();
    }

    static void bfs(ArrayList<ArrayList<List<Integer>>> edges, long[][] costs, int start) {

        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.offer(new Node(start, 0, 0));
        costs[start][0] = 0;

        while (heap.peek() != null) {
            Node p = heap.poll();

            if (p.distance > costs[p.num][p.cnt]) continue;

            for (List<Integer> edge : edges.get(p.num)) {
                if (p.cnt < k && costs[edge.get(0)][p.cnt + 1] > p.distance) {
                    heap.offer(new Node(edge.get(0), p.cnt + 1, p.distance));
                    costs[edge.get(0)][p.cnt + 1] = p.distance;
                }

                if (costs[edge.get(0)][p.cnt] > p.distance + edge.get(1)) {
                    heap.offer(new Node(edge.get(0), p.cnt, p.distance + edge.get(1)));
                    costs[edge.get(0)][p.cnt] = p.distance + edge.get(1);
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int num;
        int cnt;
        long distance;

        Node(int num, int cnt, long distance) {
            this.num = num;
            this.cnt = cnt;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance - o.distance < 0l){
                return -1;
            } else if (this.distance - o.distance == 0l){
                return 0;
            } else if (this.distance - o.distance > 0l){
                return 1;
            }
            return 0;
        }
    }

}
