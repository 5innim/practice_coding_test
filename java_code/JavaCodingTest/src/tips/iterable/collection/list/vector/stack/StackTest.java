package tips.iterable.collection.list.vector.stack;

import java.util.Stack;

public class StackTest {

    /**
     *  스택: LIFO 정책을 사용하는 선형의 자료구조
     *    - 연결리스트와 마찬 가지로 특정 요소를 조회하는 데 O(n), push&pop&peek 은 O(1)
     *
     *  * Stack 클래스의 멤버 메서드를 보면 synchronized keyword 를 사용하여 thread safe 하다.
     *      - 단일 스레드 사용시 Deque 를 이용해 Stack 을 구현하면 성능향상의 효과를 기대해볼 수 있겠다.
     */

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
