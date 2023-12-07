package solutions.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Sol_2294 {

    /**
     * n가지 종류의 동전이 있다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그러면서 동전의 개수가 최소가 되도록 하려고 한다. 각각의 동전은
     * 몇 개라도 사용할 수 있다.
     * <p>
     * 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
     * <p>
     * 첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는
     * 100,000보다 작거나 같은 자연수이다. 가치가 같은 동전이 여러 번 주어질 수도 있다.
     * <p>
     * 3 15
     * 1
     * 5
     * 12
     */

    static int n;
    static int k;
    static int[] counts;

    static ArrayList<Integer> coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        counts = new int[k+1];
        Arrays.fill(counts,Integer.MAX_VALUE - 1);
        counts[0] = 0;
        coins = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a <= k) {
                counts[a] = 1;
                coins.add(a);
            }
        }

        for (int i=0; i<k+1; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                counts[i] = Math.min(counts[i - coin] + 1, counts[i]);
            }
        }

        System.out.println((counts[k] == Integer.MAX_VALUE - 1)?-1:counts[k]);

        br.close();
    }

}