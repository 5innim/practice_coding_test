package solutions.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Sol_1600 {
    /**
     *
     * 입력
     * 첫째 줄에 정수 K가 주어진다. 둘째 줄에 격자판의 가로길이 W, 세로길이 H가 주어진다.
     *
     *
     * 1
     * 4 4
     * 0 0 0 0
     * 1 0 0 0
     * 0 0 1 0
     * 0 1 0 0
     *
     * 출력
     * 첫째 줄에 원숭이의 동작수의 최솟값을 출력한다. 시작점에서 도착점까지 갈 수 없는 경우엔 -1을 출력한다.
     */
    static int k;
    static int w;
    static int h;
    static int[][] map;

    static int[][] fVArray = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] hVArray = {{2, 1}, {-2, 1}, {-2, -1}, {2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};

    public static void main(String[] args) throws IOException { // 말은 장애물을 뛰어넘을 수 있다고 함..
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];

        for (int i=0; i<h; i++) {
            String[] str = br.readLine().split(" ");

            for (int j=0; j<w; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println(bfs());;

        br.close();

    }

    static int bfs() {
        int[][][] costs =  new int[h][w][k + 1];
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,0,0));
        costs[0][0][0] = 0;
        while (queue.peek() != null) {
            Node p = queue.poll();

            for (int[] v : fVArray) {
                int nextR = p.row + v[0];
                int nextC = p.col + v[1];

                if (nextR < 0 || nextR >= h || nextC < 0 || nextC >= w)
                    continue;
                if (map[nextR][nextC] == 1) continue;

                if (costs[nextR][nextC][p.cnt] > p.value + 1) {
                    costs[nextR][nextC][p.cnt] = p.value + 1;
                    queue.offer(new Node(nextR, nextC, p.cnt, p.value + 1));
                }
            }

            if (p.cnt >= k)
                continue;

            for (int[] v : hVArray) {
                int nextR = p.row + v[0];
                int nextC = p.col + v[1];

                if (nextR < 0 || nextR >= h || nextC < 0 || nextC >= w)
                    continue;
                if (map[nextR][nextC] == 1) continue;

                if (costs[nextR][nextC][p.cnt + 1] > p.value + 1) {
                    costs[nextR][nextC][p.cnt + 1] = p.value + 1;
                    queue.offer(new Node(nextR, nextC, p.cnt + 1, p.value + 1));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int v : costs[h-1][w-1]) {
            min = Math.min(min, v);
        }

        return (min==Integer.MAX_VALUE)?-1:min;


    }

    static class Node {
        int row;
        int col;
        int cnt;
        int value;

        Node(int row, int col, int cnt, int value) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.value = value;
        }
    }


}
