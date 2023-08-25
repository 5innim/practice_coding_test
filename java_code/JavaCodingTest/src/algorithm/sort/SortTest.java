package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

    /**
     * 크게 2가지
     * 1. Collections 프레임워크에서 제공하는 정적 sort 메서드 사용 (이 경우 비교에 대한 피연산자가 Comparable 을 구현해야함.)
     * 2. Comparator 함수형 인터페이스의 구현체를 인자로 넘겨주는 방법 (List 의 default 메서드인 sort)
     */

    public static void main(String[] args) {
        /**
         * public static <T extends Comparable<? super T>> void sort(List<T> list)
         * 삽입정렬과 합병정렬을 결합한 형태로 평균, 최악의 경우 O(nlog(n))
         *
         * 제네릭 타입으로 지정되는 클래스는 Comparable 을 구현해야함.
         *
         * - Comparable -
         * Compares this object with the specified object for order.
         * Returns a negative integer, zero, or a positive integer as this object is
         * less than, equal to, or greater than the specified object.
         * 순서를 명시하기 위한 인터페이스로 compareTo 라는 메서드를 구현해야함.
         * 특정 객체와 비교했을 때 작거나 같거나 큰 경우, 음수 또는 0 또는 양수를 반환함.
         *
         */
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("C");
        list.add("B");

        Collections.sort(list);

        System.out.println(list.toString());

        // 내림차순
        list.sort(Comparator.reverseOrder()); // List<>.sort(Comparator ..) 은 내부적으로 Arrays.sort 사용 최악시 O(n^2)
        System.out.println(list.toString());

        // 따라서 toCompare 를 overriding 하는 자식 클래스를 만들어서 정렬순서를 새롭게 정의하는 게 나을듯.

    }

}
