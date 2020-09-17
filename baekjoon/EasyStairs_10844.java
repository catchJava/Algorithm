package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStairs_10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int resultArray[] = new int[N + 1];

        for(int i=1 ; i<N + 1 ; i++){
            if(i == 1){
                resultArray[i] = 9;
            }else if(i == 2){
                resultArray[i] = resultArray[i-1] * 2 - 1;
            }else{
                resultArray[i] = resultArray[i-1] * 2 - 2;
            }
        }

        System.out.println(resultArray[N] % 1000000000);
    }
}
