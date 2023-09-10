import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    //한 단계씩 전파되는 개념이니까 BFS로 푸는 게 맞아보인다
    static int[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> que = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int computer = Integer.parseInt(st.nextToken());
        visited = new int[computer+1];

        st = new StringTokenizer(br.readLine());
        int connection = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < computer+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < connection; i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());

            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }

        BFS(1);

        int count = 0;
        for(int i = 1 ; i < computer+1; i++){
            int value = visited[i];
            if(value != 0) count++;
        }
        System.out.println(count-1);
    }

    public static void BFS(int startNode){
        visited[startNode] = 1;
        que.add(startNode);

        while (!que.isEmpty()){
            int currentNum = que.remove(0);
            //System.out.println(currentNum);
            for(int i = 0 ; i < graph.get(currentNum).size(); i++){
                int extractNum = graph.get(currentNum).get(i);
                //System.out.println(extractNum);
                if(visited[extractNum] == 0){
                    visited[extractNum] = 1;
                    que.add(extractNum);
                }
            }
        }
    }
}