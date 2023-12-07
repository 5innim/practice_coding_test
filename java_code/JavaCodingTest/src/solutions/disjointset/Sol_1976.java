package solutions.disjointset;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Sol_1976 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] disjointSet = new int[n+1];
        int[] rank = new int[n+1];

        makeSet(disjointSet, rank);

        for (int i=1; i<n+1; i++) {
            String[] info = br.readLine().split(" ");
            for (int j=1; j<n+1; j++) {
                if (Integer.parseInt(info[j]) == 1){
                    union(disjointSet, rank, i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = find(disjointSet, Integer.parseInt(st.nextToken()));
        boolean result = true;

        while(st.hasMoreTokens()) {
            if (r == Integer.parseInt(st.nextToken())) {
                result = false;
                break;
            }
        }

        System.out.println(result);

        br.close();
    }

    static void makeSet(int[] disjointSet, int[] rank) {
        for (int i=0; i<disjointSet.length+1; i++) disjointSet[i] = i;
        for (int i=1; i<rank.length+1; i++) rank[i] = 1;
    }

    static int find(int[] disjointSet, int node) {
        if (node == disjointSet[node]) {
            return node;
        }

        disjointSet[node] = find(disjointSet, node);

        return disjointSet[node];
    }

    static void union(int[] disjointSet, int[] rank, int a, int b) {
        a = find(disjointSet, a);
        b = find(disjointSet, b);

        if (rank[b] > rank[a]) {
            int t = a;
            a = b;
            b = t;
        }

        disjointSet[b] = a;
        if (rank[b] == rank[a]) {
            rank[a]++;
        }
    }


}
