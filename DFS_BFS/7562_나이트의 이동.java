import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[][] visited;
    static int line;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int repeat = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < repeat; i++){
            st = new StringTokenizer(br.readLine());
            line = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY= Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int eX = Integer.parseInt(st.nextToken());
            int eY= Integer.parseInt(st.nextToken());

            System.out.println(BFS(sX, sY, eX, eY));
        }
    }

    private static int BFS(int sX, int sY, int eX, int eY) {
        board = new int[line][line];
        visited = new int[line][line];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sX,sY});

        int[] dx = {-2,-1,1,2,2,1,-1,-2};
        int[] dy = {1,2,2,1,-1,-2,-2,-1};

        while (!queue.isEmpty()){
            int[] q_remove = queue.poll();
            int earlyX = q_remove[0];
            int earlyY = q_remove[1];

            if(earlyX == eX && earlyY == eY){
                visited[earlyX][earlyY] = visited[earlyX][earlyY];
                break;
            }

            for(int i = 0 ; i < 8; i++){
                int moveX = earlyX + dx[i];
                int moveY = earlyY + dy[i];

                //움직였을 때 종료 조건이 만족한다면 종료!
                if(moveX == eX && moveY == eY)
                    return visited[earlyX][earlyY]+1;

                //방문할 수 있는 걸 모두 방문하지 않고 종료되서? 아닌데 bfs는 칸수에 따라서 실행되는거아냐?
                //하 아니 여기서 종료를 하면 for문만 종료되잖아 바보여 ㅠㅠㅠㅠㅠ

                if(moveX < line && moveX >= 0 && moveY < line && moveY >= 0){
                    if(visited[moveX][moveY] == 0){
                        queue.add(new int[]{moveX,moveY});
                        visited[moveX][moveY] = visited[earlyX][earlyY]+1;
                    }
                }
            }
        }

        return 0;
    }
}
