package real_test.skt;

public class Solution_1 {

    /**
     * 5 * 5 격자판에 대해 각각의 위치헤 풍선들이 위치하고 1번부터 25번의 번호를 가짐.
     * 입력으로 각각의 위치에 대한 점수와 사용자가 맞춘 다트의 위치가 제공될 때 사용자의 점수는?
     *
     * 가로줄 세로중 1빙고 당 + 10점
     * 처음 시작시 다트 5개를 주는대신 -10점부터 시작.
     * 이후 추가 다트 당 -5 점.
     *
     *
     */

    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int[][] board, int[] darts) {
            int answer = 0;
            boolean[][] checked = new boolean[5][5];

            for (int dart : darts) {
                int r = dart/5;
                int c = dart%5;
                checked[r][c] = true;
            }

            int bingoCnt = 0;

            for (int r=0; r<5; r++) {
                boolean tag = true;
                for (int c=0; c<5; c++) {
                    if (!checked[r][c]) {
                        tag = false;
                        break;
                    }
                }
                if (tag) bingoCnt++;
            }

            for (int c=0; c<5; c++) {
                boolean tag = true;
                for (int r=0; r<5; r++) {
                    if (!checked[r][c]) {
                        tag = false;
                        break;
                    }
                }
                if (tag) bingoCnt++;
            }

            for (int r=0; r<5; r++) {
                for (int c=0; c<5; c++) {
                    if (checked[r][c]) {
                        answer += board[r][c];
                    }
                }
            }

            answer += 10 * bingoCnt;
            answer -= 10;
            answer -= 5*(darts.length - 5);



            return answer;
        }
    }

}
