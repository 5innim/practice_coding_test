package solutions.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol_2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Lesson> list = new ArrayList<>();

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        final Integer[] result = {0};

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Lesson(p, d));
        }

        Collections.sort(list);

        for (Lesson l : list) {
            if (heap.size() < l.d) {
                heap.offer(l.p);
            } else if (heap.size() >= l.d && heap.peek() < l.p) {
                heap.poll();
                heap.offer(l.p);
            }
        }

        heap.forEach(integer -> result[0] += integer); // 연산자에 의해 오토 언박싱이 되어 ! final 에 대해서 다시 찾아보기 immutable 과 연관이 있을듯


        System.out.println(result[0]);
        br.close();
    }

    static class Lesson implements Comparable {
        public int p;
        public int d;

        public Lesson(int p, int d) {
            this.p = p;
            this.d = d;
        }
        @Override
        public int compareTo(Object o) {
            Lesson c = (Lesson) o;
            if (this.d < c.d) {
                return -1;
            } else if (this.d == c.d) {
                if (this.p > c.p) {
                    return -1;
                } else if (this.p == c.p) {
                    return 0;
                } else if (this.p < c.p) {
                    return 1;
                }
            } else if (this.d > c.d) {
                return 1;
            }

            return 0;
        }
    }



}
