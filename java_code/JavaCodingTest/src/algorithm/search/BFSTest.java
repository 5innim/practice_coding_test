package algorithm.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTest {
    /**
     *
     * 너비우선탐색 (Breadth-first search)
     *   - queue 자료구조를 사용한 너비를 우선하여 탐색하는 알고리즘
     *   - O(V+E)
     */

    public static void main(String[] args) {

        /**
         *       1 ----- 2
         *       |     /
         *       |   /
         *       | /
         *       3 ------- 4
         *
         */

        int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {3, 4}};
        ArrayList<ArrayList<Integer>> infoList = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        boolean[] enqueued = {false, false, false, false, false};

        for (int i=0; i<5; i++) {
            infoList.add(new ArrayList<Integer>());
        }

        for (int[] e : edges) {
            infoList.get(e[0]).add(e[1]);
            infoList.get(e[1]).add(e[0]);
        }

        queue.offer(1);
        enqueued[1] = true;

        while (queue.peek() != null) {
            int p = queue.poll();
            System.out.println(p);
            for (int t : infoList.get(p)) {
                if (enqueued[t]) continue;
                enqueued[t] = true;
                queue.offer(t);

            }
        }

    }

}
