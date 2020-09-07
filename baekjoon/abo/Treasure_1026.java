package baekjoon.abo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Treasure_1026 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> Blist = new ArrayList<>();
        List<Integer> Alist = new ArrayList<>();

        String temp[];
        temp = br.readLine().split(" ");
        for(int i=0 ; i<N ; i++){
            Alist.add(Integer.parseInt(temp[i]));
        }

        temp = br.readLine().split(" ");

        for(int i=0 ; i<N ; i++){
            Blist.add(Integer.parseInt(temp[i]));
        }

        Collections.sort(Blist);
        Collections.sort(Alist);
        int result = 0;
        for(int i=0 ; i<N ; i++){
            result += Blist.get(i) * Alist.get(N - i - 1);
        }

        System.out.println(result);

    }

}
