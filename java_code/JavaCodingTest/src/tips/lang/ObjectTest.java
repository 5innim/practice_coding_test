package tips.lang;

// java.lang 패키지는 자바프로그래밍에 가장 기본이 되는 클래스들을 포함하고 있다. 그렇기 때문에 java.lang패키지의 클래스들은
// import 문 없이도 사용할 수 있게 되어있다.
// String 이나 System 클래스가 여기에 해당 됨.

class C implements Cloneable {
    public int cInteger = 1;
    public String cString = "example";
    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}
        return obj;
    }
}
public class ObjectTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Object o1 = new Object();
        Object o2 = new Object();

        // equals() 는 내부적으로 == 연선자를 사용하여 동일성을 확인한다.
        o1.equals(o2);

        // hashCode() 는 해싱기법에 사용되는 '해시함수'를 구현한 것이다.
        // 해싱은 데이터관리기법 중의 하나인데 다량의 데이터를 저장하고 검색하는 데 유용하다. 해시함수는 찾고자하는 값을 입력하면, 그 값이 저장된 위치를 알려주는 해시코드를 반환한다.
        // hashCode 메서드는 객체의 주소값으로 해시코드를 만들어 반환하기 때문에 32bit JVM에서는 서로 다른 두 객체는 결코 같은 해시코드를 가질 수 없다.
        // 64bit JVM에서는 8 byte 주소값으로 해시코드(4byte)를 만들기 때문에 해시코드가 중복될 수 있다. => 아마 8 byte 모든 주소에 대응하는 각기 다른 해시코드(4 byte)를
        // 생성할 수 없기 때문인듯
        o1.hashCode();
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(s1.toString() == s2.toString()); // 내부적으로 리터럴로 선언되어 같은 주소를 가리키는 듯

        // clone() 이 메서드는 자신을 복제하여 새로운 인스턴스를 생성한다.
        // Object클래스에 정의된 clone()은 단순히 인스턴스 멤버들의 값(stack 영역)만 복사하기 때문에 참조타입의 인스턴스 필드가 있는 클래스는 완전한 복제가 이루어지지 않는다.
        // 예를 들어 배열의 경우, 복제된 인스턴스도 같은 배열의 주소를 갖기 때문에 복제된 인스턴스의 작업이 원래의 인스턴스에 영향을 미치게 된다.

        C c2 = new C();
        C d = (C) c2.clone(); // Object 클래스의 clone 함수는 protected. 따라서 자식 클래스에서 Override 해야 객체를 통해 사용할 수 있다.
                                // 하지만 Override 했다고 하더라도 upcasting 하는 경우 부모 메서드의 접근지정자를 따라간다.

        System.out.println("hashcode: " + c2.hashCode() + ",cInteger: " + c2.cInteger + ",cStringHash" + c2.cString.hashCode());
        System.out.println("hashcode: " + d.hashCode() + ",cInteger: " + d.cInteger + ",cStringHash" + d.cString.hashCode());

        // 출력값을 보면 c2, d 의 hashcode 값은 다르다. cInteger의 값과 cString 의 값은 같다. 이때 복사된 내용은 내부 필드들의 stack 영역을 참조하기 때문에
        // cString 의 hashcode 가 동일한 것을 확인할 수 있다.


        class A {
            @Override
            public int hashCode() {
                return 0;
            }
        }

        Object a = new A();
        int h = a.hashCode();
        System.out.println(h);


    }
}
