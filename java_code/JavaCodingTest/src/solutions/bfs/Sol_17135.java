package solutions.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Arrays;

public class Sol_17135 {
    /**
     * 캐슬 디펜스는 성을 향해 몰려오는 적을 잡는 턴 방식의 게임이다. 게임이 진행되는 곳은 크기가 N×M인 격자판으로 나타낼 수 있다.
     * 격자판은 1×1 크기의 칸으로 나누어져 있고, 각 칸에 포함된 적의 수는 최대 하나이다. 격자판의 N번행의 바로 아래(N+1번 행)의 모든 칸에는 성이 있다.
     *
     * 성을 적에게서 지키기 위해 궁수 3명을 배치하려고 한다. 궁수는 성이 있는 칸에 배치할 수 있고, 하나의 칸에는 최대 1명의 궁수만 있을 수 있다.
     * 각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다. 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다.
     * 같은 적이 여러 궁수에게 공격당할 수 있다. 공격받은 적은 게임에서 제외된다.
     * 궁수의 공격이 끝나면, 적이 이동한다. 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다. 모든 적이 격자판에서 제외되면 게임이 끝난다.
     *
     * 게임 설명에서 보다시피 궁수를 배치한 이후의 게임 진행은 정해져있다.
     * 따라서, 이 게임은 궁수의 위치가 중요하다. 격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산해보자.
     *
     * 격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.
     *
     *  ** 입력 **
     *  첫째 줄에 격자판 행의 수 N, 열의 수 M, 궁수의 공격 거리 제한 D가 주어진다. 둘째 줄부터 N개의 줄에는 격자판의 상태가 주어진다. 0은 빈 칸, 1은 적이 있는 칸이다.
     *  5 5 1
     *  0 0 0 0 0
     *  0 0 0 0 0
     *  0 0 0 0 0
     *  0 0 0 0 0
     *  1 1 1 1 1
     *
     *  ** 출력 **
     *  첫째 줄에 궁수의 공격으로 제거할 수 있는 적의 최대 수를 출력한다.
     *  3
     *
     * 제한
     * 3 ≤ N, M ≤ 15
     * 1 ≤ D ≤ 10
     *
     * 1초
     */
    private static final int[] hor = {0, 1, 0};
    private static final int[] ver = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());
        int d = Integer.parseInt(tokens.nextToken());

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        combinate(arrayList, stack, 1, m);


        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j=0; j<=n; j++) {
                a.add(0);
            }
            arrays.add(a);
        }



        for (int i=1; i<=n; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j=1; j<=m; j++) {
                arrays.get(i).set(j, Integer.parseInt(strs[j-1]));
            }
        }

        for (ArrayList<Integer> a : arrayList) {
            int cnt = 0;

            ArrayList<ArrayList<Integer>> arraysClone = new ArrayList<>();

            for (int i=0; i<=n; i++) {
                ArrayList<Integer> aClone = new ArrayList<>();
                for (int j=0; j<=m; j++) {
                    aClone.add(arrays.get(i).get(j));
                }
                arraysClone.add(aClone);
            }

            for (int i=0; i<n; i++) {
                for (int arrow : a) {
                    bfs(arraysClone, arrow, d);
                }

                System.out.println("------------------------");
                System.out.println(a);
                for (ArrayList<Integer> aa : arraysClone) {
                    System.out.println(aa);
                }

                for (int j=1; j<=m; j++) {
                    if (arraysClone.get(1).get(j) > 1) cnt++;
                }
                arraysClone.remove(1);
            }

            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);


        br.close();
    }

    private static void bfs(ArrayList<ArrayList<Integer>> arrays, int arrow, int d) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, arrow, 0));

        HashSet<Node> visited = new HashSet<>();
        visited.add(queue.peek());
        boolean isAttacked = false;
        while(queue.isEmpty() == false && isAttacked == false) {
            Node n = queue.poll();
            if (n.distance >= d) break;
            for (int i=0; i<3; i++) {
                int row = n.row + hor[i];
                int col = n.col + ver[i];
                if (row < 1 || row >= arrays.size()) {
                    continue;
                }
                if (col < 1 || col >= arrays.get(0).size()) {
                    continue;
                }
                Node nNode = new Node(row, col, n.distance + 1);
                if (visited.contains(nNode)) continue;
                if (arrays.get(row).get(col) == 0 || arrays.get(row).get(col) > 1) {
                    queue.offer(nNode);
                    visited.add(nNode);
                    continue;
                }
                if (arrays.get(row).get(col) == 1) {
                    arrays.get(row).set(col, arrays.get(row).get(col) + 1);
                    isAttacked = true;
                    break;
                }
            }
        }
    }

    private static void combinate(ArrayList<ArrayList<Integer>> arrayList, LinkedList<Integer> stack, int start, int end) {
        if (stack.size() >= 3) {
            ArrayList<Integer> a = new ArrayList<>();
            a.addAll(Arrays.asList(stack.get(0), stack.get(1), stack.get(2)));
            arrayList.add(a);
            return;
        }
        if (start > end) {
            return;
        }
        for (int i=start; i<=end; i++) {
            stack.offerLast(i);
            combinate(arrayList, stack, i+1, end);
            stack.pollLast();
        }
    }
}

class Node {
    int row;
    int col;
    int distance;
    public Node(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
    @Override
    public int hashCode() {
        String r = this.row + "99";
        String c = this.col + "99";
        return Integer.parseInt(r + c);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node n = (Node) obj;
            if (this.row == n.row && this.col == n.col) {
                return true;
            }
        }
        return false;
    }
}