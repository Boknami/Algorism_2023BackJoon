import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static int cnt;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        cnt = 1;

        //정점 숫자만큼 넓혀준다.
        for(int i =0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프에 정보 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start_dot = Integer.parseInt(st.nextToken());
            int end_dot = Integer.parseInt(st.nextToken());

            // 1->4 && 4->1
            graph.get(start_dot).add(end_dot);
            graph.get(end_dot).add(start_dot);
        }

        // 오름차순을 위해 정렬
        for(int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        dfs(R);
        for(int i = 1 ; i < N+1; i++){
            System.out.println(visited[i]);
        }
    }

    public static void dfs(int R) {  // V : 정점 집합, E : 간선 집합, R : 시작 정점
        visited[R] = cnt;

        //인접한 정점들을 어떻게 뽑아낼래?
        for(int i = 0 ; i  < graph.get(R).size();  i++){
            int newVertex = graph.get(R).get(i);
            if(visited[newVertex] == 0){
                cnt++;
                dfs(newVertex);
            }
        }
    }
}