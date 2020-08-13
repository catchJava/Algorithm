import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bridge_BOJ1010 {
    public static void main(String[] args) throws IOException {

        int[][] d = new int[31][31];

        // d[westSite][eastSite] = 서쪽 사이트와 동쪽 사이트를 연결할 수 있는 모든 경우의 수

        /*
         * westSite = eastSite 는 경우의 수가 1개
         * westSite = 1 은 경우의 수가 eastSite 개
         */
        for (int westSite = 1; westSite <= 30; westSite++) {
            for (int eastSite = 1; eastSite <= 30; eastSite++) {

                if (westSite == eastSite) {
                    d[westSite][eastSite] = 1;
                    continue;
                }
                if (westSite == 1) d[1][eastSite] = eastSite;
            }
        }

        for (int westSite = 2; westSite <= 30; westSite++) {
            for (int eastSite = 1; eastSite <= 30; eastSite++) {

                if (westSite == eastSite) continue;

                for (int k = eastSite - 1; k >= westSite - 1; k--) {
                    d[westSite][eastSite] += d[westSite - 1][k];
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());


        while (testCase-- > 0) {

            String[] inputData = br.readLine().split(" ");

            int n = Integer.parseInt(inputData[0]); // 서쪽 사이트
            int m = Integer.parseInt(inputData[1]); // 동쪽 사이트

            System.out.println(d[n][m]);
        }

        /*
         * 메모리 : 13884 KB
         * 시간 : 108ms
         */

    }
}
