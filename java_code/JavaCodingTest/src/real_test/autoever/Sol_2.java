package real_test.autoever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sol_2 {
    /**
     *
     * Button 누르게 되면 출력되는 값 구하기
     */

    public static ArrayList<String> output = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int h = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int h0 = Integer.parseInt(br.readLine());
        int w0 = Integer.parseInt(br.readLine());
        int h1 = Integer.parseInt(br.readLine());
        int w1 = Integer.parseInt(br.readLine());

        int wSize = 2*r + w1;
        int hSize = 2*r + h1;

        ArrayList<Button> buttons = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();

        for (int i=1; i<=12; i++) {
            int x = w0 + r + ((i-1)%3)*wSize;
            int y = h0 + r + ((i-1)/3)*hSize;

            Button b = new Button(x, y);
            final int p = i;

            if (i >= 1 && i <= 9) {
                b.setBehavior(s -> {
                    s.offerLast(p);
                });
            }

            else if (i == 10) {
                b.setBehavior(s -> {
                    s.pollLast();
                });
            }

            else if (i == 11) {
                b.setBehavior(s -> {
                    s.offerLast(0);
                });
            }

            else if (i == 12) {
                b.setBehavior(s -> {
                    String str = "";
                    for (int j : s) {
                        str = str + j;
                    }
                    if (!str.equals("")) {
                        output.add(str);
                    }
                    s.clear();
                });
            }

            buttons.add(b);
        }


        int inputNum = Integer.parseInt(br.readLine());

        for (int i=0; i<inputNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (Button button : buttons) {
                if (button.isClicked(b, a, r)) {
                    button.doFeature(stack);
                    break;
                }
            }
        }

        System.out.println(output.size());
        for (String str : output) {
            System.out.println(str);
        }

        br.close();


    }

}

class Button {
    int w;
    int h;
    ButtonBehavior behavior;

    public Button (int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void setBehavior(ButtonBehavior behavior) {
        this.behavior = behavior;
    }

    public void doFeature(Deque<Integer> stack) {
        behavior.doButton(stack);
    }

    public boolean isClicked(int x, int y, int r) {
        int xD = w - x;
        int yD = h - y;
        boolean result = false;
        if (xD * xD + yD * yD <= r * r) {
            result = true;
        }
        return result;
    }
}

interface ButtonBehavior {

    public abstract void doButton(Deque<Integer> stack);
}