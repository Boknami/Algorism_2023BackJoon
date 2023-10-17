import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            B[i] = Integer.parseInt(st.nextToken());

        //목표 : 계산해서 나오는 값을 "최소" 구하기
        //A를 재배열해서 최소를 구해야한다.
        //어떤 경우에 최소가 나올까? 음이 아니니까
        // => B에 큰 수에 A의 작은 수를 배치, B가장 큰 수 * 0 해버리면 됌
        //A는 오름차순
        //B는 내림차순하면 B는 순서가 바뀌게 되지만 사실 상관없다 A가 B에 붙는다 생각하면 똑같음

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int ans = 0;
        for(int i = 0; i < N; i++)
            ans += A[i] * B[i];
        System.out.println(ans);
    }
}