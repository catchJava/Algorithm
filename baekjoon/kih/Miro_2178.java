package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class MiroPoint {
    int x;
    int y;
    int cnt;

    public MiroPoint(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

}

public class Miro_2178 {

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] miro;
    private static boolean[][] visit;

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");

        miro = new int[Integer.parseInt(nm[0])][Integer.parseInt(nm[1])];
        visit = new boolean[Integer.parseInt(nm[0])][Integer.parseInt(nm[1])];


        for (int i = 0; i < miro.length; i++) {

            String[] inputData = br.readLine().split("");

            for (int j = 0; j < miro[i].length; j++) {
                miro[i][j] = Integer.parseInt(inputData[j]);
            }
        }

        Queue<MiroPoint> q = new LinkedList<>();

        q.add(new MiroPoint(0, 0, 1));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            MiroPoint m = q.poll();
            int x = m.x;
            int y = m.y;
            int cnt = m.cnt;

            if (x == Integer.parseInt(nm[0]) - 1 && y == Integer.parseInt(nm[1]) - 1) {
                answer = cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < miro.length && ny >= 0 && ny < miro[0].length) {
                    if (!visit[nx][ny] && miro[nx][ny] == 1) {
                        q.add(new MiroPoint(nx, ny, cnt + 1));
                        visit[nx][ny] = true;
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
