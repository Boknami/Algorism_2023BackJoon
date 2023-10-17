import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int won = 1000 - Integer.parseInt(br.readLine());
        int cnt = 0;
        int wons[] = {500,100,50,10,5,1};

        for(int i = 0 ; i < wons.length; i++){
            if(won >= wons[i]){
                cnt += won/wons[i];
                won = won%wons[i];
            }
        }
        System.out.print(cnt);
    }
}