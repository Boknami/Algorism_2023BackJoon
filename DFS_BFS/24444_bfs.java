import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int[] visited;
    static int cnt;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<Integer> queue = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        cnt = 1;

        for(int i = 0 ; i < N+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode =Integer.parseInt(st.nextToken());

            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }

        for(int i = 1 ; i < N+1; i++){
            Collections.sort(graph.get(i));
        }

        bfs(R);

        for(int i = 1 ; i < N+1; i++){
            System.out.println(visited[i]);
        }
    }

    public static void bfs(int R) {
        visited[R] = cnt;//방문 표시
        queue.add(R);
        while(!queue.isEmpty()){//큐가 비어있지 않다면!
            int target = queue.remove(0);
            //1-> 2  1->4
            for(int i = 0; i < graph.get(target).size(); i++){//인접한 정점들 방문
                int need_Judge = graph.get(target).get(i);
                //System.out.println(need_Judge);
                if(visited[need_Judge] == 0){//인접 & 방문X
                    cnt++;
                    visited[need_Judge] = cnt;
                    queue.add(need_Judge);
                }
            }
        }
    }
}