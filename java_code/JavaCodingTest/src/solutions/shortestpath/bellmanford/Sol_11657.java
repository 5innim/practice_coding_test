package solutions.shortestpath.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Sol_11657 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Edge> edges = new ArrayList<>();


        int[] shortestArray = new int[n+1];
        for (int i=2; i<n+1; i++) {
            shortestArray[i] = 10001;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, d, e));
        }

        boolean isNegative = false;
        for (int v=1; v<n+1; v++) {
            for (Edge e : edges) {
                if (shortestArray[e.start] != 10001 && shortestArray[e.end] > shortestArray[e.start] + shortestArray[e.distance]) {
                    shortestArray[e.end] = shortestArray[e.start] + shortestArray[e.distance];
                    if (v == n) {
                        isNegative = true;
                    }
                }
            }
        }


        br.close();
    }

    static class Edge {
        int start;
        int end;
        int distance;
        Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }



}
