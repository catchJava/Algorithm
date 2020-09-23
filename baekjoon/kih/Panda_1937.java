package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PandaPoint {
    int x;
    int y;

    public PandaPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Panda_1937 {

    private static boolean[][] visited;
    private static int[][] forest;
    private static int[][] dp;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int n;
    private static int ANSWER = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        forest = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (dp[i][j] != 0) continue;

                dp[i][j] = 1;

                visited = new boolean[n + 1][n + 1];

                visited[i][j] = true;
                Queue<PandaPoint> q = new LinkedList<>();
                q.add(new PandaPoint(i, j));
                bfs(q);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ANSWER = Math.max(dp[i][j], ANSWER);
            }
        }

        System.out.println(ANSWER);
    }

    private static void bfs(Queue<PandaPoint> q) {

        while (!q.isEmpty()) {
            PandaPoint panda = q.poll();

            int x = panda.x;
            int y = panda.y;

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                    if (forest[x][y] < forest[nx][ny]) {
                        if (!visited[nx][ny]) {
                            if (dp[x][y] + 1 > dp[nx][ny]) {
                                dp[nx][ny] = dp[x][y] + 1;
                                visited[nx][ny] = true;
                                q.add(new PandaPoint(nx, ny));
                            }
                        }
                    }
                }
            }
        }
    }
}