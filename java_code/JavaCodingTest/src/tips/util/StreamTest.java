package tips.util;

public class StreamTest {

    /**
     *
     * Stream:
     * 순차적 및 병렬 집계 작업을 지원하는 요소의 시퀀스.
     *
     * 1.선언적 프로그래밍:
     * Stream은 데이터를 처리하는 방식을 선언적으로 표현합니다.(build 패턴 사용) 명령형 프로그래밍보다 더 간결하고 가독성이 좋아집니다.
     *
     * 2.내부 반복:
     * Stream은 내부적으로 반복 작업을 처리합니다. 개발자가 직접 반복문을 작성하지 않아도 됩니다. 이로 인해 코드의 복잡도가 낮아집니다.
     *
     * 3.지연 연산:
     * Stream의 연산은 지연 연산(lazy evaluation)으로 처리됩니다. 필요한 연산이 실제로 사용될 때까지 연산이 미루어지므로 성능이 향상될 수 있습니다.
     *
     * 4.파이프라이닝:
     * 여러 연산을 연결하여 파이프라인을 구성할 수 있습니다. 각 연산은 이전 연산의 결과를 기반으로 동작하며, 한 번의 순차적인 패스로 처리됩니다.
     *
     * 5.함수형 프로그래밍 지원:
     * Stream은 함수형 프로그래밍의 개념을 지원하며, 맵(Map), 필터(Filter), 리듀스(Reduce) 등 함수를 인자로 받는 다양한 연산을 제공합니다.
     *
     * 6.병렬 처리:
     * Stream은 병렬 처리를 지원합니다. parallel() 메서드를 호출하여 여러 스레드를 사용하여 데이터를 병렬로 처리할 수 있습니다.
     * 이를 통해 다중 코어를 활용하여 작업을 빠르게 처리할 수 있습니다. (여러 스레드의 작업 결과들을 합쳐서 처리하는 종단 연산자도 제공.)
     *
     * 7.최적화:
     * Stream은 내부에서 최적화된 방식으로 데이터를 처리하기 때문에 일반적으로 성능이 우수합니다.
     *
     * 8.종단 연산과 중간 연산:
     * Stream 연산은 중간 연산과 종단 연산으로 구분됩니다. 중간 연산은 스트림을 변환하거나 필터링하는 등의 작업을 수행하며, 종단 연산은 최종 결과를 반환하는 작업을 수행합니다.
     *
     * 9.불변성과 스레드 안전성:
     * Stream은 불변성을 유지하고, 스레드 안전성을 보장합니다. 이를 통해 여러 스레드에서 안전하게 사용할 수 있습니다.
     */

    public static void main(String[] args) {

    }
}
