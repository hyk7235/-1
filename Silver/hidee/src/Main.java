import java.util.*;
import java.io.*;
public class Main {
    static int[] move = {-1,1,2};
    static int num = Integer.MAX_VALUE; // 몇번 만에 이동하였는가.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치
        Bfs(N,K);
        System.out.println(num);

    }
    static void Bfs(int start, int des){
        int [] field = new int[100_001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int now = q.poll();
            if (num < field[now]) {
                return;
            }
            if(field[now] <= num && now == des){
                num=field[now];

            }
            for(int i = 0; i<3; i++){
                int next = now;
                if(i==2)
                    next = now * move[i];

                else
                    next += move[i];
                if(next<100_001 && next>=0){
                    if(field[next] == 0 || field[next] >= field[now] + 1 ){// 중복방지 위한코드 뒤에 >= 쓰는이유는 나중에 이미 비교해서 값이들어가있는 배열을 탐방할때 현재 찾고있는단계보다 이전일경우 배제하기위해서 == 써도 상관없음 2단계를 건너뛰는경우가 없기때문
                        field[next] = field[now]+1;
                        q.offer(next);
                    }
                }

            }


        }



    }
}