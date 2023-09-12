import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int[] visited;
    static int cnt;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        visited = new int[N+1];
        cnt = 1;

        for(int i = 0 ; i < N+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M; i++){
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }

        for(int i = 1 ; i < N+1; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(R);

        for(int i = 1 ; i < N+1; i++){
            System.out.println(visited[i]);
        }
    }

    public static void dfs(int R) {
        visited[R] = cnt;//방문 표시
        for(int i = 0; i < graph.get(R).size(); i++){//현재 노드에서 방문할 수 있는 것들 전~부
            if(visited[graph.get(R).get(i)]== 0){
                cnt++;
                dfs(graph.get(R).get(i));
            }
        }
    }
}