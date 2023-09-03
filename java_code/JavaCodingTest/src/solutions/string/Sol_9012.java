package solutions.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sol_9012 {
    @FunctionalInterface
    public interface SOut {
        void println(BufferedWriter bw, String str) throws IOException;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        SOut sOut = (br, str) -> {
            br.write(str + "\n");
            br.flush();
        };

        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i=0; i<num; i++) {
            String s = bufferedReader.readLine();
            int sum = 0;
            for (int j=0; j<s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') sum += 1;
                else if (c == ')') sum -= 1;
                else sOut.println(bufferedWriter, "it's not expected");
                if (sum < 0) break;
            }

            if (sum == 0) sOut.println(bufferedWriter, "YES");
            else sOut.println(bufferedWriter, "NO");
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
}
