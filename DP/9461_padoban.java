import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static long[] table = new long[101];;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        table[0] = 0;
        table[1] = 1;
        table[2] = 1;
        table[3] = 1;
        for(int i = 0 ; i < n ; i++) {
            int value = Integer.parseInt(br.readLine());
            System.out.println(getTile(value));
        }
    }

    private static long getTile(int n) {
        if(table[n] == 0)
            table[n] = (getTile(n-2) + getTile(n-3));
        return table[n];
    }
}