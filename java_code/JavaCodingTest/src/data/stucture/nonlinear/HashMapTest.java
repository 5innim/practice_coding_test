package data.stucture.nonlinear;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {

    /**
     * Hash
     *   - 내부적으로 배열을 사용하며 저장할 데이터와 연관된 고유한 값을 index로 사용. 따라서 조회시에는 index를 이용하므로 빠르고
     *   , 삽입 또는 삭제시에 기존 data 들의 위치를 변경해야 하는 것이 아니므로 빠름.
     *   - 조회 및 삽입,삭제 O(1)
     *
     *   *HashMethod
     *      - data 에 대한 index로 사용할 고유한 값을 만들어주는 알고리즘. HashMap 에서는 Object 클래스의 hashCode() 를 HashMethod로 사용.
     *   *HashTable
     *      - key, value 구조에서 key 에 Hash Method 를 적용한 값을 index 로 사용. 즉 key 와 해시코드(index) 를 매핑하는 테이블
     *
     *   - HashMap 은 key의 동일 여부를 key 의 hashCode 값이 동일하고 equals() 의 반환값이 true 인 경우 동일하다고 판단.
     */

    public static void main(String[] args) {
        String a1 = "123";
        String a2 = "123";

        String b1 = new String("1234");
        String b2 = new String("1234");

        System.out.println(a1.equals(a2)); // 실제값이 같고 해시코드도 같다.
        System.out.println(b1.equals(b2)); // String 은 실제 값이 같에 기반하여 hashCode 를 생성하도록 오버라이딩 되어있다.
                                            // equals 는 실제값을 비교하도록 오버라이딩 되어있다.

        Map<String, String> map = new HashMap<>();
        map.put(a1, "first value");
        map.put(a2, "second value");

        System.out.println(map.get(a1)); // a1 과 a2 값은 hashCode 값이 같고, equals() 또한 true 이므로 value 가 덮어씌어졌다.

        map.put(b1, "first value");
        map.put(b2, "second value");
        System.out.println(map.get(b1)); // b1 과 b2 두 객체의 실제 주소는 다르지만 hashCode 는 같고, equals 도 true를 반환한다.

        System.out.println(map.values()); // 반환형이 Collection
        System.out.println(map.keySet()); // 반환형이 Set


    }

}
