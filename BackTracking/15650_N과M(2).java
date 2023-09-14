import java.io.*;
import java.util.*;

public class Main {
    static int num;
    static int selectNum;
    static int[] ary;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        selectNum = Integer.parseInt(st.nextToken());
        ary = new int[selectNum];
        visited = new int[num];

        DFS(0);
    }

    private static void DFS(int depth) {//원하는 깊이까지 만들어졌는지 확인해야지
        if(depth == selectNum){
            for(int value : ary)
                System.out.print(value + " ");
            System.out.println();
            return;
        }

        //차례 차례 방문한다.
        for(int i = 0; i < num; i++){
            if(visited[i] == 0){
                if(depth != 0 && ary[depth-1] > i+1)//이미 들어가있는 수가 더 크다! => 건너뛰자
                {
                    continue;
                }
                ary[depth] = i+1;//ary에 넣자
                visited[i] = 1;//방문표시하자
                DFS(depth+1);
                //방문 완료면 되돌려놓자!
                visited[i] = 0;
            }
        }
    }
}