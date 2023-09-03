package algorithm.search;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class DFSTest {

    /**
     *
     * 깊이우선탐색(Depth-first search)
     *   - stack 자료구조를 사용하여 깊이를 우선하여 탐색하는 알고리즘
     *   - O(V+E)
     *
     * !! DFS 는 재귀함수로!
     *  for 문이 아닌 재귀함수로 구현하였을때 맨 끝에서부터 앞으로 결과를 가져오는 구현이 가능해진다.
     */

    public static void main(String[] args) {
        /**
         *       1 ----- 2
         *       |     /
         *       |   /
         *       | /
         *       3 ------- 4
         *
         *
         *       1: 2 3
         *
         *       2: 1 3
         *
         *       3: 1 2 4
         *
         *       4: 3
         *
         *
         */



        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i=0; i<5; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] e : new int[][]{{1, 2}, {1, 3}, {2, 3}, {3, 4}}) {
            edges.get(e[0]).add(e[1]);
            edges.get(e[1]).add(e[0]);
        }

        boolean[] visited = {false, false, false, false, false};

        dfs(edges, visited, 1);
    }

    static void dfs(ArrayList<ArrayList<Integer>> edges, boolean[] visited, int node) {
        visited[node] = true;
        System.out.println(node);

        for (int e : edges.get(node)) {
            if (visited[e]) continue;
            dfs(edges, visited, e);
        }
    }
}
