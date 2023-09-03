package data.stucture.nonlinear.graph.tree;

import java.util.PriorityQueue;

public class HeapTest {
    /**
     * Heap: 완전 이진 트리를 이용한 구조로 항상 부모노드의 값이 자식노드의 값 보다 우선순위가 높도록 유지하는 자료구조
     *  - 삽입과 삭제 시에 O(log(n))
     *  - 가장 높은 우선순위의 값을 조회하는 데 O(1)
     *
     *  *추가시
     *  - 마지막 노드에 삽입 후 부모 노드와 비교하면서 스위칭 작업을 하며 재정렬
     *
     *  *삭제시
     *  - 루트노드 삭제 후 가장 마지막 노드를 루트에 삽입 후 자식과 비교하면서 스위칭 작업을 하며 재정렬
     *
     *  *구현
     *  - java.util 의 PriorityQueue 를 통해서 구현할 수 있다.
     *  - PriorityQueue 사용시 제네릭 타입으로 지정하는 클래스는 Comparable interface를 구현해야한다. (이때 compareTo 의 반환값이 더 낮아야 우선순위가 높다.)
     *  - PriorityQueue 는 내부적으로 collection 프레임워크의 Queue 인터페이스를 구현하고 있다. 따라서 기본적인 offer, poll, peek 메서드는 똑같이 사용할 수 있다.
     */

    public static void main (String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.offer(3);
        heap.offer(1);
        heap.offer(2);
        heap.offer(4);

        System.out.println(heap); // 가장 앞의 요소가 1이다.

        System.out.println(heap.poll()); // O(log(n))

        System.out.println(heap.peek()); // O(1)
    }

}
