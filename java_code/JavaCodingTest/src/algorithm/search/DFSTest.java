package algorithm.search;

public class DFSTest {

    /**
     * 깊이 우선 탐색
     *  - 시간복잡도: O(V+E)
     *  - 스택 사용으로 가장 이후에 들어온 노드에 대해 탐색
     *      - 구현시 재귀함수 사용, 즉 메서드 스택 사용.
     *  - 방문 노드를 기록해야함
     */

    /**
     *       1 ----- 2
     *       |     /
     *       |   /
     *       | /
     *       3 ------- 4
     *
     */

    public static void main(String... args) {
        int[][] edges = new int[5][];
        edges[1] = new int[]{2, 3};
        edges[2] = new int[]{1, 3};
        edges[3] = new int[]{1, 2, 4};
        edges[4] = new int[]{3};

        boolean[] visited = new boolean[5];
        visited[1] = true;
        dfs(edges, 1, visited);

    }

    static void dfs(int[][] edges, int node, boolean[] visited) {
        for (int n : edges[node]) {
            if (visited[n]) continue;
            visited[n] = true;
            System.out.println(n);
            dfs(edges, n, visited);
        }
    }

}
