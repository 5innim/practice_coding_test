package solutions.string;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sol_5525 {

    @FunctionalInterface
    interface StandardOut {
        void println(BufferedWriter bw, String s) throws IOException;
    }
    public static void main(String[] str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StandardOut standardOut = (bw, s) -> {
            bw.write(s + "\n");
            bw.flush();
        };

        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());
        char[] sArray = bufferedReader.readLine().toCharArray();
        int sum = 0;
        int next = 0;

        StringBuilder stringBuilder = new StringBuilder("I");
        for (int i=0; i<n; i++) stringBuilder.append("OI");
        char[] nArray = stringBuilder.toString().toCharArray();

        for (int i=0; i<m; i++) {
            if (next < nArray.length) {
                if (sArray[i] == nArray[next]) {
                    if (next == nArray.length-1) sum += 1;
                    next += 1;
                } else if (sArray[i] == 'I') next = 1;
                else next = 0;
            } else if (next >= nArray.length) {
                if (nArray[next%2] == sArray[i]) {
                    if (next%2 == 0) sum += 1;
                    next += 1;
                } else {
                    if (sArray[i] == 'I') next = 1;
                    else next = 0;
                }
            } else {
                System.out.println("it's not expected");
            }
        }


        standardOut.println(bufferedWriter, "" + sum);

        bufferedReader.close();
        bufferedWriter.close();
    }

}
