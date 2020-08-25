package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Leave_14501 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] d = new int[n+1];

        for (int i = 1; i <= n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        /*
         * d[n] : n일 까지 상담했을 때 최대 수익
         * 1) : n일에 상담 했을 경우 (단 t[n] == 1)
         *      d[n] = p[n] + d[n-1]
         * 2) : n일에 상담하지 않았을 경우
         *      d[n] = d[n-1]
         */



    }
}
