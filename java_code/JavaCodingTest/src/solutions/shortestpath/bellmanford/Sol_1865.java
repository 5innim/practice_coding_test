package solutions.shortestpath.bellmanford;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;

public class Sol_1865 {
    /*
2       TC
3 3 1   N, M, W
1 2 2   S  E  T
1 3 4   S  E  T
2 3 1   S  E  T
3 1 3   S  E  -T
3 2 1   N, M, W
1 2 3   S  E  T
2 3 4   S  E  T
3 1 8   S  E  -T

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i=0; i<tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int[] shortestArray = new int[n + 1];
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            for (int j=2; j<n+1; j++) shortestArray[j] = 10001;

            boolean result = true;

            for (int j=0; j<m; j++) {
                st = new StringTokenizer(br.readLine());
                ArrayList<Integer> list = new ArrayList();
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                list.add(s);
                list.add(e);
                list.add(t);
                edges.add(list);

                list = new ArrayList();
                list.add(e);
                list.add(s);
                list.add(t);
                edges.add(list);
            }

            for (int j=0; j<w; j++) {
                st = new StringTokenizer(br.readLine());
                ArrayList<Integer> list = new ArrayList();
                list.add(Integer.parseInt(st.nextToken()));
                list.add(Integer.parseInt(st.nextToken()));
                list.add(-Integer.parseInt(st.nextToken()));
                edges.add(list);
            }

            for (int v=1; v<n+1; v++) {
                for (ArrayList<Integer> e : edges) {
                    if (shortestArray[e.get(1)] > shortestArray[e.get(0)] + e.get(2)) {
                        shortestArray[e.get(1)] = shortestArray[e.get(0)] + e.get(2);
                        if (v == n) {
                            result = false;
                        }
                    }
                }
            }

            System.out.println(result?"NO":"YES");

        }
        br.close();
    }

}
