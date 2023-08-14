package tips.util;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args){
        // 난수값 반환
        Random r = new Random();

        boolean x1 = r.nextBoolean();
        int x2 = r.nextInt(); // 매우 작은수 ~ 매우 큰
        double x3 = r.nextDouble(); // between 0.0 ~ 1.0
        int x4 = r.nextInt(3); // 범위지정 (0 ~ 2) between 0 (inclusive) and the specified value (exclusive)

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
        System.out.println(x4);


    }
}
