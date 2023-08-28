package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

    /**
     * 선택정렬
     *  - 리스트에서 가장 작은 수를 찾는 과정을 반복하여 앞에서부터 채워나가는 정렬
     *  - O(n^2)
     *
     */
    public static void main(String[] args) {
        int[] array = new int[] {6, 5, 4, 3, 2, 1};

        for (int i=0; i<array.length-1; i++) {
            int minNum = 100;
            int minIndex = array.length - 1;
            for (int j=i; j<array.length; j++) {
                if (minNum > array[j]) {
                    minNum = array[j];
                    minIndex = j;
                }
            }

            if (minIndex == i) continue;

            int switchV = array[i];
            array[i] = minNum;
            array[minIndex] = switchV;
        }

        System.out.println(Arrays.toString(array));

    }

}
