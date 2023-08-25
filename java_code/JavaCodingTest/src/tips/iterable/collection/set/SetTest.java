package tips.iterable.collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        set1.add("element2");

        // Stream 이용하기
        Stream<String> stream = set1.stream();
        System.out.println(stream.collect(Collectors.toList())); // stream 에 대해 종료작업을 하였기에 아래는 실행시 에러발생.
        //System.out.println(stream.sorted().collect(Collectors.toList()));



    }
}
