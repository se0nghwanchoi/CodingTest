
import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static long[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

        arr = new long[n];
        long[]prefixSum = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        prefixSum[0] = arr[0];
        for(int i = 1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        long sum = prefixSum[m-1];

        for(int j = m; j<n; j++){
            long arrSum = prefixSum[j] - prefixSum[j-m];
            if(arrSum > sum){
                sum = arrSum;
            }
        }
        System.out.println(sum);
    }

}