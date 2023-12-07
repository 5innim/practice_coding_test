package solutions.shortestpath.dijkstra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class Sol_2151 {

    /**
     *
     *
     *
     * 5
     * ***#*
     * *.!.*
     * *!.!*
     * *.!.*
     * *#***
     *
     *  0, 2 -> 1, 3
     *  1, 3 -> 0, 2
     */

    public static final int[] ver = {-1, 0, 1, 0};
    public static final int[] hor = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int r = 0;
        int c = 0;

        char[][] map = new char[n][];
        for (int i=0; i<n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j=0; j<n; j++) {
                if (map[i][j] == '#') {
                    r = i;
                    c = j;
                }
            }
        }

        int[][][] weights = new int[n][n][4];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                weights[i][j] = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(r, c, 0, -1));
        weights[r][c] = new int[] {0, 0, 0, 0};

        boolean isArrived = false;
        while (queue.isEmpty() == false && isArrived == false) {
            Node tNode = queue.poll();
            ArrayList<Node> nodeArrayList = new ArrayList<>();
            if (map[tNode.row][tNode.col] == '#') {
                for (int i=0; i<4; i++) {
                    int nRow = tNode.row + ver[i];
                    int nCol = tNode.col + hor[i];
                    nodeArrayList.add(new Node(nRow, nCol, tNode.mirror, i));
                }
            }
            if (map[tNode.row][tNode.col] == '!') {
                int[] vArray = (tNode.v==0 || tNode.v==2) ? new int[]{1, 3} : new int[]{0, 2};
                int lRow = tNode.row + ver[vArray[0]];
                int lCol = tNode.col + hor[vArray[0]];
                nodeArrayList.add(new Node(lRow, lCol, tNode.mirror + 1, vArray[0]));

                int rRow = tNode.row + ver[vArray[1]];
                int rCol = tNode.col + hor[vArray[1]];
                nodeArrayList.add(new Node(rRow, rCol, tNode.mirror + 1, vArray[1]));

                int nRow = tNode.row + ver[tNode.v];
                int nCol = tNode.col + hor[tNode.v];
                nodeArrayList.add(new Node(nRow, nCol, tNode.mirror, tNode.v));
            }
            if (map[tNode.row][tNode.col] == '.') {
                int nRow = tNode.row + ver[tNode.v];
                int nCol = tNode.col + hor[tNode.v];
                nodeArrayList.add(new Node(nRow, nCol, tNode.mirror, tNode.v));
            }

            for (Node node : nodeArrayList) {
                if (node.row < 0 || node.row >= n) continue;
                if (node.col < 0 || node.col >= n) continue;
                if (map[node.row][node.col] == '*') continue;
                if (weights[node.row][node.col][node.v] <= node.mirror) continue;
                if (map[node.row][node.col] == '#') {
                    System.out.println(node.mirror);
                    isArrived = true;
                    break;
                }
                queue.offer(node);
                weights[node.row][node.col][node.v] = node.mirror;
            }
        }
    }
}

class Node implements Comparable<Node>{
    int row;
    int col;
    int mirror;
    int v;

    public Node(int row, int col, int mirror, int v) {
        this.row = row;
        this.col = col;
        this.mirror = mirror;
        this.v = v;
    }

    @Override
    public int compareTo(Node n) {
        return mirror - n.mirror;
    }
}
