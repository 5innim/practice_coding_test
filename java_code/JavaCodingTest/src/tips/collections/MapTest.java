package tips.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args){
        // key/value 쌍으로 관리
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<String, String>();

        // 데이터 저장
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map1.put("key3", "value3");
        map1.put("key2", "value22"); // 키 값 동일시에 덮어씌움

        // 값 출력: 반드시 key를 가지고 값을 반환
        // 1) key를 알고 있을 때
        System.out.println(map1.get("key1"));
        System.out.println(map1.get("key2"));
        System.out.println(map1.get("key3"));
        System.out.println(map1.get("key4")); // 없는 key 사용시에 null 반환

        // 2) key 값만 따로 얻고 후에 value 얻음
        Set<String> keys = map1.keySet();
        System.out.println(keys);
        for(String key : keys){
            System.out.println(key + "\t" + map1.get(key));
        }

        // 삭제: key 값 이용해서 삭제
        map1.remove("key1");
        System.out.println(map1);

    }
}
