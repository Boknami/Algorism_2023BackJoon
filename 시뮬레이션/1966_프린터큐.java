import java.io.*;
import java.util.*;

public class Main {
    static class Document{
        int prior;
        int isFind;
        public Document(int a, int b){
            this.prior =  a;
            this.isFind = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int doc = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            List<Document> ary = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < doc; j++){
                int value = Integer.parseInt(st.nextToken());
                if (j == target)
                    ary.add(new Document(value, 1));
                else
                    ary.add(new Document(value, 0));
            }

            int cnt = 0;
            while(true){
                Document curDoc = ary.remove(0);

                int max= 0;
                for(int m = 0 ; m < ary.size();m++){
                    max = Math.max(max, ary.get(m).prior);
                }

                if(max <= curDoc.prior) {
                    cnt++;
                    if(curDoc.isFind == 1){
                        System.out.println(cnt);
                        break;
                    }
                }
                else if(max != curDoc.prior)
                    ary.add(curDoc);
            }
        }
    }
}