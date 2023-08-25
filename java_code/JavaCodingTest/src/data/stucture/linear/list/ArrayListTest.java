package data.stucture.linear.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    /**
     *
     * list
     * - 인덱스가 없다. 즉 조회가 느리다.
     *   => java collection framework 의 List interface 는 인덱스를 통한 접근이 가능하게 하는 메서드를 구현하도록 한다.
     *   => ArrayList 는 기본적으로 메모리주소를 바탕으로 데이터를 저장.
     *
     * - 크기가 고정되어 있지않다.
     *   => ArrayList 의 크기는 요소의 삽입 및 제거에 따라 변경. 요소가 삽입되어 임계점에 도달하면 할당 메모리의 크기를 늘린다.
     *
     */

    public static void main (String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1); // 제일 끝에 데이터를 추가하는 경우 O(1)
        list.get(0); // index를 사용하므로 O(1)

        list.add(0, 2); // 데이터 삽입일 경우 O(n)
        list.remove(1); // 요소들의 재정렬을 위해 O(n)


    }

}
