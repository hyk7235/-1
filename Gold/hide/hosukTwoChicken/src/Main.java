import java.util.*;
import java.io.*;
public class Main {
    static int M,N,T,X;
    static int[][] arr;
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        arr = new int[N][N]; //2차원배열 정점의 수만큼 생성
        for(int i = 0; i<N; i++)
            for(int j = 0; j<N; j++) {
                arr[i][j] = 101;
            }

        for(int i = 0; i<M; i++) {
            StringTokenizer ss = new StringTokenizer(br.readLine());
            T = Integer.parseInt(ss.nextToken());
            X = Integer.parseInt(ss.nextToken());
            arr[T-1][X-1]=arr[X-1][T-1] =1;
        }
        for(int i = 0; i<N; i++)
            for(int j = 0; j<N; j++) {
                if (i == j) continue;
                for (int k = 0; k < N; k++) { //j 에서 k까지 가는데 i를 들려서 가면 얼마나 작은지;
                    if (i == k || j == k) continue;
                    if(arr[j][k]>arr[j][i]+arr[i][k]) arr[j][k] = arr[j][i]+ arr[i][k];
                }//여기까지가 플로이드 완성 // j->k j->i i->k 이걸 반복하면  jk까지의 거리최솟값이 나옴 결론 a-b-c-d-e이런식으로 거쳐간것을
                // a-e로 줄여서 표현
            }
        int min = Integer.MAX_VALUE;
        int c1 = 0;
        int c2 = 0;
        for(int i=0; i <N; i++)
            for(int j=0; j<N; j++) {
                if (i == j) continue;
                int now = bum(i,j);// 치킨집을 차릴 2개의 건물을 선택하는 경우를 다구하기위해 2중포문
                //그리고 선택한 2건물의로했을때의 거리를 now에 저장
                if(min>now) {
                    min = now;
                    c1 = i+1;
                    c2 = j+1;
                }
            }
        System.out.println(c1+" "+c2+" "+(min*2));
        }
       static int bum(int ch1, int ch2) {
        int sum = 0;
           for(int i=0; i<N; i++)
           {
            if(i == ch1 || i == ch2) continue;
            sum += Math.min(arr[ch1][i],arr[ch2][i]);// 선택한 두치킨 건물로부터 배달할 건물까지의 거리최솟값

           }
           return sum;
       }
    }
