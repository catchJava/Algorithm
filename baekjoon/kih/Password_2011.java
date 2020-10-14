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

        if (len == 1 && Integer.parseInt(password) != 0) { // 0이 아닌 한자리 암호라면
            return 1;
        } else if (password.charAt(0) - '0' == 0) { // 암호의 시작이 0이라면
            return 0;
        }

        long[] d = new long[len + 1];
        d[0] = 1;
        d[1] = 1;

        for (int i = 2; i <= len; i++) {

            int pre_num = password.charAt(i - 2) - '0';
            int cur_num = password.charAt(i - 1) - '0';

            if (cur_num != 0) {
                d[i] += d[i - 1] % MOD;
            }

            int num = (pre_num * 10) + cur_num;

            if (num >= 10 && num <= 26) {
                d[i] += d[i - 2] % MOD;
            } else if (num > 26 && cur_num == 0) {
                return 0;
            } else if (num == 0) {
                return 0;
            }

            d[i] %= MOD;
        }

        return d[len];
    }
}
