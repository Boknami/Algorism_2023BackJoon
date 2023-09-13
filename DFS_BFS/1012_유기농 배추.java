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

        int TestNum = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < TestNum; i++){
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            int cabbageNum = Integer.parseInt(st.nextToken());
            int cnt = 0;

            visted =new int[row][col];
            graph = new int[row][col];

            for(int j = 0 ; j < cabbageNum; j++){
                st = new StringTokenizer(br.readLine());
                int s =  Integer.parseInt(st.nextToken());
                int e =  Integer.parseInt(st.nextToken());

                graph[s][e] = 1;
            }

            for(int k = 0 ; k < row; k++){
                for(int m = 0 ; m < col; m++){
                    int value = graph[k][m];

                    if(value == 1 && visted[k][m] == 0){
                        BFS(k,m);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void BFS(int k, int m) {
        List<List<Integer>> q = new ArrayList<>();
        visted[k][m] = 1;
        List<Integer> tempList = new ArrayList<>();
        tempList.add(k);
        tempList.add(m);
        q.add(tempList);

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!q.isEmpty()){
            List<Integer> q_extract = q.remove(0);
            int x = q_extract.get(0);
            int y = q_extract.get(1);

            for(int i = 0 ; i < 4; i++){
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX >= 0 && moveX < row && moveY >= 0 && moveY < col) { // 배열 범위 체크
                    if (graph[moveX][moveY] == 1 && visted[moveX][moveY] == 0) {
                        List<Integer> temp2 = new ArrayList<>();
                        temp2.add(moveX);
                        temp2.add(moveY);
                        q.add(temp2);
                        visted[moveX][moveY] = 1;
                    }
                }
            }
        }
    }
}