package baekjoon.abo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine(){

        try {

            return bufferedReader.readLine();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



}
