import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] ary;
    static int[] signs = new int[4];
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ary = new int[n];

        //배열 입력받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        //부호 입력받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4; i++)
            signs[i] = Integer.parseInt(st.nextToken());

        DFS(0, ary[0]);

        System.out.println(maxNum);
        System.out.println(minNum);

    }

    private static void DFS(int depth, int value) {
        //종료 조건
        if(depth == n-1){//원하는 길이만큼 연산자가 만들어짐
            maxNum = Math.max(value,maxNum);
            minNum = Math.min(value,minNum);
            return;
        }

        //if랑, else if로 구성을 처음에 했는데 오류 엄청났음
        //그 이유에 대해서 이해를 해야할 것 같다.
        //심지어 거기에 더해 for문까지 쳐 넣어놈..하..
        if(signs[0] > 0){
            signs[0]--;
            DFS(depth+1, value + ary[depth+1]);
            signs[0]++;
        }
        if (signs[1] > 0) {
            signs[1]--;
            DFS(depth+1, value - ary[depth+1]);
            signs[1]++;
        }
        if (signs[2] > 0) {
            signs[2]--;
            DFS(depth+1, value * ary[depth+1]);
            signs[2]++;
        }
        if (signs[3] > 0) {
            signs[3]--;
            DFS(depth+1, value / ary[depth+1]);
            signs[3]++;
        }
    }
}
