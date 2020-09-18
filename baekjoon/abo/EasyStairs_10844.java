package baekjoon.abo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStairs_10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int resultArray[][] = new int[N+1][10];
        for(int i=1 ; i<N+1 ; i++){
            for(int j=0 ; j<10 ; j++){
                if(i == 1 && j > 0){
                    resultArray[i][j] = 1;
                }else if(i == 1 && j == 0){
                    resultArray[i][j] = 0;
                }else{
                    if(j == 0 ){
                        resultArray[i][j] = resultArray[i-1][1];
                    }else if( j > 0 && j < 9){
                        resultArray[i][j] = resultArray[i-1][j-1] + resultArray[i-1][j+1];
                    }else if( j == 9){
                        resultArray[i][j] = resultArray[i-1][8];
                    }
                }
            }
        }

        int result = 0;

        for(int i=0 ; i<10 ; i++){
            result += resultArray[N][i];
        }

        System.out.println(result % 1000000000);
    }
}
