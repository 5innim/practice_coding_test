package real_test.skt;

import java.util.Deque;
import java.util.LinkedList;
public class Solution_3 {

    /**
     *
     * 스택을 사용한 구현 문제.
     *
     *  1. 페이지 이동.
     *      현재 페이지를 idx로 하고 idx는 1증가. 이때 뒤로기가 스택에 기존 현재 페이지를 추가.
     *      앞으로가기 스택은 비움.
     *  2. 뒤로가기.
     *      현재 페이지를 뒤로가기 스텍의 제일 앞에있는 것으로 하고 기존 현재 페이지를 앞으로가기 스택에 추가.
     *      뒤로가기 스텍이 빈 경우 실행불가.
     *  3. 앞으로가기.
     *      현재 페이지를 앞으로가기 스텍의 제일 앞에있는 것으로 하고 기존 현재 페이지를 뒤로가기 스택에 추가.
     *      앞으로가기 스텍이 빈 경우 실행불가.
     *
     * 입력
     *      실행 기능과 반복횟수를 하나의 원소로하는 배열
     *
     *      *기억에는 list 최대 길이가 10의 9승 이었던 거 같음. 그래서 자료형을 long 을 사용했던 기억이..?
     *
     * 출력
     *      하나의 원소에 대한 실행을 했을 때 현재 페이지
     *
     */

    public long[] solution(int[][] list) {
        long[] answer = new long[list.length];
        long idx = 0;
        long now = 0;

        Deque<Long> back = new LinkedList<>();
        Deque<Long> front = new LinkedList<>();

        int cnt = 0;
        for (int[] l : list) {
            for (int i=0; i<l[1]; i++) {
                if (l[0] == 0){
                    back.offerLast(now);
                    now = idx;
                    idx += 1;
                    front = new LinkedList<>();

                } else if (l[0] == -1) {
                    if (!back.isEmpty()) {
                        front.offerLast(now);
                        now = back.pollLast();
                    }

                } else if (l[0] == 1) {
                    if (!front.isEmpty()) {
                        back.offerLast(now);
                        now = front.pollLast();
                    }
                }
            }
            answer[cnt] = now;
            cnt++;

        }
        return answer;
    }

}
