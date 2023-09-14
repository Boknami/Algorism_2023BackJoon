import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
    }

    private static void dfs(int n, int m, int depth) {
        if(depth == m){
            for(int value : arr)
                System.out.print(value + " ");
            System.out.println();
            return;
        }

        for(int i = 0 ; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(n,m,depth+1);
                visit[i] = false;
            }
        }
    }
}