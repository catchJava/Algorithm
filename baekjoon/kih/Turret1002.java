package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Turret1002 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 터렛1 좌표와 터렛2 좌표 거리를 구한다.
            double distance = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));


            if (distance != 0.0) {
                if (r1 + r2 > distance) {
                    System.out.println(2);
                } else if (r1 + r2 == distance) {
                    System.out.println(1);
                } else if (r1 + r2 < distance) {
                    System.out.println(0);
                } else if (Math.max(r1, r2) == Math.min(r1, r2) + distance) {
                    System.out.println(1);
                } else if (Math.max(r1, r2) > Math.min(r1, r2) + distance) {
                    System.out.println(0);
                }
            } else {
                if (r1 != r2) {
                    System.out.println(0);
                } else {
                    System.out.println(-1);
                }
            }

        }

    }
}
