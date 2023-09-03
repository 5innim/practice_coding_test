package solutions.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sol_15681 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int q = Integer.parseInt(input[2]);

        int[] subtreeNums = new int[n+1];
        for (int i=0; i<n+1; i++) subtreeNums[i] = 1;

        boolean[] visited = new boolean[n+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<n-1; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(graph, subtreeNums, visited, r);

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<q; i++) sb.append(subtreeNums[Integer.parseInt(br.readLine())]).append("\n");
        // Stirng 을 새로 생성할 필요가 없어 시간이 준다고는 하는데 크게 차이는 없는 거 같다.
        // 메모리는 주는 거 같다.
        System.out.println(sb);

        br.close();
    }

    static int dfs(ArrayList<ArrayList<Integer>> graph, int[] subtreeNums, boolean[] visited, int node) {
        visited[node] = true;

        for (int t : graph.get(node)) {
            if (visited[t]) continue;
            subtreeNums[node] += dfs(graph, subtreeNums, visited, t);
        }

        return subtreeNums[node];
    }
}