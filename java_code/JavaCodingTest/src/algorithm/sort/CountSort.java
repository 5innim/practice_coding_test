package algorithm.sort;

import java.util.ArrayList;

public class CountSort {

    /**
     *
     * 계수정렬: 특수한 상황에서만 사용할 수 있는 매우 빠른 정렬 알고리즘이다.
     *  - 데이터의 크기 범위가 제한되어 양의 정수 형태로 표현할 수 있을 때 사용 가능.
     *  - 시간복잡도는 O(N + K) 이다.
     */

    public static void main(String[] args) {
        int[] cntArray = new int[10];
        int[] inputArray = {0,4,0,6,7,4,9,9,1,3,5,6,3};
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : inputArray) {
            cntArray[i] ++;
        }

        for (int i=0; i<cntArray.length; i++) {
            for (int j=0; j<cntArray[i]; j++) {
                result.add(i);
            }
        }

        System.out.println(result);

    }
}
