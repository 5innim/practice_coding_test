package tips;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args){
        // 순서없고 중복 불가
        Set set2 = new HashSet();

        set2.add("element2");
        set2.add(1);

        // 출력방법
        System.out.println(set2);

        for (Object o : set2){
            System.out.println(o);
        } // 순서가 없음

        // 제네릭스 이용: 저장되는 데이터 타입 제한
        Set<String> set1 = new HashSet<>();
        set1.add("element1");


    }
}
