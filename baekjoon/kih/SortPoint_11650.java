package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Point11650 {

  int x;
  int y;

  Point11650(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return new StringBuilder().append(x + " ").append(y).toString();
  }
}

public class SortPoint_11650 {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());

    List<Point11650> pointList = new LinkedList<>();

    while (num-- > 0) {

      String[] inputData = br.readLine().split(" ");

      pointList.add(
          new Point11650(Integer.parseInt(inputData[0]), Integer.parseInt(inputData[1]))
      );
    }

    Collections.sort(pointList, new Comparator<Point11650>() {
      @Override
      public int compare(Point11650 p1, Point11650 p2) {
        if (p1.x > p2.x) {
          return 1;
        } else if (p1.x == p2.x) {
          if (p1.y > p2.y) {
            return 1;
          } else {
            return -1;
          }
        } else {
          return -1;
        }
      }
    });

    for (Point11650 item : pointList) {
      System.out.println(item.toString());
    }
  }
}
