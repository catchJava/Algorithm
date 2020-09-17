package baekjoon.abo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    int n;
    int m;
    int length;

    public Point(int n, int m, int length){
        this.n = n;
        this.m = m;
        this.length = length;
    }
}

public class miro_2178 {
    public static final int moveX[] = {0, 1, -1, 0};
    public static final int moveY[] = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {

        int N,M;
        int miro[][];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        miro = new int[N][M];

        for(int i=0 ; i<N ; i++){
            String temp = br.readLine();
            for(int j=0 ; j<M ; j++){
                miro[i][j] = temp.charAt(j) - '0';
            }
        }

        System.out.println(BFS(miro, N, M));
    }

    public static int BFS(int miro[][], int N, int M){
        boolean visit[][] = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();

        Point start = new Point(0,0, 1);

        q.add(start);
        visit[start.n][start.m] = true;

        while (!q.isEmpty()){
            Point currentP = q.poll();

            if(currentP.n == N-1 && currentP.m == M-1){
                return currentP.length;
            }

            for(int i=0 ; i<moveX.length; i++){
                int nextN = currentP.n + moveX[i];
                int nextM = currentP.m + moveY[i];

                if(isNext(nextN, nextM, visit, miro, N, M)){
                    q.add(new Point(nextN, nextM, currentP.length + 1));
                    visit[nextN][nextM] = true;
                }
            }

        }

        return 0;
    }

    private static boolean isNext(int nextN, int nextM, boolean[][] visit, int[][] miro, int N, int M) {

        if(nextN >= N)
            return false;

        if(nextM >= M)
            return false;

        if(nextN < 0)
            return false;

        if(nextM < 0)
            return false;

        if(miro[nextN][nextM] == 0)
            return false;

        if(visit[nextN][nextM] == true)
            return false;

        return true;
    }
}
