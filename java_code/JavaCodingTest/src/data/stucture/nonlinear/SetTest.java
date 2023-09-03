package data.stucture.nonlinear;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    /**
     *
     * set: 중복을 허용하지 않는 자료구조, 순서가 없음.
     *   - 조회, 삽입, 삭제 모두 O(1)
     *   - 내부적으로 Object의 hashCode() 함수를 이용하여 객체의 일치여부를 확인한다.
     */

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(new Integer(1));
        System.out.println(set.contains(new Integer(1))); // true 이다. 즉 Integer 클래스 또한 String 클래스처럼 hashCode 를 overriding 하고있다.

        set.remove(new Integer(1));
        System.out.println(set);

    }

}
