package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Password_2011 {

    private static final int MOD = 1000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String password = br.readLine();

        System.out.println(dp(password));
    }

    private static long dp(String password) {

        int len = password.length();

        if (len == 1) {
            return 1;
        }

        long[][] d = new long[len][2];
        d[0][0] = 0; // 쪼개졌을 때 ex) 1.1
        d[0][1] = 1; // 붙어있을 때 ex) 11

        for (int i = 1; i < len; i++) {

            int pre_num = password.charAt(i - 1) - '0';
            int cur_num = password.charAt(i) - '0';

            if ((pre_num * 10) + cur_num > 26) {
                // d[i] = d[i - 1] % MOD;
            } else {
                // d[i] = (d[i - 1] + 1) % MOD;
            }
        }

        return d[len - 1][0] + d[len - 1][2];
    }
}
