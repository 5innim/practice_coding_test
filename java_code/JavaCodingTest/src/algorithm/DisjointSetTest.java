package algorithm;

public class DisjointSetTest {

    /**
     *
     * - disjoint set (서로소 집합)
     *   : 공통 노드가 전혀없는 서로소 집합을 관리하기 위한 알고리즘
     *   1. union, find 함수 구현을 해야하므로 union-find 알고리즘이라고도 알려져있다.
     *      - find: 입력으로 받은 노드의 부모 노드를 찾기위한 함수. 일반적으로 집합 안에서 가장 작은 번호를 가진 노드를
     *              부모노드로 한다. 노드가 선형적으로 이루어진 경우 시간복잡도가 O(n) 이지만 함수를 개선하여 재귀함수를
     *              호출하는 과정에서 부모노드를 재설정하도록 수정하면 거의 상수시간(실제로는 O(a(n)), 아커만함수의 역함수)까지 줄일 수 있다.
     *      - union: 서로소인 두 집합을 합하기 위한 함수. 이때 입력으로 받은 두 노드의 부모노드를 찾고, 더큰 번호를 가진
     *              부모노드의 부모를 상대 부모 노드로 설정해줘야한다.
     *   2. 처음 노드 초기화시에 모든 노드들이 자기 자신을 가리키도록 한다.
     */

    public static void main(String[] args) {
        int[] nodes = new int[6];
        for (int i=1; i<=5; i++) nodes[i] = i;


    }

    static int find(int[] nodes, int n) {
        if (nodes[n] == n) return n;
        return nodes[n] = find(nodes, nodes[n]);
    }

    static void union(int[] nodes, int a, int b) {
        int aP = find(nodes, a);
        int bP = find(nodes, b);

        if (aP > bP) {
            nodes[aP] = bP;
        } else {
            nodes[bP] = aP;
        }
    }

}
