
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        int[][] arrsum = new int[N+1][M+1];
        for (int i = 1; i<=N; i++){
            for(int j = 1; j <= M; j++){
                arrsum[i][j] = arr[i-1][j-1] + arrsum[i][j-1] + arrsum[i-1][j] - arrsum[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = arrsum[x][y] - arrsum[x][j-1] - arrsum[i-1][y] + arrsum[i-1][j-1];
            sb.append(sum).append("\n");
        }

        System.out.print(sb.toString());

    }
}