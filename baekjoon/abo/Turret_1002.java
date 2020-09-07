package baekjoon.abo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Turret_1002 {

    private static final int inputCol = 6;

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = 0;
        int inputData[][];
        try {
            testCaseCount = Integer.parseInt(br.readLine().trim());
            inputData = new int[testCaseCount][inputCol];

            for(int i=0 ; i<testCaseCount ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0 ; j<inputCol ; j++){
                    inputData[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Turret_1002.calculate(inputData);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void calculate(int inputData[][]){

        for(int i=0 ; i<inputData.length ; i++){
            int result = calculateTestCase(inputData[i][0], inputData[i][1], inputData[i][2], inputData[i][3], inputData[i][4], inputData[i][5]);
            System.out.println(result);
        }
    }

    public static int calculateTestCase(int x1, int y1, int r1, int x2, int y2, int r2){

        //서로간의 좌표가 같은 경우 거리값이 같으면 무제한으로 겹치지만 그렇지 않은 경우는 겹치지 않는다.
        if(x1 == x2 && y1 == y2){
            if(r1 == r2){
                return -1;
            }else{
                return 0;
            }
        }else{
            //서로간의 좌표가 다른 경우
            //서로간의 거리가 류재명 거리에 따라 결과가 달라짐
            double diffx = Math.abs(x1 - x2);
            double diffy = Math.abs(y1 - y2);
            double diffxy = Math.sqrt(diffx * diffx + diffy * diffy);
            double r1r2 = r1 + r2;

            if(diffxy > r1r2){
                return 0;
            }else if(diffxy == r1r2){
                return 1;
            }else{
                if(Math.max(r1, r2) == Math.min(r1, r2) + diffxy)
                    return 1;

                return 2;
            }
        }
    }
}
