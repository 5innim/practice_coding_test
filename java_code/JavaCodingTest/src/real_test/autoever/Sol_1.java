package real_test.autoever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Sol_1 {

    /**
     *  조합으로 2개의 수 뽑아서 합한 후 이진수로 했을 때 가장 1이 많은 횟수
     *
     *  n <= 200000
     *  v <= 4000
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        int[] cnts = new int[4001];
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            if (cnts[Integer.parseInt(input)] >= 2) continue;
            numbers.add(Integer.parseInt(input));
            cnts[Integer.parseInt(input)] += 1;
        }

        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        combination(arrays, stack, 0, numbers.size() - 1);

        int result = 0;

        for (ArrayList<Integer> array : arrays) {
            int sum = numbers.get(array.get(0)) + numbers.get(array.get(1));
            int cnt = 0;
            while (sum > 0) {
                cnt += sum % 2;
                sum = sum/2;
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);

        br.close();
    }

    public static void combination(ArrayList<ArrayList<Integer>> arrays, LinkedList<Integer> stack, int start, int end) {
        if (stack.size() >= 2) {
            ArrayList<Integer> array = new ArrayList<>();
            array.add(stack.get(0));
            array.add(stack.get(1));
            return;
        }

        if (start > end) {
            return;
        }

        for (int i=start; i<=end; i++) {
            stack.offerLast(i);
            combination(arrays, stack, i+1, end);
            stack.pollLast();
        }
    }

}
