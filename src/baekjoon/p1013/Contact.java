package baekjoon.p1013;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Contact {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] strings = new String[N];

        for (int i = 0; i < N; ++i)
            strings[i] = reader.readLine();

        String radioWave = "^(100+1+|01)+$";
        Pattern pattern = Pattern.compile(radioWave);
        Matcher matcher;

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            matcher = pattern.matcher(strings[i]);
            if (matcher.find())
                answer.append("YES");
            else
                answer.append("NO");
            answer.append("\n");
        }

        System.out.print(answer);
        reader.close();
    }
}
