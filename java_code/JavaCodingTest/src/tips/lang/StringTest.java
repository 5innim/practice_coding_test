package tips.lang;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args){
        // String 클래스

        // 1. 리터럴 이용
        String s1 = "hello";
        String s2 = "hello";

        // 2. new 이용
        String x1 = new String("hello");
        String x2 = new String("hello");

        System.out.println(s1);
        System.out.println(x1);

        //주소값 비교
        System.out.println(s1 == s2); // true : 리터럴로 생성시에 기존의 같은 값을 가지고 있는 객체가 있으면 주소값을 공유한다.
        System.out.println(x1 == x2); // false : new 사용시 새로운 객체 생성

        //실제값 비교 .equals 사용
        System.out.println(s1.equals(s2));
        System.out.println(x1.equals(x2));

        //String  클래스
        String s = "sequeNCe";

        System.out.println("특정위치의 문자반환:" + s.charAt(0));
        System.out.println("문자열 길이:" + s.length());
        System.out.println("문자열 연결:" + s.concat("!!!"));
        System.out.println("부분열:" + s.substring(1)); // 1 부터 끝까지
        System.out.println("부분열:" + s.substring(1, 4)); // 1~3 까지
        System.out.println("대문자:" + s.toUpperCase());
        System.out.println("소문자:" + s.toLowerCase());

        System.out.println("특정문자의 위치반환:" + s.indexOf('q'));
        System.out.println("특정문자의 위치반환:" + s.indexOf('X')); //일치하는문자가 없으면 -1
        System.out.println("특정문자열 포함여부:" + s.contains("se"));
        System.out.println("특정문자열 치환:" + s.replace("se","SE"));

        String s3 = "    hello    ";
        System.out.println("공백제거:" +  s3.trim());

        String s4 = "aa,bb,cc";
        String [] array = s4.split(",");
        System.out.println(Arrays.toString(array));

        // 문자열이 아닌 값을 문자열로 변환
        String xxx = String.valueOf(123);
        String xxx2 = String.valueOf(3.15F);
        String xxx3 = String.valueOf(true);

        System.out.println(xxx);
        System.out.println(xxx2);
        System.out.println(xxx3);

        System.out.println("원본:" + s); // 원본 문자열은 변경 안됨. (StringBuilder 와의 차이)
    }
}
