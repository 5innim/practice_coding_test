package real_test.kakao;

public class Sol_5 {
    public static void main(String[] args) {

    }

}

class Solution5 {
    public int solution(int n, int[] tops) {
        int answer = 0;

        int[][] costs = new int[2*n + 1][2];

        costs[0][0] = 1;
        costs[0][1] = 0;

        for (int i=1; i<2*n+1; i++) {
            costs[i][0] = costs[i-1][0] + costs[i-1][1];
            costs[i][1] = costs[i-1][0] + (((i - 1) % 2 == 0 && tops[(i - 1) / 2] == 1) ? costs[i][0]:0);
        }

        answer = (costs[2*n][0] + costs[2*n][1]) % 10007;

        return answer;
    }


}
