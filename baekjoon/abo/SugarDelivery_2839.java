package baekjoon.abo;

import java.util.Scanner;

public class SugarDelivery_2839 {

    public static int minResult(int N){
        int three = 0 , five = 0;
        int temp;

        for(int i=N/5 ; i >= 0 ; i--){
            temp = N - i * 5;
            if(temp % 3 == 0){
                five = i;
                three = temp / 3;
                break;
            }

            if(i == 0)
                return -1;
        }

        return five + three;
    }

    public static void main(String[] args) {

        //N킬로그램 배달
        //봉지는 3, 5키로
        //최대한 적은 봉지

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int N = Integer.parseInt(input);

        System.out.println("결과 : " + SugarDelivery_2839.minResult(N));

    }
}
