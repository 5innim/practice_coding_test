package tests;

public class LambdaTest {
    public static void main(String[] arrays) {
        A aa = s -> {
            System.out.println(A.a);
        };
    }

}

class B implements A {
    @Override
    public void aPrint(String s) {
        System.out.println(tests.A.a);
    }
}

interface A {
    int a = 1;
    void aPrint(String s);
}

interface C {
    int a = 2;
    void cPrint(String s);
}