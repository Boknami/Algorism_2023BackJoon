import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> Danji = new ArrayList<>();
    static List<List<Integer>> queue = new ArrayList<>();
    static int[][] visited;
    static int[][] graph;
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++){
            String value = br.readLine();

            for(int j=0; j < N; j++) {
                graph[i][j] = Character.getNumericValue(value.charAt(j));
            }
        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                //값이 1이면서 아직 방문하지 않은 값을 보내자!
                if(graph[i][j] == 1 && visited[i][j] == 0)
                    Danji.add(bfs(i,j));
            }
        }

        System.out.println(Danji.size());
        Collections.sort(Danji);
        for(int i = 0 ; i < Danji.size(); i++){
            System.out.println(Danji.get(i));
        }
    }

    static int[] moveX = {0,0,1,-1};
    static int[] moveY = {1,-1,0,0};
    private static int bfs(int i, int j) {
        visited[i][j] = 1;
        int danji = 1;
        //큐에 [i,j] 넣고
        List<Integer> tempIdx = new ArrayList<>();
        tempIdx.add(i);
        tempIdx.add(j);
        queue.add(tempIdx);

        //큐가 비어있지 않다면?
        while(!queue.isEmpty()){
            //remove해서 값 꺼내기
            tempIdx = queue.remove(0);
            int a = tempIdx.get(0);
            int b = tempIdx.get(1);

            //상하좌우 이동해서
            for(int k = 0; k < 4; k++){
                int newA = a + moveX[k];
                int newB = b + moveY[k];

                if (newA >= N) newA = N - 1;
                else if (newA < 0) newA = 0;

                if (newB >= N) newB = N - 1;
                else if (newB < 0) newB = 0;

                if(graph[newA][newB] == 1 && visited[newA][newB] == 0){
                    //System.out.println(i + " " + j + " | " +  " " + a + " " + b);
                    tempIdx = new ArrayList<>();
                    tempIdx.add(newA);
                    tempIdx.add(newB);
                    queue.add(tempIdx);

                    visited[newA][newB] = 1;
                    danji++;
                }
            }
        }
        return danji;
    }
}