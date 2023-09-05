import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static int[] table = new int[1000001];;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        table[0] = 0;
        table[1] = 1;
        table[2] = 2;

        System.out.println(getTile(n));
    }

    private static int getTile(int n) {
        if(table[n] == 0)
            table[n] = (getTile(n-1) + getTile(n-2)) % 15746;
        return table[n];
    }
}