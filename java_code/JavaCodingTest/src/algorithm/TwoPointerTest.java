package algorithm;

public class TwoPointerTest {

    /**
     *
     * 투 포인터: 2개의 index 를 카리키는 pointer 를 이용해 특정한 조건을 만족시키는 부분수열을 찾는 알고리즘
     *   - 첫 번째 pointer 를 움직이는 시간복잡도 O(n), 두 번째 pointer 를 움직이는 시간복잡도 O(n)
     *   - 합쳐도 O(n)
     */

    public static void main(String[] args) {
        int[] array = {1,5,2,3,6,8,5,34,5,6,3};
        int target = 9;
        int start = 0;
        int end = 0;
        int sum = 0;
        int result = 0;
        while (end <= array.length) {
            if (sum == target) {
                result ++;
                System.out.println("--" + start + ", " + end);
                sum -= array[start];
                start ++;
            } else if (sum > target) {
                sum -= array[start];
                start ++;
            } else if (sum < target) {
                if (end == array.length) break;
                sum += array[end];
                end ++;
            }
        }

        System.out.println(result);

    }

}
