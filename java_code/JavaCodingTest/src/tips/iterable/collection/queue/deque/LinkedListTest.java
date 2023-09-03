package tips.iterable.collection.queue.deque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinkedListTest {
    /**
     *
     *  Queue: FIFO 정책을 따르는 자료구조
     *    - rear: 추가(enqueue) 연산만 싱행하는 맨뒤
     *    - front: 삭제(dequeue) 연산만 실행하는 맨앞
     *
     *   *Java 에서는 LinkedList 를 통해서 Queue 를 선언
     *   LinkedList 는 Deque 를 구현하고 Deque 는 Queue 를 상속
     *   Deque 는 Queue 자료구조에 대한 연산을 양끝에서 모두 수행할 수 있는 자료구조
     *   => stack 으로도 사용할 수 있음.
     *
     *   *Queue 의 메서드
     *                        예외발생            값 반환
     *   (enqueue)            add(e)            offer(e)
     *   (dequeue)            remove()          poll()
     *   (peek)               element()         peek()
     *
     *   *구현부를 보면 기본적으로 Thread safe 하지않다.
     */

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        boolean a = queue.add(1); // queue 에 데이터를 추가할 수 없는 상태일 경우 예외발생
        boolean b = queue.offer(1); // queue 에 데이터를 추가할 수 없는 상태일 경우 false 반환

        Integer a1 = queue.remove(); // queue dequeue 할 데이터가 없으면 예외발생
        Integer b1 = queue.poll(); // queue dequeue 할 데이터가 없으면 null 반환

        Integer a2 = queue.element(); // queue 의 맨 앞에 값 조회할게 없으면 예외발생
        Integer b2 = queue.peek(); // queue 의 맨 앞에 값 조회할게 없으면 null 반환

        System.out.println(a);
        System.out.println(b);

    }


}
