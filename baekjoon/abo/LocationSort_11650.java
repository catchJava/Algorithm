package baekjoon.abo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class LocationSort_11650 {

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void locationSort(String input[],int lowest, int highest){
        HashMap<Integer, LinkedList<Point>> locationMap = new HashMap<>();

        for(String str : input){

            String temp[] = str.trim().split(" ");

            Point point = new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            LinkedList<Point> linkedList = locationMap.get(point.x);
            if( linkedList == null){
                linkedList = new LinkedList();
                linkedList.add(point);
                locationMap.put(point.x, linkedList);
            }else{
                boolean check = true;
                for(int j=0 ; j<linkedList.size() ; j++){
                    if(linkedList.get(j).y > point.y){
                        linkedList.add(j, point);
                        check = false;
                        break;
                    }
                }

                if(check)
                    linkedList.addLast(point);

            }
        }



        for(int i = lowest ; i <= highest ; i++){
            LinkedList<Point> linkedList = locationMap.get(i);
            if(linkedList != null){
                for(Point point : linkedList){
                    System.out.println(point.x + " " + point.y);
                }
            }
        }
    }

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lowest = -100000;
        int highest = 100000;

        int input = 0;
        String temp[] = null;
        try {
            input = Integer.parseInt(bufferedReader.readLine());
            temp = new String[input];

            for(int i=0 ; i<input ; i++){
                temp[i] = bufferedReader.readLine().trim();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        LocationSort_11650.locationSort(temp, lowest, highest);
    }
}
