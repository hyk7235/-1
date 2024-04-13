import java.util.*;
import java.io.*;
public class Main {
    static  int num = Integer.MAX_VALUE; //가장 빠르게 도착하는 수
    static int[] arr = {-1,1,2};// 수빈이가 이동하기위한 배열
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); //수빈이 위치
      int K = Integer.parseInt(st.nextToken()); // 동생의 위치
        Bfs(N,K);//Bfs함수 호출
        System.out.println(num-1);
    }
    static void Bfs(int start, int des){
        Queue<Integer> q = new LinkedList<>();
        int[] field = new int[100001]; //돌아다닐 위치
        q.offer(start);
        field[start] = 1;// 제일 처음을 기준으로 시작지점의 *2된 부분이 0이 고정이되므로 그곳의 *2된부분들이 연속적으로 0이되어 탐방되지 않은 경우가 되기때문에 전체적으로 1을 더해준상태로 시작하고 후에 1을 빼준다.
        while(!q.isEmpty()){

            int now = q.poll();

            if(field[now] <= num && now==des)
                num = field[now];
            for(int i = 0; i<3; i++) {
                int next = now;
                if (i == 2)
                    next = now * arr[i];
                else
                    next = now + arr[i];
                if(next>=0 && next<=100_000) {
                    if (field[next] == 0 || field[next] >= field[now] + 1) {
                        if(next== now*2){
                            q.offer(next);
                            field[next] = field[now];
                        }
                        else{
                            field[next] = field[now] + 1;
                            q.offer(next);
                        }
                    }
                }
            }
        }
    }
}//후에 다른사람 정답비교하기


