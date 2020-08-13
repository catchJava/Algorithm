package baekjoon.abo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bridge_1010 {

    public static void main(String[] args) {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int inputCount = 0;

        try {
            inputCount = Integer.parseInt(bufferedReader.readLine().trim());

            String inputArray[] = new String[inputCount];
            for(int i=0 ; i < inputCount ; i++){
                inputArray[i] = bufferedReader.readLine();
            }

            for(String input : inputArray){
                String temp[] = input.split(" ");
                System.out.println(calcurateBridgeCount(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long calcurateBridgeCount(int n, int m){

        if(m < n || m < 0 || n < 0 )
            return -1;

        if(n == 0)
            return 0;

        if(m == n)
            return 1;

        int result[][] = new int[n+1][m+1];

        for(int i=1 ; i <= n ; i++){
            for(int j=i ; j<=m ; j++){
                if(i == 1){
                    result[i][j] = j;
                }else if( i == j){
                    result[i][j] = 1;
                }else{
                    for( int z = 1 ; z <= j-1 ; z++){
                        result[i][j] += result[i-1][z];
                    }
                }
            }
        }

        return result[n][m];
    }
}
