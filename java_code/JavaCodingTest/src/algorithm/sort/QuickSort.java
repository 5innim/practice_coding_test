package algorithm.sort;

import java.util.Arrays;
import java.util.function.Consumer;

public class QuickSort {

    /**
     * 퀵 정렬
     *  - 맨 앞의 원소를 피봇으로 하며 좌측과 우측에서부터 피봇과 크기를 비교하면서 정렬,
     *    좌측과 우측을 가르키는 index 가 교차하는 시점에 좌측을 가리키던 index 의 원소와 pivot 의 원소를 교체 후
     *    pivot 을 기준으로 2개의 list로 분할하여 각각의 list에 위 과정을 반복
     *  - 매 사이클마다 정렬을 해야 할 list의 크기가 절반 가량 줄어듬 -> log(n) 따라서 평균적으로 O(nlog(n))
     *    ,하지만 최악의 경우 O(n^2)
     *
     *  * 구현시 재귀함수에 인자로 슬라이싱한 배열을 넘겨주는 것 보다 index를 넘기는 방법이 메모리를 생각했을 때 효율적
     */

    public static void main (String[] args) {
        int[] array = {1,4,3,9,8,4,5,7,6};

        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    static void quickSort(int[] array, int start, int end) {
        int pivot = start;
        int leftI = start + 1;
        int rightI = end;
        if (leftI > rightI) {
            System.out.println("over");
            return;
        }

        while (true) {
            System.out.println("--1: " + Arrays.toString(array));
            for (int i=leftI; i<=end; i++) {
                leftI = i;
                if (array[i]>array[pivot]) break;
            }

            for (int i=rightI; i>start; i--) {
                rightI = i;
                if (array[i]<array[pivot]) break;

            }

            System.out.println("pivot: " + array[pivot]);
            System.out.println("leftI: " + array[leftI]);
            System.out.println("rightI: " + array[rightI]);
            if (leftI >= rightI) {
                int minI = pivot;
                for(int i : new int[]{pivot, leftI, rightI}) if (array[minI] > array[i]) minI = i;
                trade(array, pivot, minI);
                System.out.println("--2: " + Arrays.toString(array));
                quickSort(array, start, minI - 1);
                quickSort(array, minI + 1, end);
                return;
            }
            else if (rightI > leftI) {
                trade(array, leftI, rightI);
                System.out.println("--3: " + Arrays.toString(array));
            } else System.out.println("it's not expected");
        }

    }

    static void trade(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

}
