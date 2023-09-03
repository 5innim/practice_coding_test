package data.stucture.linear.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackTest {

    /**
     *  스택: LIFO 정책을 사용하는 선형의 자료구조
     *    - 연결리스트와 마찬 가지로 특정 요소를 조회하는 데 O(n), push&pop&peek 은 O(1)
     *
     *  * Stack 클래스의 멤버 메서드를 보면 synchronized keyword 를 사용하여 thread safe 하다.
     *      - 단일 스레드 사용시 Deque 를 이용해 Stack 을 구현하면 성능향상의 효과를 기대해볼 수 있겠다.
     */

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();

        stack.offerFirst(1);
        stack.offerFirst(2);
        stack.offerFirst(3);

        System.out.println(stack.toString());
        System.out.println(stack.pollFirst());

        LinkedList<Integer> list = (LinkedList<Integer>) stack;
        System.out.println(list.get(1)); // O(n)
    }

}
