package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StairNumber_10844 {

    private static final int VALUE = 1000000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        /*
         * d[i][j] : 자릿수가 i 이면서 숫자의 맨 앞자리가 j 인 계단수의 갯수
         * ex ) d[3][2] : 201, 210, 212, 232, 234
         */

        long[][] d = new long[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    d[i][j] = (d[i - 1][j + 1]) % VALUE;
                } else if (j == 9) {
                    d[i][j] = d[i - 1][j - 1] % VALUE;
                } else {
                    d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % VALUE;
                }
            }
        }


        long answer = 0;

        for (int i = 0; i <= 9; i++) {
            answer += d[n][i];
        }

        System.out.println(answer % VALUE);
    }
}
