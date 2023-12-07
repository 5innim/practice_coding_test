package solutions.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Sol_2458 {

    /**
     * 6 6
     * 1 5
     * 3 4
     * 5 4
     * 4 2
     * 4 6
     * 5 2
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>());

        ArrayList<ArrayList<Integer>> edgesReverse = new ArrayList<>();
        edgesReverse.add(new ArrayList<>());

        HashSet<Integer> result = new HashSet<>();
        for (int i=1; i<=n; i++) {
            result.add(i);
            edges.add(new ArrayList<>());
            edgesReverse.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges.get(a).add(b);
            edgesReverse.get(b).add(a);
        }

        for (int i=1; i<=n; i++) {
            HashSet<Integer> hs = new HashSet<>();
            HashSet<Integer> hsReverse = new HashSet<>();
            dfs(hs, edges, i);
            dfs(hsReverse, edgesReverse,i);
            hs.addAll(hsReverse);
            result.retainAll(hs);
        }

        System.out.println(result);


        br.close();
    }

    private static void dfs(HashSet<Integer> hs, ArrayList<ArrayList<Integer>> edges, int start) {
        hs.add(start);
        for (int e : edges.get(start)) {
            if (hs.contains(e)) continue;
            dfs(hs, edges, e);
        }
    }

}
