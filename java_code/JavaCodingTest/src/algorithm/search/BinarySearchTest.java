package algorithm.search;

public class BinarySearchTest {
    /**
     *
     * 이분탐색(Binary search)
     *   - 매 탐색시 탐색범위를 1/2로 좁혀가며 진행하는 탐색 알고리즘. O(lon(n))
     *   - 탐색을 진행할 리스트가 정렬되어 있다는 조건 필요.
     */

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11};
        int target = 7;
        int left = 0;
        int right = array.length - 1;

        while (true) {
            int t = left + (right - left)/2;
            if (target == array[t]) {
                System.out.println(t);
                break;
            } else if (array[t] < target) {
                left = t + 1;
            } else if (array[t] > target) {
                right = t - 1;
            }
        }



    }


    // 재귀함수 사용
    static int binarySearch(int[] a, int start, int end, int target) {
        if (start == end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] < target) {
            return binarySearch(a, mid + 1, end, target);
        } else {
            return binarySearch(a, start, mid - 1, target);
        }
    }

}
