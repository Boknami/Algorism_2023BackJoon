import java.io.IOException;
import java.util.Scanner;

public class Main {
    //n*n 배열 만들기
    //현재 배열 += 이 전꺼에 대각 왼쪽 골랐을 때 vs 이 전꺼에 대각 오른쪽 골랐을 때
    public static void main(String args[]) throws IOException{
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        int[][] dp = new int[num][num];

        // 배열 초기화
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = in.nextInt();
            }
        }

        //자기 바로 윗 번호 -1 이랑 자기 윗 번호 중 큰 거 고른..
        for(int i = 1 ; i < num; i++){
            for(int j = 0; j <= i; j++){
                //오른쪽 끝인 경우
                if(i == j)
                    dp[i][j] += dp[i-1][j-1];
                else if(j == 0)
                    dp[i][j] += dp[i-1][j];
                else
                    dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }

        int max = 0;
        for(int i = 0; i<num; i++){
            if (max < dp[num-1][i]) {
                max = dp[num-1][i];
            }
        }
        System.out.println(max);
    }
}