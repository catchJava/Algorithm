package baekjoon.kih;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Pocketmon_1620 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashMap<String, String> nameMap = new HashMap<>();
        HashMap<String, String> numMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String pocketmonName = br.readLine();
            nameMap.put(pocketmonName, String.valueOf(i));
            numMap.put(String.valueOf(i), pocketmonName);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String searchData = br.readLine();

            if (isNumber(searchData)) {
                sb.append(numMap.get(searchData)).append("\n");
            } else {
                sb.append(nameMap.get(searchData)).append("\n");
            }
        }

        // 메모리 : 106924KB
        // 시간 : 748ms

        System.out.println(sb.toString());

    }

    private static boolean isNumber(String searchData) {
        try {
            Double.parseDouble(searchData);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
