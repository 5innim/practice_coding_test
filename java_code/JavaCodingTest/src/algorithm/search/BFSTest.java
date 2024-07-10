package algorithm.search;

import java.util.*;

public class BFSTest {

    /**
     *
     * 너비 우선 탐색
     *  - 시간복잡도 O(V+E)
     *  - 큐 자료구조를 사용하여 근접한 노드에 대해 먼저 큐에 들어온 순서대로 탐색하는 그래프 탐색 기법
     *  - 큐와 이미 방문한 노드를 기록할 배열 필요
     *  - 크게 그래프롤 표현하는 방법으로
     *      1. 2차원 배열을 사용해 해당 노드에 연결된 다른 노드들을 add
     *          : target 이 된 노드에 대해 근접 노드가 뭐가 있는지 일일이 순회하면서
     *          찾을 필요가 없는것이 장점
     *      2. 2차원 n*n 배열을 사용. 노드간의 간선 유무를 표시
     *          : 간선의 유무를 index 로 빠르게 접근할 수 있는것이 장점
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

        Queue<Integer> queue = new LinkedList();
        queue.offer(1);
        boolean[] visited = new boolean[5];
        visited[1] = true;

        while(!queue.isEmpty()) {
            int t = queue.poll();

            for (int n : edges[t]) {
                if (visited[n]) continue;

                queue.offer(n);
                visited[n] = true;
                System.out.println(n);
            }
        }
    }
}
