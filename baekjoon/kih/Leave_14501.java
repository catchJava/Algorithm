package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Leave_14501 {

    public static int n;
    public static int[] t;
    public static int[] p;
    public static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        t = new int[n + 1];
        p = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        /*
         * d[n] : n일 까지 상담했을 때 최대 수익
         * case 1) : n일에 상담 했을 경우
         *          d[n] = p[n] + d[n-1]
         * case 2) : n일에 상담하지 않았을 경우
         *          d[n] = d[n-1]
         */

        solution(1, 0);

        System.out.println(answer);
    }

    private static void solution(int day, int sum) {

        if (day > n + 1) return;
        if (day == n + 1)  answer = Math.max(answer, sum);

        // day 날짜에 상담 했을 경우
        solution(day + t[day], sum + p[day]);

        // day 날짜에 상담하지 않았을 경우
        solution(day + 1, sum);
    }
}
