package tips.wrapper;

import java.util.ArrayList;

public class WrapperTest {
    public static void main(String[] args) {
        final Integer sum = 0; // auto boxing

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); // auto boxing
        list.add(2);
        list.add(3);


        //list.forEach(integer -> sum += integer);
        // lambda 내부에서 사용할 수 있는 외부변수는 final 선언이어야 한다.
        // final 선언된 변수는 stack 영역의 값이 한번 선언 이후 변경되어서는 안된다.
        // 그러나 Integer 는 immutable 로 한번 선언된 heap 메모리의 데이터는 변경 불가능하므로
        // 연산자에 의한 연산이후 값이 변경되게 된다면 내부적으로 새로운 객체를 생성해 stack 메모리의 값이 변경된다.


    }

}
