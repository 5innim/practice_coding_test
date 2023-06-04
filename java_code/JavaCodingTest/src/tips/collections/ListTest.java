package tips.collections;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args){
        // List 순서있고 중복가능
        // List 는 interface
        List<String> list1 = new ArrayList<>();
        List list3 = new ArrayList(); // <> 없이 주면 Object로 생성되는 듯

        list1.add("hi");
        list1.add("hi2");
        list1.add("hi3");
        list1.add("hi4");


        list3.add(1);
        list3.add("hihi");
        System.out.println(list3);

        // 삽입
        list1.add(1, "hi5");

        // 수정
        list1.set(1, "hi6");

        // 삭제
        list1.remove(0);
        list1.remove("hi6");

        // 값 출력
        System.out.println(list1);
        System.out.println(list1.get(0));

        for (String str : list1){
            System.out.println(str);
        }

        List<Integer> list2 = new ArrayList<>();

        list2.add(1);
        list2.add(2);
        list2.add(3);

        list2.remove(new Integer(1));
        System.out.println(list2);

        list2.remove(0);
        System.out.println(list2);



    }
}
