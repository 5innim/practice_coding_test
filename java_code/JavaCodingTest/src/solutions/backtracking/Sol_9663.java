package solutions.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_9663 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(dfs(n, 1, new int[n]));
    }

    static int dfs(int n, int turn, int[] checked) {
        int result = 0;

        for(int i=1; i<n+1; i++) {
            boolean possible = true;
            for (int j=1; j<turn; j++) {
                int d = turn - j;
                if (i == checked[j]-d || i == checked[j]+d || i== checked[j]) {
                    possible = false;
                    break;
                }
            }
            if (!possible) continue;
            if (n == turn) return 1;
            checked[turn] = i;
            result += dfs(n, turn + 1, checked);
        }

        return result;
    }




}
