package baekjoon.abo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_BFS_1026 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        boolean lineArray[][] = new boolean[N+1][N+1];
        String temp[];
        for(int i=0 ; i<M ; i++){
            temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);

            lineArray[x][y] = true;
            lineArray[y][x] = true;
        }

        System.out.println(DFS(N, V, lineArray));
        System.out.println(BFS(N, V, lineArray));
    }

    public static String BFS(int N, int V, boolean lineArray[][]){
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[N+1];
        String result = "";

        //초기값 세팅
        q.add(V);
        visit[V] = true;
        while (!q.isEmpty()){
            int current = q.poll();

            result += current + " ";

            List<Integer> list = new ArrayList<>();
            for(int i=1 ; i<N+1 ; i++){
                if(lineArray[current][i] && !visit[i] && current != i){
                    list.add(i);
                    visit[i] = true;
                }
            }
            Collections.sort(list);
            for(int next : list){
                q.add(next);
            }
        }

        return result.trim();
    }

    public static String DFS(int N, int V, boolean lineArray[][]){
        Stack<Integer> s = new Stack<>();
        boolean visit[] = new boolean[N+1];
        String result = "";

        s.add(V);

        while (!s.isEmpty()){
            int current = s.pop();
            if(visit[current]){
                continue;
            }

            visit[current] = true;

            result += current + " ";

            List<Integer> list = new ArrayList<>();
            for(int i=1 ; i<N+1 ; i++){
                if(lineArray[current][i] && !visit[i] && current != i){
                    list.add(i);

                }
            }

            Collections.sort(list, Collections.reverseOrder());
            for(int next : list){
                s.push(next);
            }
        }

        return result.trim();

    }
}
