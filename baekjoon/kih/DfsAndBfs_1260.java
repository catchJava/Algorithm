package baekjoon.kih;

import javax.management.QueryEval;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsAndBfs_1260 {

    private static int n;
    private static int m;
    private static int v;
    private static int[][] map;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputData = br.readLine().split(" ");

        n = Integer.parseInt(inputData[0]);
        m = Integer.parseInt(inputData[1]);
        v = Integer.parseInt(inputData[2]);

        map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }

        visited = new boolean[n + 1];
        dfs(v);

        System.out.println();

        visited = new boolean[n + 1];
        bfs(v);

        /*
         * 메모리 : 23376 KB
         * 시간 : 280 ms
         */
    }

    private static void dfs(int start) {

        if (visited[start]) return;

        System.out.print(start + " ");

        for (int i = 1; i < map.length; i++) {
            if (map[start][i] == 1 && map[i][start] == 1) {
                visited[start] = true;
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int point = q.poll();
            System.out.print(point + " ");

            for (int i = 1; i < map.length; i++) {
                if (map[point][i] == 1 && map[i][point] == 1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
    }
}
