import java.io.*;
import java.util.*;

public class Main {

    static int[][] visted;
    static int[][] graph;
    static int row;
    static int col;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        graph = new int[row][col];
        visted =new int[row][col];

        for(int i = 0 ; i < row; i++){
            String s = br.readLine();
            for(int j=0; j<col; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        visted[0][0] = 1;
        BFS(0,0);
        System.out.println(graph[row-1][col-1]);
    }

    private static void BFS(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!q.isEmpty()){
            int[] q_extract = q.poll();
            int x = q_extract[0];
            int y = q_extract[1];

            for(int i = 0 ; i < 4; i++){
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX >= 0 && moveX < row && moveY >= 0 && moveY < col) { // 배열 범위 체크
                    if (graph[moveX][moveY] == 1 && visted[moveX][moveY] == 0) {
                        q.add(new int[] {moveX, moveY});
                        visted[moveX][moveY] = 1;
                        graph[moveX][moveY] = graph[x][y]+1;
                    }
                }
            }
        }
    }
}