package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Point {

  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}


public class Beer_9205 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testCase = Integer.parseInt(br.readLine());

    while (testCase-- > 0) {

      int n = Integer.parseInt(br.readLine());

      // 0 번 노드는 집 위치
      // 1 ~ 마지막 -1 번 노드는 편의점 위치
      // 마지막 노드는 페스티벌 위치

      ArrayList<Point> node = new ArrayList<>();

      for (int i = 0; i < n + 2; i++) {
        String[] point = br.readLine().split(" ");
        node.add(new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
      }

      String answer = "sad";

      // 각 노드별 방문 위치 체크
      boolean[] visitNode = new boolean[node.size()];

      // 집부터 출발
      Queue<Point> q = new LinkedList<>();
      q.add(node.get(0));
      visitNode[0] = true;

      while (!q.isEmpty()) {
        Point p = q.poll();

        int x = p.x;
        int y = p.y;

        // 꺼내온 좌표가 페스티벌 위치면
        if (p.equals(node.get(n + 1))) {
          answer = "happy";
          break;
        }

        // 다음노드 탐색
        for (int i = 1; i < node.size(); i++) {

          // 방문한 노드면 패스
          if (visitNode[i]) {
            continue;
          }

          int nx = node.get(i).x;
          int ny = node.get(i).y;

          int dist = Math.abs(x - nx) + Math.abs(y - ny);

          // 맥주 20개로 거리 1000까지 갈 수 있으니까?
          if (dist <= 1000) {

            visitNode[i] = true;
            q.add(node.get(i));
          }

        }
      }

      System.out.println(answer);

    }


  }

}
