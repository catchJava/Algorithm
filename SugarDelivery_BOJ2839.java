package Trash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SugarDelivery_BOJ2839 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());


        System.out.println(solution(n));
    }

    private static int solution(int n) {

        if (n < 3 || n == 4 || n == 7) return -1;

        int result = Integer.MAX_VALUE;


        // i : 5kg 봉지 갯수
        // j : 3kg 봉지 갯수

        for (int i = 0; i <= n / 5; i++) {
            int j = 0;

            int weight = n - (i * 5); // 5kg 봉투를 i 개 만큼 담고 남은 설탕 무게

            if (weight % 3 != 0) {
                continue;
            } else {
                j = weight / 3;
                result = Math.min(result, i + j);
            }
        }

        if (result == Integer.MAX_VALUE) return -1;

        return result;

        /*
        메모리 : 12960KB
        시간 : 80ms
         */
    }
}
