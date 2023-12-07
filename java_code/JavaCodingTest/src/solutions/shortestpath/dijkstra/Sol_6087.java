package solutions.shortestpath.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Sol_6087 {
    /*
7 8
.......
......C
......*
*****.*
....*..
....*..
.C..*..
.......

     */

    static int r;
    static int c;

    static char[][] map;

    static ArrayList<ArrayList<Integer>> points;
    static int[][] fVArray = {{0, 0}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        points = new ArrayList<>();

        for (int i=0; i<r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j=0; j<c; j++) {
                if (map[i][j] == 'C') {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    points.add(list);
                }
            }
        }

        System.out.println(dijkstra(points.get(0), points.get(1)));

        br.close();
    }

    static int dijkstra(ArrayList<Integer> start, ArrayList<Integer> end) {

        PriorityQueue<Node> heap = new PriorityQueue<>();

        int[][][] costs = new int[r][c][5];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }
        Arrays.fill(costs[start.get(0)][start.get(1)], 0);

        heap.offer(new Node(start.get(0), start.get(1), 0, 0));

        while (heap.peek() != null) {
            Node p = heap.poll();

            for (int i=1; i<5; i++) {
                int nextR = p.row + fVArray[i][0];
                int nextC = p.col + fVArray[i][1];

                if (nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) continue;
                if (map[nextR][nextC] == '*') continue;

                if (p.dir != 0 && p.dir != i) {
                    if (costs[nextR][nextC][i] > p.cnt + 1) {
                        costs[nextR][nextC][i] = p.cnt + 1;
                        heap.offer(new Node(nextR, nextC, p.cnt + 1, i));
                    }
                } else if (p.dir == 0 || p.dir == i) {
                    if (costs[nextR][nextC][i] > p.cnt) {
                        costs[nextR][nextC][i] = p.cnt;
                        heap.offer(new Node(nextR, nextC, p.cnt, i));
                    }
                }

            }
        }

        int min = Integer.MAX_VALUE;
        for (int m : costs[end.get(0)][end.get(1)]) {
            min = Math.min(min, m);
        }

        return min;
    }

    static class Node implements Comparable<Node> {
        int row;
        int col;
        int cnt;
        int dir;

        Node(int row, int col, int cnt, int dir) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node node) {
            return this.cnt - node.cnt;
        }
    }
}