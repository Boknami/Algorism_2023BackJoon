import java.io.*;
import java.util.*;

public class Main {
    static int subin;
    static int brother;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());

        BFS();
    }

    private static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];
        visited[subin] = 1;
        q.add(subin);
        int cnt = 0;

        //방문 여부를 체크하면서
        //계산을 할 떄에는 이 전 방문여부를 이용해서 갱신을 하긴 해야한다..
        //즉 갱신이 안되어있는것만 계산을 하고 싶다면..
        while(!q.isEmpty()) {
            int current = q.poll();

            if (current - 1 == brother) {
                visited[brother] = visited[current] + 1;
                break;
            }
            else if(current - 1 != brother && current - 1 <= 100000){
                q.add(current - 1);
                visited[current - 1] = visited[current] + 1;
            }

            if (current + 1 == brother) {
                visited[brother] = visited[current] + 1;
                break;
            }
            else if(current + 1 != brother && current + 1 <= 100000){
                q.add(current + 1);
                visited[current + 1] = visited[current] + 1;
            }

            if (current * 2 == brother) {
                visited[brother] = visited[current] + 1;
                break;
            }
            else if(current *2 != brother && current * 2 <= 100000){
                q.add(current * 2);
                visited[current * 2] = visited[current] + 1;
            }
        }
        System.out.println(visited[brother]);
    }
}
