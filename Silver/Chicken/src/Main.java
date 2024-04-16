import java.util.*;
import java.io.*;
public class Main {
    static int[][] arr;
    static int sum;
    static int N;
    static int result=0;
    static int M;
    static int[] combo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());//인원수
         M = Integer.parseInt(st.nextToken());//치킨의 종류
        arr = new int [N+1][M+1];

        for(int i=1; i<=N; i++){
            StringTokenizer ss = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++)
            {
                arr[i][j] = Integer.parseInt(ss.nextToken());
            }
        }
        combo = new int [4];
        maxFs(1,1);
        System.out.println(result);
    }
    static void maxFs(int cnt, int start){
       if(cnt==4) {
           sum = 0;
           for(int i=1; i<=N; i++){
               sum += getMax(i);
            }
           if(sum>result)
               result = sum;
           return;
       }
       for(int i=start; i<=M; i++){
           combo[cnt]= i;
           maxFs(cnt+1,i+1);
       }
//                [0],0 [1],1 [2],2// or [2],3 or [2],4  이런식으로 작동이됨 
//                [0],0 [1],2 [2].3 or [2].4
//                [0],0 [1],3 [2] 4
//                [0],1 [1],2 [2] 3 or [2] 4
//                [0],1 [1],3 [2] 4
//                [0],2 [1],3 [2] 4

    }
    static int getMax(int idx)
    {
        int max = 0;
        for(int i=1; i<4; i++){
            int temp = arr[idx][combo[i]];
            if(temp>max)
                max=temp;
        }
        return max;
    }
}