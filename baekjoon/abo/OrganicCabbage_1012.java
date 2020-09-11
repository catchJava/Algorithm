package baekjoon.abo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Cabbage{
    int x;
    int y;

    public Cabbage(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class OrganicCabbage_1012 {

    public static final int moveX[] = {0, 1, -1, 0};
    public static final int moveY[] = {1, 0, 0, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        String result = "";
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean cabbageArray[][] = new boolean[N][M];
            for(int j=0; j<K; j++){
                String temp[] = br.readLine().trim().split(" ");
                int x = Integer.parseInt(temp[0]);
                int y = Integer.parseInt(temp[1]);

                cabbageArray[y][x] = true;
            }
            result += calcuratorMinWorm(M, N, K, cabbageArray) + "\n";
        }

        System.out.println(result.trim());

    }

    private static int calcuratorMinWorm(int M, int N, int K, boolean[][] cabbageArray) {

        boolean visit[][] = new boolean[N][M];
        int warm = 0;

        for(int i=0; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if( cabbageArray[i][j] && !visit[i][j]){

                    Stack<Cabbage> s = new Stack<>();
                    s.push(new Cabbage(j, i));
                    warm++;

                    while(!s.isEmpty()){
                        Cabbage c = s.pop();
                        visit[c.y][c.x] = true;

                        for(int k=0; k<moveX.length ; k++){
                            int nextX = c.x + moveX[k];
                            int nextY = c.y + moveY[k];

                            if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && cabbageArray[nextY][nextX] && !visit[nextY][nextX]){
                                s.push(new Cabbage(nextX, nextY));
                            }
                        }
                    }
                }
            }
        }

        return warm;
    }
}
