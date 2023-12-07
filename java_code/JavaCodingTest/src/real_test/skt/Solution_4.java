package real_test.skt;
import java.util.PriorityQueue;

public class Solution_4 {

    /**
     * n 이 2~5 일때 nxn 행렬 에 한 쌍의 알파벳들이 위치, 빈 공간은 . 장애물은 #
     * 빈 공간에 전선을 두어 알파벳끼리 연결. 알파벳끼리 연결시키는 선들이 다른 알파벳을 연결시키는 선들과 겹쳐서는 안됨.
     *
     * => 그리디 + bfs 문제라고 생각. 가장 중심에서부터 시작하여 만나는 알파벳에 대해서 bfs 알고리즘을 수행하여
     * 전선을 하나씩 채워감. 이렇게 할 경우 사로 겹치는 전선없이 모두 연결 가능하다고 생각했음.
     *
     */

    public static void main(String[] args) {

    }

    class Solution {

        int center;

        public int[][] solution(int n, String[] board) {
            int[][] answer = {};
            center = n/2;

            PriorityQueue<Node> heap = new PriorityQueue<>();
            for (int i=0; i<n; i++) {
                char[] chars = board[i].toCharArray();
                for (int j=0; j<n; j++) {
                    heap.offer(new Node(i, j));
                }
            }

            // 가장 안쪽 노드부터 bfs

            return answer;
        }

        class Node implements Comparable<Node> {
            int row;
            int col;

            Node(int row, int col) {
                this.row = row;
                this.col = col;
            }

            @Override
            public int compareTo(Node node) {
                int a = Math.abs(center - this.row) + Math.abs(center - this.col);
                int b = Math.abs(center - node.row) + Math.abs(center - node.col);
                return a - b;
            }
        }
    }

}
