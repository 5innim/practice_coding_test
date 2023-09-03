package data.stucture.nonlinear.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphTest {

    /**
     * CodingTest 에서 많이 쓰는 그래프 구현 방법은 크게 2가지
     *  - 인접 리스트
     *      - 2차원 배열에서 해당 index 값을 가지는 노드가 있다고 하면 그 노드에 연결된 노드 값들을 원소로 가지게 함.
     *      - 어떤 노드에 연결된 노드들을 순회해야할 때 노드들의 정보에 접근하기 용이하다.
     *      - 특정 노드 A 와 B 사이의 간선 유무를 확인해야할 때 노드 A 에 연결된 모든 노드들을 순회해야한다.
     *  - 인접 행렬
     *      - 2차원 배열에서 각각 노드들의 연결정보를 나타내도록 한다.
     *      - 어떤 노드 A 가 있다하면 노드 A 에 연결된 노드들을 찾기위해 모든 노드들을 확인해야한다.
     *      - 어떤 노드 A 와 B의 간선 정보를 index로 빠르게 확인할 수 있다.
     *
     */

    public static void main(String[] args) {

        /**
         *       1 ----- 2
         *       |     /
         *       |   /
         *       | /
         *       3 ------- 4
         *
         */

        int[][] input = {{1, 2}, {1, 3}, {2, 3}, {3, 4}};

        // 인접리스트
        ArrayList<ArrayList<Integer>> infoList = new ArrayList<>();
        for (int i=0; i<5; i++) {
            infoList.add(new ArrayList<>());
        }

        for (int[] i : input) {
            infoList.get(i[0]).add(i[1]);
            infoList.get(i[1]).add(i[0]);
        }

        System.out.println(infoList);


        // 인접행렬
        int[][] infoArray = new int[5][5];
        for (int[] i : input){
            infoArray[i[0]][i[1]] = 1;
            infoArray[i[1]][i[0]] = 1;
        }

        for (int[] info : infoArray) {
            System.out.println(Arrays.toString(info));
        }

    }

}
