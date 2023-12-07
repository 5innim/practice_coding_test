package solutions.programmers.kakao.blind2023;

public class Sol_2 {

    /**
     * 4	5	[1, 0, 3, 1, 2]     	[0, 3, 0, 4, 0]     	16
     * 2	7	[1, 0, 2, 0, 1, 0, 2]	[0, 2, 0, 1, 0, 2, 0]	30
     *
     */


    static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int mostFarD = n;
        int mostFarP = n;

        while (mostFarD > 0 || mostFarP > 0) {
            int distance = 0;

            int leftBox = cap;
            boolean dChecked = false;
            for (int i=mostFarD-1; i>=0; i--) {
                if (deliveries[i] > 0) {
                    if (!dChecked) {
                        dChecked = true;
                        distance = Math.max(distance, i + 1);
                    }

                    if (deliveries[i] >= leftBox) {
                        deliveries[i] -= leftBox;
                        mostFarD = i + 1;
                        break;
                    } else if (deliveries[i] < leftBox) {
                        leftBox -= deliveries[i];
                        deliveries[i] = 0;
                    }
                } else if (i == 0) {
                    mostFarD = 0;
                }
            }

            int ableBox = cap;
            boolean pChecked = false;
            for (int i=mostFarP-1; i>=0; i--) {
                if (pickups[i] > 0) {
                    if (!pChecked) {
                        pChecked = true;
                        distance = Math.max(distance, i + 1);
                    }

                    if (pickups[i] >= ableBox) {
                        pickups[i] -= ableBox;
                        mostFarP = i + 1;
                        break;
                    } else if (pickups[i] < ableBox) {
                        ableBox -= pickups[i];
                        pickups[i] = 0;
                    }
                } else if (i == 0) {
                    mostFarP = 0;
                }
            }

            answer += 2 * distance;
        }



        return answer;
    }

}
