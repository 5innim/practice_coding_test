package data.stucture.nonlinear;

public class DisjointSet {
    /**
     * 분리 집합: 공통 원소를 가지지 않는 상호 배타적인 집합들을 표현하기 위한 자료구조
     * - make_set, union, find 3가지 연산을 제공한다.
     * - make_set: 주어진 원소만으로 집합을 만들어주는 연산
     * - union: 두개의 집합을 합쳐주는 연산
     * - find: 해당 원소가 어느 집합에 속해있는지 찾아주는 연산
     *
     * * 두 집합(트리)를 합(union)치는 과정에서 선형트리가 생길 수 있다.
     *   - 따라서 기본적으로 find 와 union(연산과정 중 find 사용.) 연산은 최악의 경우 O(n)
     *
     * * find 연산에서 해당 원소가 가리키는 값을 최상위 루트로 하게 하는(find를 재귀적으로 호출) 방법과
     * * union 시에 사이즈 또는 높이가 더 큰 트리의 루트에 연산되는 트리를 붙이는 식으로 개선
     * * 이렇게 되면 O(log(n)) 으로 개선 가능.
     *
     */

    public static void main(String[] args) {
        int[] disjonintSet = new int[9];
        int[] rank = new int[9];
        makeSet(disjonintSet);

    }

    static void makeSet(int[] set) {
        for(int i=0; i<set.length; i++) {
            set[i] = i;
        }

    }

    static int find(int[] set, int n) {
        if (set[n] == n) {
            return n;
        }
        set[n] = find(set, set[n]); // 재귀를 사용하여 부분집합의 모든 노드들은 루트노트를 가리키도록 함.
        return set[n];
    }

    static void union(int[] set, int[] rank, int a, int b) { // tree 의 높이를 비교하기 위해서 높이 정보를 저장할 rank 배열을 사용.
        a = find(set, a);
        b = find(set, b);

        if (rank[a] < rank[b]) {
            int t = a;
            a = b;
            b = t;
        }

        set[b] = a;
        if (rank[a] == rank[b]) {
            rank[a] ++;
        }
    }

}
