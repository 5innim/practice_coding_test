package algorithm.sort;

import java.util.*;

public class QuickSort {

    /**
     *
     *  퀵 정렬
     *      - 평균 O(n*log(n)), 최악 O(n^2)
     *      - 가장 첫 원소를 pivot 으로 두고 left = pivot + 1, right = 마지막 index  로 초기화
     *          left 는 오른쪽으로 이동하며 pivot 보다 큰 값을 찾고, right 는 왼쪽으로 이동하며 pivot
     *          보다 작은 값을 찾는다.
     *          양쪽의 값이 찾아진 이후 만약 left 와 right 가 교차하지 않았다면 서로 값을 바꿔주고,
     *          교차하였다면 right 와  pivot 의 위치를 바꿔주고 pivot 을 기준으로 배열을 나눈 뒤
     *          각 배열에 위 과정을 반복
     *
     */

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 2,3,7,5,8, 32, 34, 87,1,6,76,2,43,12};
        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }

    static void quickSort(int[] a, int start, int end) {
        int pivot = start;
        int left = start + 1;
        int right = end;
        if (left > right) {
            System.out.println("over");
            return;
        }

        while(true) {
            for (int i=left; i<=end; i++) {
                left = i;
                if (a[i] > a[pivot]) {
                    break;
                }
            }

            for (int i=right; i>pivot; i--) {
                right = i;
                if (a[i] < a[pivot]) {
                    break;
                }
            }

            if (right <= left) {
                int minI = pivot;
                if (a[pivot] > a[right]) minI = right;
                tradeValue(a, pivot, minI);
                quickSort(a, start, minI - 1);
                quickSort(a, minI + 1, end);
                return;

            } else if (right > left) {
                tradeValue(a, right, left);
            }
        }
    }

    static void tradeValue(int[] a, int i1, int i2) {
        int t = a[i1];
        a[i1] = a[i2];
        a[i2] = t;
    }

}
