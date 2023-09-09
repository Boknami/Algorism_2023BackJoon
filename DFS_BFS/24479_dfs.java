import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static int N;

    //입력 받은 걸 어떻게 처리할거냐..
    //1.빈 2차원 배열에다?
    //2.2차원 배열인데 연결 정보에 대한 것만
    //3.
    //일단 방문여부를 체크하는 숫자가 필요하다.

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        visited = new int[N+1];
        int[][] lines = new int[M][2];
        for(int i = 0 ; i < M; i++){
            lines[i][0] = sc.nextInt();
            lines[i][1] = sc.nextInt();
        }

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {//두 배열의 첫번째 요소가 똑같다면
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });

        dfs(lines, R);
    }

    public static void dfs(int[][] E, int R) {  // V : 정점 집합, E : 간선 집합, R : 시작 정점
        visited[R] = 1;
        System.out.print(R);

        //인접한 정점들을 어떻게 뽑아낼래?
        for(int i = 0 ; i < N ; i++){
            if(E[i][0] == R && visited[E[i][1]] == 0){//연결되어있고 아직 방문하지 않았다면
                dfs(E, E[i][1]);
            }
        }
    }
}