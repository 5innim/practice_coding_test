package real_test.skt;

public class Solution_2 {
    /**
     *
     * 메시지 전송 시에 A에서 B로 가능 시간에는 A에서 서버로 가는시간(network), 서버에서 처리시간, 서버에서 B로 가는시간(network)
     * 이때 서버에서 장애가 발생할 수 있다.
     * 장애 유형에는 전송실패와 전송지연이 있다. 전송실패의 경우 서버에서 처리중인 작업은 실패된다. 전송지연의 경우 남은 처리시간이 2배가 된다.
     * 서버도착시간에 장애가 발생한 경우 영향받음.
     * 서버에서 작업을 완료하고 전송하는 시간에 장애 발생시 영향을 받지않음.
     *
     * 입력값:
     *   n: 네트워크 시간
     *   m: 서버처리 시간
     *   sends: 사용자가 메세지를 보낸시간
     *   errors: 서버 장애의 유형과 장애 발생시간. 1: 전송지연, 2: 전송실패
     *
     * 출력값:
     *   각 send에 대한 예상 도착시간, 실패시 -1
     *
     *
     */


    int[] solution(int n, int m, int[] sends, int[][] errors) {
        int[] answer = new int[sends.length];
        int[] errorArray = new int[1000001];

        for (int[] error : errors) {
            errorArray[error[1]] = error[0];
        }

        int cnt = 0;

        for (int send : sends) {
            int startJob = send + n;
            int expectedEnd = startJob + m;
            boolean isFailed = false;
            while (startJob < expectedEnd) {
                if (errorArray[startJob] == 1) {
                    expectedEnd += expectedEnd - startJob;
                    startJob += 1;
                    continue;
                } else if (errorArray[startJob] == 2) {
                    isFailed = true;
                    break;
                }
                startJob += 1;
            }
            answer[cnt] = (isFailed)?-1:expectedEnd;
            cnt++;
        }

        return answer;
    }

}
