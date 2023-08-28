package algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    /**
     * 삽입정렬
     *  - 가장 앞 첫 번째 원소가 이미 정렬되어 있다고 가정하고 그 뒤의 원소들을 차례대로 적절한 위치에 삽입하는 정렬
     *  - O(n^2)
     *  - 삽입시에 기존 원소들의 위치를 뒤로 한칸씩 움직여야 하므로 추가적인 시간소요가 발생한다.
     *      - 연결리스트를 생각해보았지만 어떤 위치에 삽입하거나 비교시에 index를 사용해야 하므로 연결리스트의 경우 index 위치의 원소를 찾는 시간 때문에 더 나은 방법이라고는 보장 못하겠다.
     */

    public static void main (String[] args) {

        int[] array = new int[] {6, 5, 4, 3, 2, 1};

        for (int i=1; i<array.length; i++) {
            int switchP = i;

            for (int j=0; j<i; j++) {
                if (array[j] > array[i]) {
                    switchP = j;
                    break;
                }
            }

            int switchV = array[i];
            for (int j=i-1; j>=switchP; j--) {
                array[j + 1] = array[j];
            }
            array[switchP] = switchV;
        }

        System.out.println(Arrays.toString(array));
    }

}
