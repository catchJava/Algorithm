package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StairNumber_10844 {

    private static final int VALUE = 1000000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] d = new int[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 1) {
                    d[i][j] = (d[i - 1][j + 1] + 1) % VALUE;
                } else if (j == 9) {
                    d[i][j] = d[i - 1][j - 1] % VALUE;
                } else {
                    d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % VALUE;
                }
            }
        }


        int answer = 0;

        for (int i = 0; i <= 9; i++) {
            answer += d[n][i] % VALUE;
        }

        System.out.println(answer);
    }
}
