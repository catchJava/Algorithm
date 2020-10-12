package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Password_2011 {

    private static final int MOD = 1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String password = br.readLine();

        dp(password);
    }

    private static void dp(String password) {

        int len = password.length();

        if (len == 1) {
            System.out.println(1);
            return;
        }

        long[] d = new long[len];
        d[1] = 1;

        for (int i = 1; i < len; i++) {

            int pre_num = password.charAt(i - 1) - '0';
            int cur_num = password.charAt(i) - '0';

            if ((pre_num * 10) + cur_num > 26) {
                d[i] = d[i - 1];
            } else {
                d[i] = d[i - 1] + 1;
            }
        }

        System.out.println(d[len - 1]);
    }
}
