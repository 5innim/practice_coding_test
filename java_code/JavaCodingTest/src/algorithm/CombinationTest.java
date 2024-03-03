package algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class CombinationTest {
    /**
     *
     *  - nCr: n개 중에서 r개를 뽑는 경우를 찾는 것으로 시간 복잡도는 O(2^n) 으로 굉장히 크다.
     *
     */

    public static void main(String[] args) {

        int n = 5;
        int r = 2;
        int[] nArray = {1, 2, 3, 4, 5};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();

        combination(0, n, r, nArray, stack, result);

        System.out.println(result);
    }

    static void combination(int start, int n, int r, int[] nArray, Deque<Integer> stack, ArrayList<ArrayList<Integer>> result) {
        if (stack.size() == r) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i=start; i<n; i++) {
            stack.offerLast(nArray[i]);
            combination(i+1, n, r, nArray, stack, result);
            stack.pollLast();
        }
    }


}
