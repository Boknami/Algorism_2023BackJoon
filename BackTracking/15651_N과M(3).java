import java.io.*;
import java.util.*;

public class Main {
    static int num;
    static int selectNum;
    static int[] ary;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        selectNum = Integer.parseInt(st.nextToken());
        ary = new int[selectNum];

        DFS(0);
        System.out.print(sb);
    }

    private static void DFS(int depth) {//원하는 깊이까지 만들어졌는지 확인해야지
        if(depth == selectNum){
            for (int i = 0; i < selectNum; i++) {
                sb.append(ary[i] + " ");
            }
            sb.append('\n');
            return;
        }

        //차례 차례 방문한다.
        for(int i = 0; i < num; i++){
            ary[depth] = i+1;//ary에 넣자
            DFS(depth+1);
        }
    }
}