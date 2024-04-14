import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static int [][] arr;
    static boolean[] check;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());//정점의 갯수
         M = Integer.parseInt(st.nextToken());//간선의 갯수
         V = Integer.parseInt(st.nextToken());//정점의 시작지점
      arr = new int[N+1][N+1];
        check = new boolean[N+1];
           for (int i = 0; i < M; i++) {
               StringTokenizer ss = new StringTokenizer(br.readLine());
               int now = Integer.parseInt(ss.nextToken());
               int next = Integer.parseInt(ss.nextToken());
               arr[now][next] = 1;
               arr[next][now] = 1;
       }
        Dfs(V);
       System.out.println("");
        check = new boolean[N+1];
       Bfs(V);
    }
    static void Dfs(int V )
    {
        check[V]= true;
        System.out.printf(V + " ");
        for(int i = 0; i<=N; i++){
            if(arr[V][i]==1 && !check[i])
                Dfs(i);
    }



    }
    static void Bfs(int V){

        q.offer(V);
        check[V]= true;
        while(!q.isEmpty()){
            V =q.poll();
            System.out.printf(V + " ");

            for(int i=0; i<=N; i++){
                if(arr[V][i] == 1 && !check[i]){
                    q.offer(i);
                    check[i] = true;
                }
            }
        }
    }

}

//arr[0]arr[1]arr[2]arr[3]
