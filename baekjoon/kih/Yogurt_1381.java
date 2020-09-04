package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yogurt_1381 {

    private static int n;
    private static int k;
    private static int maxWeight = Integer.MIN_VALUE;
    private static float answer = 0;
    private static int[][] yogurtInfo;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 요구르트의 갯수
        k = Integer.parseInt(st.nextToken()); // 먹고싶은 요구르트의 갯수

        yogurtInfo = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            yogurtInfo[i][0] = Integer.parseInt(st2.nextToken()); // 요구르트의 양
            yogurtInfo[i][1] = Integer.parseInt(st2.nextToken()); // 요구르트가 불량품일 확률
        }

        for (int i = 1; i <= n; i++) {

            solution(i, 0, yogurtInfo[i][0], 0);
        }

        if (Math.round(answer * 10000.0) / 10000.0 > 0.001) {
            System.out.format("%.3f", answer);
        } else {
            System.out.println("GG");
        }


    }

    private static void solution(int i, int currentCount, int currentWeight, int currentDefectiveRate) {

        if (currentCount > k || i > n) return;

        if (currentCount == k) {
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
                answer = currentDefectiveRate;
            } else {
                answer = Math.min(currentDefectiveRate, answer);
            }
        }

        // target 번째의 요구르트를 먹는다.
        solution(i + 1, currentCount + 1, currentWeight + yogurtInfo[i][0], currentDefectiveRate + yogurtInfo[i][1]);

        // target 번째의 요구르트를 먹지 않는다.
        solution(i + 1, currentCount, currentWeight, yogurtInfo[i][1]);
    }
}
