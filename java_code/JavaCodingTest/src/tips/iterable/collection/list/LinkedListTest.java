package tips.iterable.collection.list;

import java.util.LinkedList;

public class LinkedListTest {

    public static void main (String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1); // 맨뒤의 데이터 추가이므로 O(1)
        list.add(2);
        list.add(3);

        list.get(1); // index 개념이 없어 파라미터로 주어진 index에 매칭되는 메모리 주소를 처음부터 순회하며 찾아야 하므로 O(n)

        list.add(0, 3); // 맨앞에 데이터를 추가하는 경우 O(1)
        list.add(2, 2); // 추가할 위치를 찾아야하므로 O(n)
        list.remove(3); // 삭제할 위치를 찾아야하므로 O(n)


    }


}