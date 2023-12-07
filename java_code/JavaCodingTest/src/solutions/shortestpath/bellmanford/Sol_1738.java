package solutions.shortestpath.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Sol_1738 {
    /**
     * 5 7
     * 1 2 3
     * 1 3 4
     * 3 1 -7
     * 2 3 2
     * 3 4 1
     * 4 2 -5
     * 4 5 1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] edges = new int[m][3];
        boolean cycleExists = false;

        for (int i=0; i<m; i++) {
            String[] e = br.readLine().split(" ");
            int[] eArray = Arrays.stream(e).mapToInt(s -> Integer.parseInt(s)).toArray();
            edges[i] = eArray;
        }

        int[] weights = new int[n + 1];
        for (int i=2; i<=n; i++) {
            weights[i] = Integer.MIN_VALUE;
        }

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            paths.add(new ArrayList<Integer>());
        }
        paths.get(1).add(1);

        for (int i=0; i<n; i++) {
            boolean isChanged = false;
            for (int[] eArray : edges) {
                if (weights[eArray[1]] < weights[eArray[0]] + eArray[2]) {
                    weights[eArray[1]] = weights[eArray[0]] + eArray[2];
                    paths.get(eArray[1]).clear();
                    paths.get(eArray[1]).addAll(paths.get(eArray[0]));
                    paths.get(eArray[1]).add(eArray[1]);

                    isChanged = true;
                }
            }
            if (i == n-1 && isChanged) {
                cycleExists = true;
            }
        }

        String answer = "";
        if (paths.get(n).size() > 0 && cycleExists == false) {
            answer += paths.get(n).get(0);
            for (int i=1; i<paths.get(n).size(); i++) {
                answer += " " + paths.get(n).get(i);
            }
        }

        System.out.println(cycleExists || answer.equals("") ? -1 : answer);

        br.close();
    }


}
