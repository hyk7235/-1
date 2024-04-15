import java.util.*;
import java.io.*;
public class Main {
    static int[] arr;
    static int max=0;
    static int tmm=0;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //가지고 있는 카드의 갯수
        int M = Integer.parseInt(st.nextToken());// 주어진 숫자
       arr= new int[N+1];
        StringTokenizer ss = new StringTokenizer(br.readLine());
       for(int i=1; i<=N; i++){
            arr[i]=Integer.parseInt((ss.nextToken()));
        }
        fs(M,N);
        System.out.println(max);
    }
    static void fs(int M, int N){
        for(int i=1; i<=N; i++) {
            for (int j = i+1; j <= N; j++) {
                for(int x = j+1; x<=N; x++){
                    tmm = arr[i] + arr[j] + arr[x];
                if(tmm <= M && max<tmm)  {
                    max = tmm;
                    }
                }

            }
        }
    }
}