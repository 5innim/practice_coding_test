package tips.lang;

public class StringBuilderTest {
    public static void main(String[] args){
        // StringBuilder
        StringBuilder s =  new StringBuilder("sequence");

        // 가공
        // 가장 많이 사용하는 함수는 append
        s.append(" AAA");
        s.append(" BBB");
        s.append(" CCC");
        s.insert(0, "Hello");
        s.delete(0, 5); // 0~4 까지 삭

        System.out.println(s);
        System.out.println(s.reverse());
        String x = s.toString();
        System.out.println(x);
    }
}
