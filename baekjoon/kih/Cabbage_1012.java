package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class CabbagePoint {
    int x;
    int y;

    public CabbagePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Cabbage_1012 {

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int m;
    private static int n;
    private static int k;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        int[][] cabbageField;

        while (testCase-- > 0) {

            String[] inputData = br.readLine().split(" ");

            m = Integer.parseInt(inputData[0]); // 배추밭 가로 길이
            n = Integer.parseInt(inputData[1]); // 배추밭 세로 길이
            k = Integer.parseInt(inputData[2]); // 배추가 심어져 있는 위치의 갯수

            cabbageField = new int[n][m]; // 배추밭 크기 정의

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                cabbageField[y][x] = 1; // 배추가 심어져 있는 좌표에 1을 입력한다.
            }

            Queue<CabbagePoint> queue = new LinkedList<>(); // bfs를 위한 큐
            int answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (cabbageField[i][j] == 1) {
                        cabbageField[i][j] = 0;
                        answer += 1;
                        queue.add(new CabbagePoint(i, j)); // 배추의 좌표를 큐에 삽입한다.
                        bfs(queue, cabbageField);
                    }
                }
            }

            System.out.println(answer);

            /*
             * 메모리 : 15016 KB
             *  시간 : 128ms
             */
        }
    }

    private static void bfs(Queue<CabbagePoint> queue, int[][] cabbageField) {

        while (!queue.isEmpty()) {
            CabbagePoint cabbagePoint = queue.poll();
            int x = cabbagePoint.x;
            int y = cabbagePoint.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) { // 배추밭 범위 내에서
                    if (cabbageField[nx][ny] == 0) continue; // 배추가 없다면 다른 방향으로
                    cabbageField[nx][ny] = 0;
                    queue.add(new CabbagePoint(nx, ny));
                }
            }
        }
    }
}
