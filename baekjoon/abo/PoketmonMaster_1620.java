package baekjoon.abo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PoketmonMaster_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");


        int poketmonNum = Integer.parseInt(input[0]);
        int questionNum = Integer.parseInt(input[1]);
        Map<String, Integer> poketmonDict = new HashMap<>();
        String poketmonArray[] = new String[poketmonNum+1];
        String question[] = new String[questionNum];
        for(int i=1 ; i<poketmonNum+1 ; i++){
            poketmonArray[i] = br.readLine().trim();
            poketmonDict.put(poketmonArray[i], i);
        }

        for(int i=0; i<questionNum; i++){
            question[i] = br.readLine().trim();
        }

        for(int i=0 ; i<questionNum; i++){
            int index = isNumber(question[i]);
            if(index != -1){
                System.out.println(poketmonArray[index]);
            }else{
                System.out.println(poketmonDict.get(question[i]));
            }
        }
    }

    public static int isNumber(String input){

        for(int i=0 ; i<input.length(); i++){
            if(input.charAt(i) < '0' || input.charAt(i) > '9')
                return -1;
        }

        return Integer.parseInt(input);
    }

}
